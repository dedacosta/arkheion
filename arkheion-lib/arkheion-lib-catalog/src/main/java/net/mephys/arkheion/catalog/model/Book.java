package net.mephys.arkheion.catalog.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends CatalogBaseItem {

    private String title;
    private List<String> authors;
    private String ISBN;
    private String publisher;
    private int publicationYear;
    private Integer edition;
    private int pages;
    private String language;
    private String genre;
    private String number = "";

    public void setTitle(String title) {
        this.title = title;
        updateModificationTime();
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
        updateModificationTime();
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
        updateModificationTime();
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
        updateModificationTime();
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
        updateModificationTime();
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
        updateModificationTime();
    }

    public void setPages(int pages) {
        this.pages = pages;
        updateModificationTime();
    }

    public void setLanguage(String language) {
        this.language = language;
        updateModificationTime();
    }

    public void setGenre(String genre) {
        this.genre = genre;
        updateModificationTime();
    }

    public void setNumber(String number) {
        this.number = number;
        updateModificationTime();
    }

}