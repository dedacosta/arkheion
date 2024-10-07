package net.mephys.arkheion.catalog.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static net.mephys.arkheion.catalog.component.Catalog.getIdCounter;

@Data
@NoArgsConstructor
public abstract class CatalogBaseItem {

    private final Integer uniqueId = getIdCounter();

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime dateOfCreation = LocalDateTime.now();

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime modificationTime = dateOfCreation;

    public void updateModificationTime() {
        modificationTime = LocalDateTime.now();
    }

}
