package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.hotel.HotelDescriptionResponse;
import org.example.dto.hotel.RegisterHotelRequest;
import org.example.dto.location.LocationResponse;
import org.example.exception.EntityNotFoundException;
import org.example.mapper.HotelMapper;
import org.example.model.Hotel;
import org.example.repository.HotelRepository;
import org.example.service.interfaces.HotelService;
import org.example.service.interfaces.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.example.mapper.HotelMapper.mapToHotelDescriptionResponse;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final LocationService locationService;

    @Override
    public HotelDescriptionResponse create(RegisterHotelRequest request) {
        String address = getAddressFromLocationId(request.getLocationId());
        Hotel hotel = HotelMapper.maptoHotel(request);
        hotel.setAddress(address);
        Hotel savedHotel = hotelRepository.save(hotel);

        return mapToHotelDescriptionResponse(savedHotel);
    }

    @Override
    public HotelDescriptionResponse getById(long id) {
        return mapToHotelDescriptionResponse(getHotelById(id));
    }

    @Override
    public List<HotelDescriptionResponse> getAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream().map(item->{
            if(item.getAddress() == null || item.getAddress().isEmpty())
               return HotelMapper.mapToHotelDescriptionResponse(updateAddress(item));
            return HotelMapper.mapToHotelDescriptionResponse(item);
        }).toList();
    }

    private Hotel updateAddress(Hotel hotel){
        hotel.setAddress(getAddressFromLocationIdSafe(hotel.getLocationId()));
        return hotelRepository.save(hotel);
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

    private String getAddressFromLocationId(UUID locationId) throws RestClientException {
        LocationResponse location = locationService.getAddressFromLocationUUID(locationId);
        if(location == null)
            return null;
        return location.getCountry() + ", "+ location.getCity() + ", " + location.getStreet();
    }

    private String getAddressFromLocationIdSafe(UUID locationId){
        try{
            return getAddressFromLocationId(locationId);
        }catch(RestClientException e){
            return null;
        }
    }
}
