package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel extends BaseEntity<Long>{
    private String name;
    private String address;
    private int numberOfStars;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
    private Set<Room> rooms;
}
