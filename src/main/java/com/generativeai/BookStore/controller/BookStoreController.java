package com.generativeai.BookStore.controller;

import com.generativeai.BookStore.models.Book;
import com.generativeai.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/books")
public class BookStoreController {
    @Autowired
    private BookService bookService;
    @GetMapping("/getBook/{id}")
    public Optional<Book> getBook(@PathVariable(value = "id") Integer id){
        return bookService.getBookById(id);
    }

    @GetMapping("/getBooks")
    public List<Book> getBooks(){
        return (List<Book>) bookService.getAllBooks();
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book){
        bookService.saveBook(book);
    }

    @PutMapping("/editBook")
    public void updateBook(@RequestBody Book book){
        bookService.saveBook(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable(value = "id") Integer id){
        bookService.deleteBook(id);
    }

    @PostMapping("/getBookByTitle")
    public Object getBookByTitle(@RequestBody Map<String, Object> title){
        return bookService.getBookByTitle(title.get("title").toString());
    }
    @PostMapping("/getBookByAuthor")
    public Object getBookByAuthor(@RequestBody Map<String, Object> author){
        return bookService.getBookByAuthor(author.get("author").toString());
    }
    @PostMapping("/getBookByGenre")
    public Object getBookByGenre(@RequestBody Map<String, Object> genre){
        return bookService.getBookByGenre(genre.get("genre").toString());
    }
}
