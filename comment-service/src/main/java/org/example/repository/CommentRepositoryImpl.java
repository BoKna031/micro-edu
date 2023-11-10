package org.example.repository;

import com.mongodb.client.result.UpdateResult;
import org.example.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class CommentRepositoryImpl implements CustomCommentRepository{
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public long updateEmailForGuestId(String guestId, String newEmail) {
        Query query = new Query(Criteria.where("guestId").is(guestId));

        Update update = new Update();
        update.set("guestEmail", newEmail);

        UpdateResult result = mongoTemplate.updateMulti(query, update, Comment.class);
        return result.getModifiedCount();
    }
}
