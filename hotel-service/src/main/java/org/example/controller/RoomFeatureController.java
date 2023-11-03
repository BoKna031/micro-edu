package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.roomfeature.CreateFeatureRequest;
import org.example.dto.roomfeature.RoomFeatureResponse;
import org.example.service.interfaces.RoomFeatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/room-features")
@RequiredArgsConstructor
public class RoomFeatureController {
    private final RoomFeatureService roomFeatureService;
    @PostMapping
    public ResponseEntity<RoomFeatureResponse> create(@RequestBody CreateFeatureRequest request){
        return new ResponseEntity<>(
                roomFeatureService.create(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<RoomFeatureResponse>> getAll(CreateFeatureRequest request){
        return new ResponseEntity<>(
                roomFeatureService.getAll(),
                HttpStatus.OK
        );
    }
}
