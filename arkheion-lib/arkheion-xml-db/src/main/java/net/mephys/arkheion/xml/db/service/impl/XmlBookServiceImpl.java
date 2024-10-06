package net.mephys.arkheion.xml.db.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.mephys.arkheion.xml.db.component.XmlDatabase;
import net.mephys.arkheion.xml.db.model.BaseItem;
import net.mephys.arkheion.xml.db.model.Book;
import net.mephys.arkheion.xml.db.service.XmlBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XmlBookServiceImpl implements XmlBookService {

    private final XmlDatabase xmlDatabase;
    private final ObjectMapper objectMapper;

    public XmlBookServiceImpl(XmlDatabase xmlDatabase, ObjectMapper objectMapper) {
        this.xmlDatabase = xmlDatabase;
        this.objectMapper = objectMapper;
    }

    // CREATE
    public void insert(Book book) {
        xmlDatabase.insert(book);
    }

    // READ All
    public List<Book> getBooks() {
        List<BaseItem> items = xmlDatabase.getDatabase();
        return items.stream()
                .filter(it -> it instanceof Book)
                .map(it -> (Book) it)
                .toList();
    }

    // READ
    public Book getBook(Integer bookId) {
        BaseItem item = xmlDatabase.getItemById(bookId);
        if (item instanceof Book book)
            return book;
        else return null;
    }

    // DELETE
    public void deleteBook(Integer bookId) {
        xmlDatabase.deleteItem(bookId);
    }

    // DELETE
    public void deleteAllBook(){
        xmlDatabase.deleteAll();
    }


    // UPDATE
    public void updateBook(Integer bookId, Book bookDetails) {
        xmlDatabase.updateItem(bookId, bookDetails);
    }

    // Export XML
    public String exportXML() {
        try {
            return objectMapper.writeValueAsString(getBooks());
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    // Import XML
    public void importXML(String xml) {
        try {
            List<Book> books = objectMapper.readValue(xml, new TypeReference<List<Book>>() {
            });
        } catch (JsonProcessingException e) {
        }
    }
}