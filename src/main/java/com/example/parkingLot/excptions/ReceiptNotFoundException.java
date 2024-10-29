package com.example.parkingLot.excptions;

public class ReceiptNotFoundException extends Exception {

    String exceptionCause;

    public ReceiptNotFoundException(String exception) {
        this.exceptionCause = exception;
    }
}
