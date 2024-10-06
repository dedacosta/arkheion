package net.mephys.arkheion.xml.db.controller;


import net.mephys.arkheion.xml.db.dto.BookDTO;
import net.mephys.arkheion.xml.db.model.Book;
import net.mephys.arkheion.xml.db.service.XmlBookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/xml")
public class XmlBookController {

    private final XmlBookService xmlBookService;

    public XmlBookController(XmlBookService xmlBookService) {
        this.xmlBookService = xmlBookService;
    }

    @GetMapping(path = "books", produces = "application/json")
    public List<Book> getBooks() {
        return xmlBookService.getBooks();
    }

    @GetMapping(path = "book/{id}", produces = "application/json")
    public Book getBook(@PathVariable Integer id) {
        return xmlBookService.getBook(id);
    }

    @PostMapping(path = "book")
    public void createBook(@RequestBody BookDTO bookDTO) {
        Book book = toBook(bookDTO);
        if (book != null)
            xmlBookService.insert(book);
    }

    @PostMapping(path = "books")
    public void importBooks(@RequestBody List<BookDTO> books) {
        books.stream().forEach(bookDTO -> {
            Book book = toBook(bookDTO);
            if (book != null)
                xmlBookService.insert(book);
        });
    }

//@Put

    @DeleteMapping(path = "book/{id}")
    public void deleteBook(@PathVariable Integer id) {
        xmlBookService.deleteBook(id);
    }

    @DeleteMapping(path = "books")
    public void deleteBooks() {
        xmlBookService.deleteAllBook();
    }

    private Book toBook(BookDTO bookDTO) {
        Book book = null;
        if (!bookDTO.getTitle().isEmpty()) {
            book = new Book();
            book.setTitle(bookDTO.getTitle());
            book.setAuthors(Arrays.asList(bookDTO.getAuthors()));
            book.setISBN(bookDTO.getIsbn());
            book.setPublisher(bookDTO.getPublisher());
            book.setPublicationYear(bookDTO.getPublicationYear());
            book.setEdition(bookDTO.getEdition());
            book.setPages(bookDTO.getPages());
            book.setLanguage(bookDTO.getLanguage());
            book.setGenre(bookDTO.getGenre());
            book.setNumber(bookDTO.getNumber());
        }
        return book;
    }
}
