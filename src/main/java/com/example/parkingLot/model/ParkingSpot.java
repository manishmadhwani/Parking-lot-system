package com.example.parkingLot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PARKINGSPOTS")
public class ParkingSpot {

    @Id
    @Column(name = "parkingspot_id")
    private String parkingSpotId;
    @Column(name = "parkingspottype")
    private String parkingSpotType;
    @Column(name = "parkingspotevnonev")
    private String parkingSpotEVNONEV;
    @Column(name = "occupiedflag")
    private boolean occupiedFlag;

    @ManyToOne
    @JoinColumn(name = "parkinglot_id")
    private ParkingLot parkingLot;

}
