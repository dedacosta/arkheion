package net.mephys.arkheion.catalog.service;

import net.mephys.arkheion.catalog.model.Book;

import java.util.List;

public interface BookCatalogService {

    // CREATE
    public void insert(Book book);

    // READ All
    public List<Book> getBooks();

    // READ
    public Book getBook(Integer id);

    // DELETE
    public void deleteBook(Integer bookId);

    // DELETE
    public void deleteAllBook();

    public void updateBook(Integer bookId, Book bookDetails);

}