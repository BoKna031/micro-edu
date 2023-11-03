package org.example.service.interfaces;

import org.example.dto.roomfeature.CreateFeatureRequest;
import org.example.dto.roomfeature.RoomFeatureResponse;

import java.util.List;

public interface RoomFeatureService {
    RoomFeatureResponse create(CreateFeatureRequest request);
    List<RoomFeatureResponse> getAll();
}
