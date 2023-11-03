package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.room.RoomRequest;
import org.example.dto.room.RoomRequestWithHotelId;
import org.example.dto.room.RoomResponse;
import org.example.service.interfaces.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/hotels/{hotel-id}/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    @PostMapping
    public ResponseEntity<RoomResponse> create(@PathVariable("hotel-id") long hotelId, @RequestBody RoomRequest request){
        return new ResponseEntity<>(
                roomService.create(new RoomRequestWithHotelId(request, hotelId)),
                HttpStatus.CREATED);
    }
}
