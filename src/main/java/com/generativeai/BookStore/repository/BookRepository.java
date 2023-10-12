package com.generativeai.BookStore.repository;

import com.generativeai.BookStore.models.Author;
import com.generativeai.BookStore.models.Book;
import com.generativeai.BookStore.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitle(String title);
    List<Book> findByAuthor(Author author);
    List<Book> findByGenre(Genre genre);

}
