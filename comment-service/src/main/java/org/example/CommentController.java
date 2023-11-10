package org.example;

import lombok.RequiredArgsConstructor;
import org.example.dto.CommentRequest;
import org.example.dto.CommentResponse;
import org.example.dto.UpdateGuestEmailRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest/comments")
public class CommentController {
    private final CommentService commentService;
    @PostMapping
    public ResponseEntity<CommentResponse> create(@RequestBody CommentRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentService.create(request));
    }

    @GetMapping("/hotels/{hid}/rooms/{rid}")
    public ResponseEntity<List<CommentResponse>> getForRoom(@PathVariable("hid") String hotelId, @PathVariable("rid") String roomId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(commentService.getAllForRoom(hotelId, roomId ));
    }

    @GetMapping("/guests/{id}")
    public ResponseEntity<List<CommentResponse>> getForGuest(@PathVariable("id") String guestId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(commentService.getAllForGuest(guestId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> getById(@PathVariable("id") String commentId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(commentService.getById(commentId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponse> update(@PathVariable("id") String id, @RequestBody CommentRequest request){
        return ResponseEntity.status(HttpStatus.OK)
                .body(commentService.update(id, request));
    }

    @PutMapping("/guests/{id}")
    public ResponseEntity<String> updateGuest(@PathVariable("id") String id,  @RequestBody UpdateGuestEmailRequest request){
        commentService.updateGuestEmail(id, request.getEmail());
        return ResponseEntity.status(HttpStatus.OK)
                .body("Update email successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        commentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Comment successfully deleted!");
    }
}
