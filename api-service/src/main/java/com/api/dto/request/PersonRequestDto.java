package com.api.dto.request;

import com.api.model.PersonModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Miguel Castro
 */
public class PersonRequestDto {
    
    private String id;

    @NotBlank(message = "Name is required.")
    @Length(min = 3, max = 40, message = "Name required at minimum {min} and at maximum {max} characters.")
    private String name;
    
    @NotNull(message = "Birth date is required.")
    private String birth_date;
    
    public PersonModel convertPersonDtoForEntity() {
        return new PersonModel(name, birth_date);
    }
    
    public PersonModel convertPersonUpdateDtoForEntity() {
        return new PersonModel(id, name, birth_date);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "PersonRequestDto{" + "id=" + id + ", name=" + name + ", birth_date=" + birth_date + '}';
    }
}
