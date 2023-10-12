package com.generativeai.BookStore.service;

import com.generativeai.BookStore.models.Author;
import com.generativeai.BookStore.models.Book;
import com.generativeai.BookStore.models.Genre;
import com.generativeai.BookStore.repository.AuthorRepository;
import com.generativeai.BookStore.repository.BookRepository;
import com.generativeai.BookStore.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private final GenreRepository genreRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id){
        return bookRepository.findById(id);
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }
    public Optional<Book> getBookByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public List<Book> getBookByAuthor(String authorFirstName){
        Author author = authorRepository.findByFirstName(authorFirstName);
        if(author != null){
            return bookRepository.findByAuthor(author);
        }
        return null;


    }

    public List<Book> getBookByGenre(String genreName){
        Optional<Genre> genre = genreRepository.findGenreByName(genreName);
        if(genre.isPresent()){
           return bookRepository.findByGenre(genre.get());
        }
        return null;
    }
}
