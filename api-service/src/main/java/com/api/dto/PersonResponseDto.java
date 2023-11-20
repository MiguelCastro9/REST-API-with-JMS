package com.api.dto;

import com.api.model.PersonModel;
import java.util.Date;

/**
 *
 * @author Miguel Castro
 */
public class PersonResponseDto {
    
    private String id;
    
    private String name;
    
    private Date birth_date;

    public PersonResponseDto(String id, String name, Date birth_date) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
    }
    
    public static PersonResponseDto convertEntityForPersonDto(PersonModel personModel) {
        return new PersonResponseDto(personModel.getId(), personModel.getName(), 
                personModel.getBirth_date());
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

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }
}
