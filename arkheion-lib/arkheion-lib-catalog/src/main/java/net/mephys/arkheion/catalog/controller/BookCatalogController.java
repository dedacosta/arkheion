package net.mephys.arkheion.catalog.controller;

import net.mephys.arkheion.catalog.dto.BookDTO;
import net.mephys.arkheion.catalog.dto.BookResponseDTO;
import net.mephys.arkheion.catalog.exception.CatalogItemNotFoundException;
import net.mephys.arkheion.catalog.model.Book;
import net.mephys.arkheion.catalog.service.BookCatalogService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/catalog")
public class BookCatalogController {

    private final BookCatalogService bookCatalogService;
    private final ModelMapper modelMapper;

    public BookCatalogController(BookCatalogService bookCatalogService, ModelMapper modelMapper) {
        this.bookCatalogService = bookCatalogService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "books", produces = "application/json")
    public List<BookResponseDTO> getBooks() {
        List<Book> books = bookCatalogService.getBooks();
        List<BookResponseDTO> bookResponseDTOList = books.stream()
                .map(book -> modelMapper.map(book, BookResponseDTO.class))
                .toList();
        return bookResponseDTOList;
    }

    @GetMapping(path = "books/raw", produces = "application/json")
    public List<Book> dump() {
        return bookCatalogService.getBooks();
    }

    @GetMapping(path = "book/{id}", produces = "application/json")
    public ResponseEntity<BookResponseDTO> getBook(@PathVariable Integer id) {
        Book book = bookCatalogService.getBook(id);
        if (book != null) {
            return new ResponseEntity<>(modelMapper.map(book, BookResponseDTO.class), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "book")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody BookDTO bookDTO) {
        if (bookDTO != null && !bookDTO.getTitle().isEmpty()) {
            Book book = modelMapper.map(bookDTO, Book.class);
            bookCatalogService.insert(book);
        }
    }

    @PostMapping(path = "books")
    @ResponseStatus(HttpStatus.CREATED)
    public void importBooks(@RequestBody List<BookDTO> books) {
        books.stream().forEach(bookDTO -> {
            if (bookDTO != null && !bookDTO.getTitle().isEmpty()) {
                Book book = modelMapper.map(bookDTO, Book.class);
                bookCatalogService.insert(book);
            }
        });
    }

    @PutMapping(path = "book/{id}")
    public ResponseEntity<Void> update(@RequestBody BookDTO bookDTO, @PathVariable Integer id) {
        Book book = bookCatalogService.getBook(id);
        if (book != null) {
            modelMapper.map(bookDTO, book);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping(path = "book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        try {
            bookCatalogService.deleteBook(id);
        } catch (CatalogItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "books")
    public ResponseEntity<Void> deleteBooks() {
        bookCatalogService.deleteAllBook();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
