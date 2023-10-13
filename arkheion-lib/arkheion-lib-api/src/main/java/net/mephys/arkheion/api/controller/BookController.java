package net.mephys.arkheion.api.controller;

import net.mephys.arkheion.api.dto.BookDTO;
import net.mephys.arkheion.api.model.Book;
import net.mephys.arkheion.api.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BookController {

    private final BookService bookService;

    public  BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "books", produces = "application/json")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(path = "book/{id}", produces = "application/json")
    public Book getBook(@PathVariable Integer id) {
        return bookService.getBook(id);
    }

    @PostMapping("book")
    public Book postBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setBookId(bookDTO.getBookId());
        book.setTitle(bookDTO.getTitle());
        book.setIsbn13(bookDTO.getIsbn13());
        return book;
    }

    @DeleteMapping(path = "book/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

}
