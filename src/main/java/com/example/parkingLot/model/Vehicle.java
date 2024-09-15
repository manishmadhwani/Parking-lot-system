package com.example.parkingLot.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

	@Id
	@Column(name = "id")
	private String vehicleNo;
	private String vehicleType;
	private String vehicleVariant;
	private Date lastVisited;

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleVariant() {
		return vehicleVariant;
	}

	public void setVehicleVariant(String vehicleVariant) {
		this.vehicleVariant = vehicleVariant;
	}

	public Date getLastVisited() {
		return lastVisited;
	}

	public void setLastVisited(Date lastVisited) {
		this.lastVisited = lastVisited;
	}

}
