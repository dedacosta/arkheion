package net.mephys.arkheion.api.dto;

import lombok.Data;

@Data
public class BookDTO {
    private Integer bookId;
    String title;
    String isbn13;
}
