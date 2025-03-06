package com.example.parkingLot.interfaces;

import com.example.parkingLot.dtos.CustomerRequest;
import com.example.parkingLot.excptions.ReceiptNotFoundException;
import com.example.parkingLot.model.Bill;
import com.example.parkingLot.model.Receipt;

public interface ServiceInterface {

    /**
     * @param customerRequest
     * @return generated receipt when a vehicle comes in.
     **/
    Receipt generateAReciept(CustomerRequest customerRequest);

    /* DTO :- Get a receiptId and then get details from it to generate a bill.
     * 1) generates a bill when a vehicle comes out.
     * 2) Marking the parkingSpotId available again.
     * 3) Save into the history table.
     */
    Bill genrateABill(int receiptId) throws ReceiptNotFoundException;
}
