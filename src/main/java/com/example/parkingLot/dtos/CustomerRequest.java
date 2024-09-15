package com.example.parkingLot.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CustomerRequest {
	@NotEmpty(message = "Customer number is required")
	@Length(max = 10, min = 10, message = "Number input is wrong")
	@Valid
	private String custNumber;

	@NotEmpty(message = "Vehicle No is required")
	@Valid
	private String vehicleNo;

	@NotEmpty(message = "Vehicle type is required")
	@Valid
	private String vehicleType;

	@NotEmpty(message = "Vehicle variant is required")
	@Valid
	private String vehicleTypeVariant;

	public String getCustNumber() {
		return custNumber;
	}

	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}

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

	public String getVehicleTypeVariant() {
		return vehicleTypeVariant;
	}

	public void setVehicleTypeVariant(String vehicleTypeVariant) {
		this.vehicleTypeVariant = vehicleTypeVariant;
	}

}
