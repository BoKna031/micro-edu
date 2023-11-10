package org.example;

import lombok.RequiredArgsConstructor;
import org.example.dto.CommentRequest;
import org.example.dto.CommentResponse;
import org.example.exception.BadRequestException;
import org.example.exception.EntityNotFoundException;
import org.example.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public CommentResponse create(CommentRequest request) {
        Comment savedComment = commentRepository.insert(Mapper.toComment(request));
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
