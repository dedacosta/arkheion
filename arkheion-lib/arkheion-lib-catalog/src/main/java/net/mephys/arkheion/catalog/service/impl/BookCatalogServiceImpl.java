package net.mephys.arkheion.catalog.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.mephys.arkheion.catalog.component.Catalog;
import net.mephys.arkheion.catalog.model.CatalogBaseItem;
import net.mephys.arkheion.catalog.model.Book;
import net.mephys.arkheion.catalog.service.BookCatalogService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCatalogServiceImpl implements BookCatalogService {

    private final Catalog catalog;
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    public BookCatalogServiceImpl(Catalog catalog, ObjectMapper objectMapper, ModelMapper modelMapper) {
        this.catalog = catalog;
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
    }

    // CREATE
    public void insert(Book book) {
        catalog.insert(book);
    }

    // READ All
    public List<Book> getBooks() {
        List<CatalogBaseItem> items = catalog.getDatabase();
        return items.stream()
                .filter(it -> it instanceof Book)
                .map(it -> (Book) it)
                .toList();
    }

    // READ
    public Book getBook(Integer bookId) {
        CatalogBaseItem item = catalog.getItemById(bookId);
        if (item instanceof Book book)
            return book;
        else return null;
    }

    // DELETE
    public void deleteBook(Integer bookId) {
        catalog.deleteItem(bookId);
    }

    // DELETE
    public void deleteAllBook(){
        catalog.deleteAll();
    }

}