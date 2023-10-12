package com.generativeai.BookStore.controller;

import com.generativeai.BookStore.models.Genre;
import com.generativeai.BookStore.service.GenreService;
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
class GenreControllerTest {

    @InjectMocks
    private GenreController genreController;

    @Mock
    private GenreService genreService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        // Set up any necessary preconditions for your tests
    }

    @Test
    void testListGenres() throws Exception {
        when(genreService.getAllGenres()).thenReturn(Collections.singletonList(new Genre()));

        mockMvc.perform(MockMvcRequestBuilders.get("/genres/getGenres"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").exists());
    }


    @Test
    void testAddGenre() throws Exception {
        mockMvc.perform(post("/genres/addGenre")
                        .content("{\"name\": \"Sample Genre\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Add any assertions you need to verify the behavior.
    }


    @Test
    void testDeleteGenre() throws Exception {
        Integer genreId = 1;

        mockMvc.perform(delete("/genres/deleteGenre/{id}", genreId))
                .andExpect(status().isOk());

        // Add any assertions you need to verify the behavior.
    }
}
