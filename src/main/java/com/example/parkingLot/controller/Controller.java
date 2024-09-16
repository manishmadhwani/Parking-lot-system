package com.example.parkingLot.controller;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingLot.dtos.BillRequest;
import com.example.parkingLot.dtos.CustomerRequest;
import com.example.parkingLot.model.Bill;
import com.example.parkingLot.model.Receipt;
import com.example.parkingLot.model.VehicleTypeEnum;

@RestController
public class Controller {

	@Autowired
	com.example.parkingLot.services.Service service;

	@GetMapping("test")
	public String testApi() {
		return "Spring boot project working fine.";
	}

	@PostMapping("getReceipt")
	public ResponseEntity<Receipt> genereateAReceipt(@RequestBody CustomerRequest customerRequest) throws Exception {
		// Generate a receipt
		// Get a parking spot for the customer
		if (EnumUtils.isValidEnum(VehicleTypeEnum.class, customerRequest.getVehicleType())) {
			Receipt receipt = service.generateAReciept(customerRequest);
			return ResponseEntity.ok(receipt);
		} else {
			throw new Exception("In-valid value passed : " + customerRequest.getVehicleType());
		}
	}

	@PostMapping("getBill")
	public ResponseEntity<Bill> generateAFinalBill(@RequestBody BillRequest billRequest) {
		String receiptId= billRequest.getReceiptId();
		return ResponseEntity.ok(service.genrateABill(receiptId));
	}
}
