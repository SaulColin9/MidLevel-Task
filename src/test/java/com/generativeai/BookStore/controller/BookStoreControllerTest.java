package com.generativeai.BookStore.controller;

import com.generativeai.BookStore.models.Book;
import com.generativeai.BookStore.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class BookStoreControllerTest {

    @InjectMocks
    private BookStoreController bookStoreController;

    @Mock
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        // Set up any necessary preconditions for your tests
    }

    @Test
    void testGetBook() throws Exception {
        Integer bookId = 1;
        Book book = new Book(); // Create a sample Book object
        when(bookService.getBookById(bookId)).thenReturn(Optional.of(book));

        mockMvc.perform(MockMvcRequestBuilders.get("/books/getBook/{id}", bookId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists());
    }

    @Test
    void testGetBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(Collections.singletonList(new Book()));

        mockMvc.perform(MockMvcRequestBuilders.get("/books/getBooks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").exists());
    }

    @Test
    void testAddBook() throws Exception {
        Book book = new Book(); // Create a sample Book object
        mockMvc.perform(post("/books/addBook")
                        .content("{\"title\": \"Sample Title\", \"author\": \"Sample Author\", \"genre\": \"Sample Genre\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Add any assertions you need to verify the behavior.
    }

    @Test
    void testUpdateBook() throws Exception {
        Integer bookId = 1;
        Book book = new Book(); // Create a sample Book object
        when(bookService.getBookById(bookId)).thenReturn(Optional.of(book));

        mockMvc.perform(MockMvcRequestBuilders.put("/books/editBook")
                        .content("{\"id\": 1, \"title\": \"Updated Title\", \"author\": \"Updated Author\", \"genre\": \"Updated Genre\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Add any assertions you need to verify the behavior.
    }

    @Test
    void testDeleteBook() throws Exception {
        Integer bookId = 1;

        mockMvc.perform(MockMvcRequestBuilders.delete("/books/deleteBook/{id}", bookId))
                .andExpect(status().isOk());

        // Add any assertions you need to verify the behavior.
    }


    @Test
    void testGetBookByAuthor() throws Exception {
        String author = "Sample Author";
        when(bookService.getBookByAuthor(author)).thenReturn(Collections.singletonList(new Book()));

        mockMvc.perform(post("/books/getBookByAuthor")
                        .content("{\"author\": \"Sample Author\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].author").exists());
    }

    @Test
    void testGetBookByGenre() throws Exception {
        String genre = "Sample Genre";
        when(bookService.getBookByGenre(genre)).thenReturn(Collections.singletonList(new Book()));

        mockMvc.perform(post("/books/getBookByGenre")
                        .content("{\"genre\": \"Sample Genre\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].genre").exists());
    }

}
