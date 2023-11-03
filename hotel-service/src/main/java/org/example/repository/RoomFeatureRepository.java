package org.example.repository;

import org.example.model.RoomFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoomFeatureRepository extends JpaRepository<RoomFeature, Long> {
    @Query("Select rf FROM RoomFeature rf WHERE rf.id IN :ids")
    List<RoomFeature> findAllByIds(Set<Long> ids);
}
