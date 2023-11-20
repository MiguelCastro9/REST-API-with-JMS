package com.api.service;

import com.api.dto.response.NotificationResponseDto;
import com.api.exception.MessageCustomException;
import com.api.jms.sender.JmsSender;
import com.api.model.PersonModel;
import com.api.repository.PersonRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

    private List<NotificationResponseDto> notifications = new ArrayList<>();

    public PersonModel save(PersonModel personModel) {

        personRepository.save(personModel);
        sender.sendMessage("a new user has been saved!");
        notifications.add(new NotificationResponseDto("a new user has been saved!", LocalDateTime.now()));
        return personModel;
    }

    public List<PersonModel> list() {
    return personRepository.findAll()
            .stream()
            .sorted(Comparator.comparing(PersonModel::getId, Comparator.reverseOrder()))
            .collect(Collectors.toList());
}

    public Optional<PersonModel> find(String id) {
        return personRepository.findById(id);
    }

    public PersonModel update(String id, PersonModel person) {
        return personRepository.findById(id)
                .map(existingPerson -> {
                    existingPerson.setName(person.getName());
                    existingPerson.setBirth_date(person.getBirth_date());
                    sender.sendMessage("a new user has been updated!");
                    notifications.add(new NotificationResponseDto("a new user has been updated!", LocalDateTime.now()));
                    return personRepository.save(existingPerson);
                })
                .orElseThrow(() -> new MessageCustomException("Person not found."));
    }

    public void delete(String id) {
        personRepository.findById(id)
                .ifPresentOrElse(
                        personModel -> {
                            personRepository.deleteById(id);
                            sender.sendMessage("a new user has been deleted!");
                            notifications.add(new NotificationResponseDto("a new user has been deleted!", LocalDateTime.now()));
                        },
                        () -> {
                            throw new MessageCustomException("Person not found.");
                        }
                );
    }

    public List<NotificationResponseDto> getNotifications() {
        return notifications.stream()
                .sorted((n1, n2) -> n2.getMessage_date().compareTo(n1.getMessage_date()))
                .toList();
    }
}
