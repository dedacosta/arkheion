package net.mephys.arkheion.api.service.impl;

import net.mephys.arkheion.api.model.Book;
import net.mephys.arkheion.api.repository.BookRepository;
import net.mephys.arkheion.api.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CREATE
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // READ All
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    // READ
    public Book getBook(Integer id) {
        return bookRepository.getReferenceById(id);
    }

    // DELETE
    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book updateBook(Integer id, Book bookDetails) {
        Book book = bookRepository.findById(id).get();
        return bookRepository.save(book);
    }
}