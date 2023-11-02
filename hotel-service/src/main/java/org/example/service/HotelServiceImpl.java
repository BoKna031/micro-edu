package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.hotel.HotelDescriptionResponse;
import org.example.dto.hotel.RegisterHotelRequest;
import org.example.exception.EntityNotFoundException;
import org.example.mapper.HotelMapper;
import org.example.model.Hotel;
import org.example.repository.HotelRepository;
import org.example.service.interfaces.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.example.mapper.HotelMapper.mapToHotelDescriptionResponse;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public HotelDescriptionResponse create(RegisterHotelRequest request) {
        Hotel hotel = hotelRepository.save(HotelMapper.maptoHotel(request));
        return mapToHotelDescriptionResponse(hotel);
    }

    @Override
    public HotelDescriptionResponse getById(long id) {
        return mapToHotelDescriptionResponse(getHotelById(id));
    }

    @Override
    public List<HotelDescriptionResponse> getAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream().map(HotelMapper::mapToHotelDescriptionResponse).toList();
    }

    @Override
    public void delete(long id){
        Hotel hotel = getHotelById(id);
        hotelRepository.deleteById(hotel.getId());
    }
    @Override
    public Hotel getHotelById(long id){
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if(hotel.isEmpty())
            throw new EntityNotFoundException(Hotel.class, Long.toString(id));
        return hotel.get();
    }
}
