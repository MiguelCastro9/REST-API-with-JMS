package com.api.controller;

import com.api.model.PersonModel;
import com.api.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Castro
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/save")
    public PersonModel save(@RequestBody PersonModel personModel) {
        return personRepository.save(personModel);
    }

    @GetMapping("/list")
    public List<PersonModel> list() {
        return personRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<PersonModel> find(@PathVariable Long id) {
        return personRepository.findById(id);
    }

    @PutMapping("/update")
    public PersonModel update(@RequestBody PersonModel personModel) {
        return personRepository.save(personModel);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

}
