package com.example.parkingLot.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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

	public String getParkingLotId() {
		return parkingLotId;
	}

	public void setParkingLotId(String parkingLotId) {
		this.parkingLotId = parkingLotId;
	}

	public String getParkingLotName() {
		return parkingLotName;
	}

	public void setParkingLotName(String parkingLotName) {
		this.parkingLotName = parkingLotName;
	}

	public String getParkingLotAddress() {
		return parkingLotAddress;
	}

	public void setParkingLotAddress(String parkingLotAddress) {
		this.parkingLotAddress = parkingLotAddress;
	}

	public String getNoOfFloors() {
		return noOfFloors;
	}

	public void setNoOfFloors(String noOfFloors) {
		this.noOfFloors = noOfFloors;
	}

	public String getNoOfGates() {
		return noOfGates;
	}

	public void setNoOfGates(String noOfGates) {
		this.noOfGates = noOfGates;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public List<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}

	public void setParkingSpots(List<ParkingSpot> parkingSpots) {
		this.parkingSpots = parkingSpots;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
