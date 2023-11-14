package org.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document
public class Comment {

    @Id
    private String id;
    private String text;
    private HotelRoom room;
    private Guest guest;
    private LocalDateTime timestamp;

    public Comment(String text, HotelRoom room, Guest guest) {
        this.text = text;
        this.room = room;
        this.guest = guest;
        this.timestamp = LocalDateTime.now();
    }
}
