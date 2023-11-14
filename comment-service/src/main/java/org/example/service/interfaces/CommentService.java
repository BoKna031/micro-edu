package org.example.service.interfaces;

import org.example.dto.CommentRequest;
import org.example.dto.CommentResponse;

import java.util.List;

public interface CommentService {
    CommentResponse create(CommentRequest request);
    List<CommentResponse> getAllForRoom(String hotelId, String roomId);
    List<CommentResponse> getAllForGuest(String guestId);
    CommentResponse getById(String id);
    CommentResponse update(String id, CommentRequest request);
    void delete(String id);
    void updateGuestEmail(String guestId, String newEmail);
}
