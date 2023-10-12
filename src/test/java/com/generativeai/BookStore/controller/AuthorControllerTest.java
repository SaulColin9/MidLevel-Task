package com.generativeai.BookStore.controller;

import com.generativeai.BookStore.models.Author;
import com.generativeai.BookStore.service.AuthorService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class AuthorControllerTest {

    @InjectMocks
    private AuthorController authorController;

    @Mock
    private AuthorService authorService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        // Set up any necessary preconditions for your tests
    }

    @Test
    void testListAuthors() throws Exception {
        when(authorService.getAllAuthors()).thenReturn(Collections.singletonList(new Author()));

        mockMvc.perform(MockMvcRequestBuilders.get("/authors/getAuthors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").exists());
    }


    @Test
    void testAddAuthor() throws Exception {
        mockMvc.perform(post("/authors/addAuthor")
                        .content("{\"name\": \"Sample Author\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Add any assertions you need to verify the behavior.
    }


    @Test
    void testDeleteAuthor() throws Exception {
        Integer authorId = 1;

        mockMvc.perform(delete("/authors/deleteAuthor/{id}", authorId))
                .andExpect(status().isOk());

        // Add any assertions you need to verify the behavior.
    }
}

