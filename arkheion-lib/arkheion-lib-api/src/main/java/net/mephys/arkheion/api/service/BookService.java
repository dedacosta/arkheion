package net.mephys.arkheion.api.service;

import net.mephys.arkheion.api.model.Book;
import net.mephys.arkheion.api.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    // CREATE
    public Book createBook(Book book);

    // READ All
    public List<Book> getBooks();

    // READ
    public Book getBook(Integer id);

    // DELETE
    public void deleteBook(Integer bookId);

    public Book updateBook(Integer id, Book bookDetails);
}