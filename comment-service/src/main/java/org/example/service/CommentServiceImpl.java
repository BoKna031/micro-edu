package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.mapper.Mapper;
import org.example.dto.CommentRequest;
import org.example.dto.CommentResponse;
import org.example.exception.BadRequestException;
import org.example.exception.EntityNotFoundException;
import org.example.microservices.guest.service.GuestService;
import org.example.microservices.hotel.service.HotelService;
import org.example.model.Comment;
import org.example.model.Guest;
import org.example.model.HotelRoom;
import org.example.repository.CommentRepository;
import org.example.service.interfaces.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final HotelService hotelService;
    private final GuestService guestService;

    @Override
    public CommentResponse create(CommentRequest request) {
        HotelRoom hotelRoom = hotelService.getRoomInfoFromHotelIdAndRoomId(request.getHotel());
        Guest guest = guestService.getGuestById(request.getGuestId());
        Comment comment = new Comment(request.getText(), hotelRoom, guest);
        Comment savedComment = commentRepository.insert(comment);
        return Mapper.toCommentResponse(savedComment);
    }

    @Override
    public List<CommentResponse> getAllForRoom(String hotelId, String roomId) {
        return commentRepository.getAllForRoom(hotelId, roomId).stream()
                .map(Mapper::toCommentResponse).collect(Collectors.toList());
    }

    @Override
    public List<CommentResponse> getAllForGuest(String guestId) {
        return commentRepository.findByGuestId(guestId).stream().map(Mapper::toCommentResponse).collect(Collectors.toList());
    }

    @Override
    public CommentResponse getById(String id) {
        return Mapper.toCommentResponse(getCommentByIdOrThrowNotFoundException(id));
    }

    @Override
    public CommentResponse update(String id, CommentRequest request) {
        Comment existingComment = getCommentByIdOrThrowNotFoundException(id);
        if (request.getText() == null || request.getText().equals(existingComment.getText()))
            throw new BadRequestException("Not valid text value in request!");

        existingComment.setText(request.getText());
        return Mapper.toCommentResponse(commentRepository.save(existingComment));
    }

    @Override
    public void delete(String id) {
        Comment comment = getCommentByIdOrThrowNotFoundException(id);
        commentRepository.deleteById(comment.getId());
    }

    @Override
    public void updateGuestEmail(String guestId, String newEmail) {
        long updatedRows = commentRepository.updateEmailForGuestId(guestId, newEmail);
        if (updatedRows == 0)
            throw new EntityNotFoundException(Comment.class, "guest-id", guestId);
    }

    private Comment getCommentByIdOrThrowNotFoundException(String id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Comment.class, "id", id));
    }
}
