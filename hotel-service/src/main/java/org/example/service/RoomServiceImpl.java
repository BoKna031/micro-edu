package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.room.RoomRequest;
import org.example.dto.room.RoomResponse;
import org.example.mapper.RoomMapper;
import org.example.model.Hotel;
import org.example.model.Room;
import org.example.repository.HotelRepository;
import org.example.repository.RoomRepository;
import org.example.service.interfaces.HotelService;
import org.example.service.interfaces.RoomService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final HotelService hotelService;


    @Override
    public RoomResponse create(RoomRequest request) {
        Room room = RoomMapper.maptoRoom(request);
        Hotel hotel = hotelService.getHotelById(request.getHotelId());

        room.setHotel(hotel);
        Room savedRoom = roomRepository.save(room);
        return RoomMapper.mapToRoomResponse(savedRoom);
    }
}
