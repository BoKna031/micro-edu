package org.example.repository;

import org.example.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String>, CustomCommentRepository {
        @Query("{ 'hotelId' : ?0, 'roomId' : ?1}")
        List<Comment> getAllForRoom(String hotelId, String roomId);
        List<Comment> findByGuestId(String guestId);
}
