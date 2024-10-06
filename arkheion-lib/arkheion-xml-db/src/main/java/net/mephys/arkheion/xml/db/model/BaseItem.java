package net.mephys.arkheion.xml.db.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public abstract class BaseItem {

    private String uniqueId;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateOfCreation = LocalDateTime.now();

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime modificationTime = LocalDateTime.now();

    public void updateModificationTime() {
        modificationTime = dateOfCreation;
    }

    public abstract void updateUniqueId();

    public abstract void updateFrom(BaseItem item);
}
