package net.mephys.arkheion.xml.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO  {
    private String title;
    private String authors;
    private String isbn;
    private String publisher;
    private Integer publicationYear;
    private String edition;
    private Integer pages;
    private String language;
    private String genre;
    private String number;

}
