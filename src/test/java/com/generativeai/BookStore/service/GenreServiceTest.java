package com.generativeai.BookStore.service;

import com.generativeai.BookStore.models.Genre;
import com.generativeai.BookStore.repository.GenreRepository;
import com.generativeai.BookStore.service.GenreService;
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
class GenreServiceTest {

    @InjectMocks
    private GenreService genreService;

    @Mock
    private GenreRepository genreRepository;

    @BeforeEach
    void setUp() {
        // Set up any necessary preconditions for your tests
    }

    @Test
    void testGetAllGenres() {
        when(genreRepository.findAll()).thenReturn(Collections.singletonList(new Genre()));

        List<Genre> genres = genreService.getAllGenres();
        assertEquals(1, genres.size());

        // Add any other assertions you need to verify the behavior.
    }

    @Test
    void testGetGenreById() {
        Integer genreId = 1;
        Genre genre = new Genre(); // Create a sample Genre object
        when(genreRepository.findById(genreId)).thenReturn(Optional.of(genre));

        Genre result = genreService.getGenreById(genreId);
        assertEquals(genre, result);

        // Add any other assertions you need to verify the behavior.
    }

    @Test
    void testAddGenre() {
        Genre genre = new Genre(); // Create a sample Genre object
        genreService.addGenre(genre);

        // Verify that the genreRepository's save method was called with the mock Genre
        verify(genreRepository).save(genre);
    }

    @Test
    void testUpdateGenre() {
        Genre genre = new Genre(); // Create a sample Genre object
        genreService.updateGenre(genre);

        // Verify that the genreRepository's save method was called with the mock Genre
        verify(genreRepository).save(genre);
    }

    @Test
    void testDeleteGenre() {
        Integer genreId = 1;
        genreService.deleteGenre(genreId);

        // Verify that the genreRepository's deleteById method was called with the ID
        verify(genreRepository).deleteById(genreId);
    }
}
