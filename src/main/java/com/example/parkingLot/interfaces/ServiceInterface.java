package com.example.parkingLot.interfaces;

import com.example.parkingLot.dtos.CustomerRequest;
import com.example.parkingLot.model.Bill;
import com.example.parkingLot.model.Receipt;

public interface ServiceInterface {

    /*
     * DTO :- Get a customer request
     * 1) generates a receipt when a vehicle comes in.
     * 2) assigns a parking spot to the customer
     * 3) When a parking lot is assigned to the customer, save receipt to db
     */
    Receipt generateAReciept(CustomerRequest customerRequest);

    /* DTO :- Get a receiptId and then get details from it to generate a bill.
     * 1) generates a bill when a vehicle comes out.
     * 2) Marking the parkingSpotId available again.
     * 3) Save into the history table.
     */
    Bill genrateABill(int receiptId);
}
