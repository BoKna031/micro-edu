package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Hotel extends BaseEntity<Long>{
    @Column(nullable = false)
    private String name;
    private String address;
    @Column(nullable = false)
    private UUID locationId;
    private int numberOfStars;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Room> rooms;

    public Hotel(String name, UUID locationId, int numberOfStars, Set<Room> rooms) {
        this.name = name;
        this.locationId = locationId;
        this.numberOfStars = numberOfStars;
        this.rooms = rooms;
    }
}
