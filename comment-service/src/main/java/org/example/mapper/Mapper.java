package org.example.mapper;

import org.example.dto.CommentResponse;
import org.example.dto.GuestDto;
import org.example.dto.HotelRoomResponse;
import org.example.model.Comment;
import org.example.model.Guest;
import org.example.model.HotelRoom;

public class Mapper {

    public static CommentResponse toCommentResponse(Comment comment){
        return new CommentResponse(
                comment.getId(),
                comment.getText(),
                toHotelRoomResponse(comment.getRoom()),
                toGuestDto(comment.getGuest()),
                comment.getTimestamp()
                );
    }

    private static HotelRoomResponse toHotelRoomResponse(HotelRoom hotelRoom){
        return new HotelRoomResponse(hotelRoom.getHotel().getId(), hotelRoom.getRoomId(), hotelRoom.getHotel().getName(), hotelRoom.getHotel().getAddress());
    }

    private static GuestDto toGuestDto(Guest guest){
        return new GuestDto(guest.getId(), guest.getEmail());
    }
}
