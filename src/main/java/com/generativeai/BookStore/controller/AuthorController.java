package com.generativeai.BookStore.controller;

import com.generativeai.BookStore.models.Author;
import com.generativeai.BookStore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/authors")
@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/getAuthors")
    public List<Author> listAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/getAuthor/{id}")
    public Author getAuthor(@PathVariable int id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/addAuthor")
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @PutMapping("/updateAuthor/{id}")
    public void updateAuthor(@PathVariable int id, @RequestBody Author author) {
        author.setId(id);
        authorService.updateAuthor(author);
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public void deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
    }
}
