package com.example.parkingLot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PARKINGSPOTS")
public class ParkingSpot {

    @Id
    @Column(name = "parkingspot_id")
    @Setter
    @Getter
    private String parkingSpotId;

    @Setter
    @Getter
    @Column(name = "parkingspottype")
    private String parkingSpotType;

    @Setter
    @Getter
    @Column(name = "parkingspotevnonev")
    private String parkingSpotEVNONEV;

    @Setter
    @Getter
    @Column(name = "occupiedflag")
    private boolean occupiedFlag;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "parkinglot_id")
    private ParkingLot parkingLot;

    public boolean isOccupiedFlag() {
        return occupiedFlag;
    }

    public void setOccupiedFlag(boolean occupiedFlag) {
        this.occupiedFlag = occupiedFlag;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getParkingSpotEVNONEV() {
        return parkingSpotEVNONEV;
    }

    public void setParkingSpotEVNONEV(String parkingSpotEVNONEV) {
        this.parkingSpotEVNONEV = parkingSpotEVNONEV;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public String getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(String parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }
}
