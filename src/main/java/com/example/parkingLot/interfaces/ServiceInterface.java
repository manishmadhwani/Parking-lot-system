package com.example.parkingLot.interfaces;

import com.example.parkingLot.dtos.CustomerRequest;
import com.example.parkingLot.model.Bill;
import com.example.parkingLot.model.Receipt;

public interface ServiceInterface {

	/*
	 * DTO :- Get a customer request 1) generates a receipt when a vehicle comes in.
	 * 2) assigns a parking spot to the customer 3) When a parking lot is assigned
	 * to the customer, save receipt to db
	 */
	Receipt generateAReciept(CustomerRequest customerRequest);

	/*
	 * 1) generates a bill when a vehicle comes out.
	 */
	Bill genrateABill(String receiptId);
}
