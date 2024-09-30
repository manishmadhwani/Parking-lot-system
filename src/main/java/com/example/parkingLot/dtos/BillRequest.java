package com.example.parkingLot.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BillRequest {

	@NotEmpty(message = "Customer number is required")
	@Valid
	private int receiptId;

	public int getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
}
