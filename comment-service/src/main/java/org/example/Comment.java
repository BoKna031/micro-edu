package org.example;

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
    private String roomId;
    private String hotelId;
    private String guestId;
    private String guestEmail;
    private LocalDateTime timestamp;

    public Comment(String text, String roomId, String hotelId, String guestId, String guestEmail) {
        this.text = text;
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.guestId = guestId;
        this.guestEmail = guestEmail;
        this.timestamp = LocalDateTime.now();
    }
}
