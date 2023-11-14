package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentRequest {
    private String text;
    private HotelRoomDto hotel;
    private String guestId;
}
