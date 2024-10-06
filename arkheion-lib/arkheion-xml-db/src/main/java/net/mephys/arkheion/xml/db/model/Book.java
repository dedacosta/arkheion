package net.mephys.arkheion.xml.db.model;

import lombok.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseItem {

    private String title;
    private List<String> authors;
    private String ISBN;
    private String publisher;
    private int publicationYear;
    private String edition;
    private int pages;
    private String language;
    private String genre;
    private String number;

    @Override
    public void updateUniqueId() {
        try {
            // Combine relevant fields to create the content string
            String content = title + authors.toString() + edition + language + ISBN;

            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("MD5");

            // Generate the hash as a byte array
            byte[] hashBytes = digest.digest(content.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            setUniqueId(hexString.toString());
            updateModificationTime();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available.", e);
        }
    }

    @Override
    public void updateFrom(BaseItem item) {
        if (item instanceof Book other ) {
            this.authors = new ArrayList<>(other.authors);
            this.title = other.title;
            this.edition = other.edition;
            this.language = other.language;
            this.ISBN = other.ISBN;
            this.publisher = other.publisher;
            this.publicationYear = other.publicationYear;
            this.pages = other.pages;
            this.genre = other.genre;
            this.updateUniqueId();
        }
    }
}