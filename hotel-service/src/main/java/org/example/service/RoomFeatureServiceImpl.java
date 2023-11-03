package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.roomfeature.CreateFeatureRequest;
import org.example.dto.roomfeature.RoomFeatureResponse;
import org.example.mapper.RoomFeatureMapper;
import org.example.model.RoomFeature;
import org.example.repository.RoomFeatureRepository;
import org.example.service.interfaces.RoomFeatureService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RoomFeatureServiceImpl implements RoomFeatureService {
    private final RoomFeatureRepository roomFeatureRepository;
    @Override
    public RoomFeatureResponse create(CreateFeatureRequest request) {
        RoomFeature roomFeature = roomFeatureRepository.save(RoomFeatureMapper.toRoomFeature(request));
        return RoomFeatureMapper.toRoomFeatureResponse(roomFeature);
    }

    @Override
    public List<RoomFeatureResponse> getAll() {
        List<RoomFeature> features = roomFeatureRepository.findAll();
        return features.stream().map(RoomFeatureMapper::toRoomFeatureResponse).toList();
    }
}
