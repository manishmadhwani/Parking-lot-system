package com.example.parkingLot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "PARKINGLOTS")
public class ParkingLot {

    @Id
    @Column(name = "parkinglot_id")
    private String parkingLotId;
    @Column(name = "parkinglotname")
    private String parkingLotName;
    @Column(name = "parkinglotaddress")
    private String parkingLotAddress;
    @Column(name = "nooffloors")
    private String noOfFloors;
    @Column(name = "noofgates")
    private String noOfGates;
    @Column(name = "capacity")
    private String capacity;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "parkingLot")
    private List<ParkingSpot> parkingSpots;
}
