package net.mephys.arkheion.api.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class BookDTO {
    private Integer bookId;
    String title;
    String isbn13;
}
