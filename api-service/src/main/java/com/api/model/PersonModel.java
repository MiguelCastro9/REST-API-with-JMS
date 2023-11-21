package com.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Miguel Castro
 */
@Document(collection = "Person")
public class PersonModel {

    @Id
    // (String) because I use MongoDB
    private String id;
    
    private String name;
    
    private String birth_date;

    public PersonModel() {
    }

    public PersonModel(String name, String birth_date) {
        this.name = name;
        this.birth_date = birth_date;
    }
    
    public PersonModel(String id, String name, String birth_date) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
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
}
