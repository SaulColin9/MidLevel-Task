package com.generativeai.BookStore.controller;

import com.generativeai.BookStore.models.Genre;
import com.generativeai.BookStore.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/genres")
@RestController
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/getGenres")
    public List<Genre> listGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/getGenre/{id}")
    public Genre getGenre(@PathVariable int id) {
        return genreService.getGenreById(id);
    }

    @PostMapping("/addGenre")
    public void addGenre(@RequestBody Genre genre) {
        genreService.addGenre(genre);
    }

    @PutMapping("/updateGenre/{id}")
    public void updateGenre(@PathVariable int id, @RequestBody Genre genre) {
        genre.setId(id);
        genreService.updateGenre(genre);
    }

    @DeleteMapping("/deleteGenre/{id}")
    public void deleteGenre(@PathVariable int id) {
        genreService.deleteGenre(id);
    }
}
