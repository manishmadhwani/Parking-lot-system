package com.example.parkingLot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Data
@Table(name = "CITIES")
public class City {
    @Id
    @Column(name = "city_id")
    private String cityId;
    @Column(name = "name")
    private String cityName;

    @OneToMany(mappedBy = "city")
    private List<ParkingLot> parkingLots;
}
