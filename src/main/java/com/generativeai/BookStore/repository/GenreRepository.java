package com.generativeai.BookStore.repository;

import com.generativeai.BookStore.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    public Optional<Genre> findGenreByName(String name);
}
