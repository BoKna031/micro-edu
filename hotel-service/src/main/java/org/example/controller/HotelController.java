package org.example.controller;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.dto.hotel.HotelDescriptionResponse;
import org.example.dto.hotel.RegisterHotelRequest;
import org.example.service.interfaces.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    @Transactional
    public ResponseEntity<HotelDescriptionResponse> registerNew(@RequestBody RegisterHotelRequest request){
        return new ResponseEntity<>(
                hotelService.create(request),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDescriptionResponse> getById(@PathVariable long id){
        return new ResponseEntity<>(
                hotelService.getById(id),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HotelDescriptionResponse>> getAll(){
        return new ResponseEntity<>(
                hotelService.getAll(),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        hotelService.delete(id);
        return new ResponseEntity<String>(
                "Hotel successfully deleted!",
                HttpStatus.OK);
    }


}
