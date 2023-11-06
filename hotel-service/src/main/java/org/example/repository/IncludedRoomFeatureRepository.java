package org.example.repository;

import org.example.model.IncludedRoomFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncludedRoomFeatureRepository extends JpaRepository<IncludedRoomFeature, Long> {
}
