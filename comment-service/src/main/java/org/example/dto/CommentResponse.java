package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentResponse {
    private String id;
    private String text;
    private HotelRoomResponse hotel;
    private GuestDto guest;
    private LocalDateTime timestamp;
}
