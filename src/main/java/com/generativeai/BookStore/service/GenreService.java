package com.generativeai.BookStore.service;

import com.generativeai.BookStore.models.Genre;
import com.generativeai.BookStore.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(int id) {
        return genreRepository.findById(id).orElse(null);
    }

    public void addGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void updateGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void deleteGenre(int id) {
        genreRepository.deleteById(id);
    }
}
