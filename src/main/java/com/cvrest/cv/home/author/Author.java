package com.cvrest.cv.home.author;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
    @Id
    private String id;
    private String firstname;
    private String lastname;


    public Author(String firstname, String lastname, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public Author() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFullName() {
        return this.getFirstname() + " " + this.getLastname();
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
