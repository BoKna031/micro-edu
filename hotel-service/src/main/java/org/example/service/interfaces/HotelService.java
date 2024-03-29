package org.example.service.interfaces;

import org.example.dto.hotel.HotelDescriptionResponse;
import org.example.dto.hotel.RegisterHotelRequest;
import org.example.model.Hotel;

import java.util.List;

public interface HotelService {
    HotelDescriptionResponse create(RegisterHotelRequest request);
    HotelDescriptionResponse getById(long id);
    List<HotelDescriptionResponse> getAll();
    void delete(long id);

    Hotel getHotelById(long id);
}
