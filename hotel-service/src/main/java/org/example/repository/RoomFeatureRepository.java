package org.example.repository;

import org.example.model.RoomFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomFeatureRepository extends JpaRepository<RoomFeature, Long> {
}
