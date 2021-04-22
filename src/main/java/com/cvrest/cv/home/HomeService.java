package com.cvrest.cv.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    private HomeRepository homeRepository;

    @Autowired
    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public List<Project> getAll() {
        // List<Author> authors = new ArrayList<>();
        // Author author1 = new Author("Anas", "Zabili");
        // Author author2 = new Author("David", "Deschamps");
        // authors.add(author1);
        // authors.add(author2);
        //
        // return new Project("cv rest", 1.0, authors,
        // "https://upload.wikimedia.org/wikipedia/commons/d/df/Université_de_Rouen.png");
        return homeRepository.findAll();
    }

    public void addProjet(Project projet) {
        homeRepository.insert(projet);
    }

}
