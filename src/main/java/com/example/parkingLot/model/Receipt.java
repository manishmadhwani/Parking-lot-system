package com.example.parkingLot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Receipt {
    @Id
    @GeneratedValue
    @Column(name = "id")
    @Setter
    @Getter
    private int receiptId;

    @Setter
    @Getter
    private LocalDateTime entryDateTime;

    @Setter
    @Getter
    private String vehicleNo;

    @Setter
    @Getter
    private String vehicleType;

    @Setter
    @Getter
    private String vehicleVariant;

    @Setter
    @Getter
    private String ownerNo;

    @Setter
    @Getter
    private String parkingSpotId;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(LocalDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public String getOwnerNo() {
        return ownerNo;
    }

    public void setOwnerNo(String ownerNo) {
        this.ownerNo = ownerNo;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
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

    public String getVehicleVariant() {
        return vehicleVariant;
    }

    public void setVehicleVariant(String vehicleVariant) {
        this.vehicleVariant = vehicleVariant;
    }

    @Setter
    @Getter
    private LocalDateTime date;
}
