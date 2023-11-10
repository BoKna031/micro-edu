package org.example.repository;

public interface CustomCommentRepository {
    long updateEmailForGuestId(String guestId, String newEmail);
}
