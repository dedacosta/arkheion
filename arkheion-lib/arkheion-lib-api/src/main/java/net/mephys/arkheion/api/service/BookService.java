package net.mephys.arkheion.api.service;

import net.mephys.arkheion.api.model.Book;

import java.util.List;

public interface BookService {

    // CREATE
    Book createBook(Book book);

    // READ All
    List<Book> getBooks();

    // READ
    Book getBook(Integer id);

    // DELETE
    void deleteBook(Integer bookId);

    Book updateBook(Integer id, Book bookDetails);
}