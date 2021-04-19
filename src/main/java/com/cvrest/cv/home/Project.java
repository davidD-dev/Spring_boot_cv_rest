package com.cvrest.cv.home;

import com.cvrest.cv.home.author.Author;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Project {

    @Id
    private String name;
    private double version;

    @OneToMany
    private List<Author> authors;
    private String logo;

    public Project() {
    }

    public Project(String name, double version, List<Author> authors, String logo) {
        this.name = name;
        this.version = version;
        this.authors = authors;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
