package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.room.RoomRequestWithHotelId;
import org.example.dto.room.RoomResponse;
import org.example.dto.room.RoomResponseWithFeatures;
import org.example.dto.roomfeature.FeatureWithQuantity;
import org.example.exception.EntityNotFoundException;
import org.example.mapper.RoomMapper;
import org.example.model.Hotel;
import org.example.model.IncludedRoomFeature;
import org.example.model.Room;
import org.example.model.RoomFeature;
import org.example.repository.RoomFeatureRepository;
import org.example.repository.RoomRepository;
import org.example.service.interfaces.HotelService;
import org.example.service.interfaces.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomFeatureRepository roomFeatureRepository;
    private final HotelService hotelService;


    @Override
    public RoomResponse create(RoomRequestWithHotelId request) {
        Room room = RoomMapper.maptoRoom(request);

        Hotel hotel = hotelService.getHotelById(request.getHotelId());
        room.setHotel(hotel);

        Set<Long> featureIds = request.getRoomRequest().getFeatures().stream()
                .map(FeatureWithQuantity::getId)
                .collect(Collectors.toSet());

        List<RoomFeature> roomFeatures =  roomFeatureRepository.findAllByIds(featureIds);

        Set<IncludedRoomFeature> includedRoomFeatures = request.getRoomRequest().getFeatures().stream()
                .map(f -> new IncludedRoomFeature(findFeatureFromList(f.getId(), roomFeatures), room, f.getQuantity()))
                .collect(Collectors.toSet());


        room.setFeatures(includedRoomFeatures);
        Room savedRoom = roomRepository.save(room);

        return RoomMapper.mapToRoomResponse(savedRoom);
    }

    @Override
    public RoomResponse getRoomResponseById(long id) {
        return RoomMapper.mapToRoomResponse(findRoomById(id));
    }

    @Override
    public RoomResponseWithFeatures getRoomResponseWithFeaturesById(long id) {
        return RoomMapper.mapToRoomResponseWithFeatures(findRoomById(id));
    }

    private Room findRoomById(long id){
        return roomRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Room.class, String.valueOf(id)));
    }
    private RoomFeature findFeatureFromList(Long id, List<RoomFeature> roomFeatures) {
        return roomFeatures.stream().filter(rf -> rf.getId().equals(id)).findFirst()
                .orElseThrow(() -> new EntityNotFoundException(RoomFeature.class, id.toString()));
    }


}
