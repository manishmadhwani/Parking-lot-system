package com.example.parkingLot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

	public String getParkingSpotEVNONEV() {
		return parkingSpotEVNONEV;
	}

	public void setParkingSpotEVNONEV(String parkingSpotEVNONEV) {
		this.parkingSpotEVNONEV = parkingSpotEVNONEV;
	}

	public boolean getOccupiedFlag() {
		return occupiedFlag;
	}

	public void setOccupiedFlag(Boolean occupiedFlag) {
		this.occupiedFlag = occupiedFlag;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
}
