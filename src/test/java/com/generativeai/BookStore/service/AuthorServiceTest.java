package com.generativeai.BookStore.service;

import com.generativeai.BookStore.models.Author;
import com.generativeai.BookStore.repository.AuthorRepository;
import com.generativeai.BookStore.service.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class AuthorServiceTest {

    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        // Set up any necessary preconditions for your tests
    }

    @Test
    void testGetAllAuthors() {
        when(authorRepository.findAll()).thenReturn(Collections.singletonList(new Author()));

        List<Author> authors = authorService.getAllAuthors();
        assertEquals(1, authors.size());

        // Add any other assertions you need to verify the behavior.
    }

    @Test
    void testGetAuthorById() {
        Integer authorId = 1;
        Author author = new Author(); // Create a sample Author object
        when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));

        Author result = authorService.getAuthorById(authorId);
        assertEquals(author, result);

        // Add any other assertions you need to verify the behavior.
    }

    @Test
    void testAddAuthor() {
        Author author = new Author(); // Create a sample Author object
        authorService.addAuthor(author);

        // Verify that the authorRepository's save method was called with the mock Author
        verify(authorRepository).save(author);
    }

    @Test
    void testUpdateAuthor() {
        Author author = new Author(); // Create a sample Author object
        authorService.updateAuthor(author);

        // Verify that the authorRepository's save method was called with the mock Author
        verify(authorRepository).save(author);
    }

    @Test
    void testDeleteAuthor() {
        Integer authorId = 1;
        authorService.deleteAuthor(authorId);

        // Verify that the authorRepository's deleteById method was called with the ID
        verify(authorRepository).deleteById(authorId);
    }
}
