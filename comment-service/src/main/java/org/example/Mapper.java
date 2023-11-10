package org.example;

import org.example.dto.CommentRequest;
import org.example.dto.CommentResponse;

public class Mapper {
    public static Comment toComment(CommentRequest request){
        return new Comment(
                request.getText(),
                request.getRoomId(),
                request.getHotelId(),
                request.getGuestId(),
                request.getGuestEmail());
    }

    public static CommentResponse toCommentResponse(Comment comment){
        return new CommentResponse(
                comment.getId(),
                comment.getText(),
                comment.getRoomId(),
                comment.getHotelId(),
                comment.getGuestId(),
                comment.getGuestEmail(),
                comment.getTimestamp()
                );
    }
}
