package com.generativeai.BookStore.service;

import com.generativeai.BookStore.models.Author;
import com.generativeai.BookStore.models.Book;
import com.generativeai.BookStore.models.Genre;
import com.generativeai.BookStore.repository.AuthorRepository;
import com.generativeai.BookStore.repository.BookRepository;
import com.generativeai.BookStore.repository.GenreRepository;
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
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private GenreRepository genreRepository;

    @BeforeEach
    void setUp() {
        // Set up any necessary preconditions for your tests
    }

    @Test
    void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(Collections.singletonList(new Book()));

        List<Book> books = bookService.getAllBooks();
        assertEquals(1, books.size());

        // Add any other assertions you need to verify the behavior.
    }

    @Test
    void testGetBookById() {
        Integer bookId = 1;
        Book book = new Book(); // Create a sample Book object
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        Optional<Book> result = bookService.getBookById(bookId);
        assertEquals(Optional.of(book), result);

        // Add any other assertions you need to verify the behavior.
    }

    @Test
    void testSaveBook() {
        Book book = new Book(); // Create a sample Book object
        bookService.saveBook(book);

        // Verify that the bookRepository's save method was called with the mock Book
        verify(bookRepository).save(book);
    }

    @Test
    void testDeleteBook() {
        Integer bookId = 1;
        bookService.deleteBook(bookId);

        // Verify that the bookRepository's deleteById method was called with the ID
        verify(bookRepository).deleteById(bookId);
    }

    @Test
    void testGetBookByTitle() {
        String title = "Sample Title";
        when(bookRepository.findByTitle(title)).thenReturn(Optional.of(new Book()));

        Optional<Book> result = bookService.getBookByTitle(title);
        assertEquals(Optional.of(new Book()), result);

        // Add any other assertions you need to verify the behavior.
    }

    @Test
    void testGetBookByAuthor() {
        String authorFirstName = "Sample Author";
        Author author = new Author(); // Create a sample Author object
        when(authorRepository.findByFirstName(authorFirstName)).thenReturn(author);
        when(bookRepository.findByAuthor(author)).thenReturn(Collections.singletonList(new Book()));

        List<Book> result = bookService.getBookByAuthor(authorFirstName);
        assertEquals(1, result.size());

        // Add any other assertions you need to verify the behavior.
    }

    @Test
    void testGetBookByGenre() {
        String genreName = "Sample Genre";
        Genre genre = new Genre(); // Create a sample Genre object
        when(genreRepository.findGenreByName(genreName)).thenReturn(Optional.of(genre));
        when(bookRepository.findByGenre(genre)).thenReturn(Collections.singletonList(new Book()));

        List<Book> result = bookService.getBookByGenre(genreName);
        assertEquals(1, result.size());

        // Add any other assertions you need to verify the behavior.
    }
}
