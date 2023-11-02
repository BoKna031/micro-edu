package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.room.RoomRequest;
import org.example.dto.room.RoomResponse;
import org.example.repository.RoomRepository;
import org.example.service.interfaces.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    @PostMapping
    public ResponseEntity<RoomResponse> create(@RequestBody RoomRequest request){
        return new ResponseEntity<>(
                roomService.create(request),
                HttpStatus.CREATED);
    }
}
