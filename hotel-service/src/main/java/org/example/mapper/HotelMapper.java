package org.example.mapper;

import org.example.dto.hotel.HotelDescriptionResponse;
import org.example.dto.hotel.RegisterHotelRequest;
import org.example.model.Hotel;

public class HotelMapper {
    public static Hotel maptoHotel(RegisterHotelRequest request){
        Hotel hotel = new Hotel();
        hotel.setLocationId(request.getLocationId());
        hotel.setNumberOfStars(request.getCategory());
        hotel.setName(request.getName());
        return hotel;
    }

    public static HotelDescriptionResponse mapToHotelDescriptionResponse(Hotel hotel){
        return new HotelDescriptionResponse(
                hotel.getId(),
                hotel.getName(),
                hotel.getLocationId(),
                hotel.getAddress(),
                hotel.getNumberOfStars()
        );
    }
}
