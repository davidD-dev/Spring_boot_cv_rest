package com.cvrest.cv.home.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(path = "/authors")
    public void addauthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @GetMapping("/authors")
    public List<Author> getAuthors () {
        return authorService.getAll();

    }
}
