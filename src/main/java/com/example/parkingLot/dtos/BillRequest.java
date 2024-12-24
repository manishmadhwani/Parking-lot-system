package com.example.parkingLot.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillRequest {

    String paymentMode;
    @NotEmpty(message = "Customer number is required")
    @Valid
    private int receiptId;

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @NotEmpty(message = "Customer number is required")
    @Valid
    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(@NotEmpty(message = "Customer number is required") @Valid int receiptId) {
        this.receiptId = receiptId;
    }
}
