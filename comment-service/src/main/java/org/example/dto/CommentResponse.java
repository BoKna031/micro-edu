package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentResponse {
    private String id;
    private String text;
    private String roomId;
    private String hotelId;
    private String guestId;
    private String guestEmail;
    private LocalDateTime timestamp;
}
