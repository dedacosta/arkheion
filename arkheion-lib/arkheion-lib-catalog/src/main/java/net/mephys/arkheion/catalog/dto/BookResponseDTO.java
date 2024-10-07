package net.mephys.arkheion.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {

    private Integer uniqueId;

    private String title;
    private String authors;
    private String isbn;
    private String publisher;
    private Integer publicationYear;
    private Integer edition;
    private Integer pages;
    private String language;
    private String genre;
    private String number;
}
