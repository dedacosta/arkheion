package net.mephys.arkheion.catalog.service;

import net.mephys.arkheion.catalog.model.Book;

import java.util.List;

public interface BookCatalogService {

    // CREATE
    void insert(Book book);

    // READ All
    List<Book> getBooks();

    // READ
    Book getBook(Integer id);

    // DELETE
    void deleteBook(Integer bookId);

    // DELETE
    void deleteAllBook();

}