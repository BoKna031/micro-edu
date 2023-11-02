package org.example.service.interfaces;

import org.example.dto.HotelDescriptionResponse;
import org.example.dto.RegisterHotelRequest;

import java.util.List;

public interface HotelService {
    HotelDescriptionResponse create(RegisterHotelRequest request);
    HotelDescriptionResponse getById(long id);
    List<HotelDescriptionResponse> getAll();

    void delete(long id);
}
