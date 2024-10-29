package com.example.parkingLot.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BillRequest {

    String paymentMode;
    @NotEmpty(message = "Customer number is required")
    @Valid
    private int receiptId;

}
