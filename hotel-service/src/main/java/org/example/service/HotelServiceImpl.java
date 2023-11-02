package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.HotelDescriptionResponse;
import org.example.dto.RegisterHotelRequest;
import org.example.mapper.HotelMapper;
import org.example.model.Hotel;
import org.example.repository.HotelRepository;
import org.example.service.interfaces.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public HotelDescriptionResponse create(RegisterHotelRequest request) {
        Hotel hotel = hotelRepository.save(HotelMapper.maptoHotel(request));
        return HotelMapper.mapToHotelDescriptionResponse(hotel);
    }

    @Override
    public HotelDescriptionResponse getById(long id) {
        return HotelMapper.mapToHotelDescriptionResponse(hotelRepository.findById(id).get());
    }

    @Override
    public List<HotelDescriptionResponse> getAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream().map(HotelMapper::mapToHotelDescriptionResponse).toList();
    }

    @Override
    public void delete(long id){
        hotelRepository.deleteById(id);
    }
}
