package com.api.controller;

import com.api.dto.PersonRequestDto;
import com.api.dto.PersonResponseDto;
import com.api.exception.MessageCustomException;
import com.api.model.PersonModel;
import com.api.service.PersonService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private PersonService personService;

    @PostMapping("/save")
    public ResponseEntity<PersonResponseDto> save(@Valid @RequestBody PersonRequestDto personRequestDto) {
        PersonModel personModel = personService.save(personRequestDto.convertPersonDtoForEntity());
        return new ResponseEntity<PersonResponseDto>(PersonResponseDto.convertEntityForPersonDto(personModel), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PersonResponseDto>> list() {
        return new ResponseEntity<List<PersonResponseDto>>(
                personService.list().stream().map(person
                        -> PersonResponseDto.convertEntityForPersonDto(person))
                        .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable String id) {
        return new ResponseEntity<>(personService.find(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonResponseDto> update(@PathVariable String id, @Valid @RequestBody PersonRequestDto personRequestDto) throws Exception {
        try {
            PersonModel personModel = personService.update(id, personRequestDto.convertPersonDtoForEntity());
            return new ResponseEntity<>(PersonResponseDto.convertEntityForPersonDto(personModel), HttpStatus.OK);
        } catch (MessageCustomException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        personService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
