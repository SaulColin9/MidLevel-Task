package com.generativeai.BookStore.service;

import com.generativeai.BookStore.models.Author;
import com.generativeai.BookStore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    // Get all authors
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Get an author by ID
    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    // Add a new author
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    // Update an existing author
    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    // Delete an author by ID
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}
