package com.zsgwsjj.jiang.model;

/**
 * @author : jiang
 * @time : 2018/3/22 16:29
 */
public class Book {
    private Integer id;
    private String bookName;
    private String isbn;
    private int price;
    private int stock;

    public Book(Integer id, String bookName, String isbn, int price, int stock) {
        this.id = id;
        this.bookName = bookName;
        this.isbn = isbn;
        this.price = price;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public Book setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Book setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getStock() {
        return stock;
    }

    public Book setStock(int stock) {
        this.stock = stock;
        return this;
    }
}
