package com.example.parkingLot.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BillRequest {

	@JsonAlias("id")
	@NotEmpty(message = "Receipt id is required")
	private String receiptId;

	@NotEmpty(message = "Vehicle number is required")
	@JsonAlias("number")
	private String vehicleNum;
}
