package net.mephys.arkheion.xml.db.service;

import net.mephys.arkheion.xml.db.model.Book;

import java.util.List;

public interface XmlBookService {

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