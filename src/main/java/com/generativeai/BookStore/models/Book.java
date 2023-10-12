package com.generativeai.BookStore.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "genre_id")
    private Integer genreId;
    @Column(nullable = false)
    private Double price;
    @Column(name = "quantity_available", nullable = false)
    private int quantityAvailable;

    @OneToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Author author;
    public Book() {
    }

    public Book(String title, int authorId, Integer genreId, Double price, int quantityAvailable) {
        this.title = title;
        this.authorId = authorId;
        this.genreId = genreId;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public int getId() {
        return id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

}
