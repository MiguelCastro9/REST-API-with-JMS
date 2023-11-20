package com.api.service;

import com.api.exception.MessageCustomException;
import com.api.jms.sender.JmsSender;
import com.api.model.PersonModel;
import com.api.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private JmsSender sender;

    public PersonModel save(PersonModel personModel) {

        personRepository.save(personModel);
        sender.sendMessage("saved successfully!");
        return personModel;
    }

    public List<PersonModel> list() {
        return personRepository.findAll();
    }

    public Optional<PersonModel> find(String id) {
        return personRepository.findById(id);
    }

    public PersonModel update(String id, PersonModel person) {
        return personRepository.findById(id)
                .map(existingPerson -> {
                    existingPerson.setName(person.getName());
                    existingPerson.setBirth_date(person.getBirth_date());
                    sender.sendMessage("updated successfully!");
                    return personRepository.save(existingPerson);
                })
                .orElseThrow(() -> new MessageCustomException("Person not found."));
    }

    public void delete(String id) {
        personRepository.findById(id)
                .ifPresentOrElse(
                        personModel -> {
                            personRepository.deleteById(id);
                            sender.sendMessage("deleted successfully!");
                        },
                        () -> {
                            throw new MessageCustomException("Person not found.");
                        }
                );
    }
}
