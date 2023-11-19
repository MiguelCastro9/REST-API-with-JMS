package com.api.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Miguel Castro
 */
@Document(collection = "Person")
public class PersonModel {

    @Id
    private Long id;
    
    private String name;
    
    private Date birth_date;

    public PersonModel() {
    }

    public PersonModel(Long id, String name, Date birth_date) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
