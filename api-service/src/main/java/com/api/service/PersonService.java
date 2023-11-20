package com.api.service;

import com.api.exception.MessageCustomException;
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

    public PersonModel save(PersonModel personModel) {
        return personRepository.save(personModel);
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
                    return personRepository.save(existingPerson);
                })
                .orElseThrow(() -> new MessageCustomException("Person not found."));
    }

    public void delete(String id) {
        personRepository.deleteById(id);
    }
}
