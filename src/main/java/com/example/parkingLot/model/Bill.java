package com.example.parkingLot.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Bill {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int billId;
    private int receiptId;

    private LocalDateTime date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int totalTimeinHours;

    private String vehicleType;
    private String vehicleNo;
    private String vehicleOwnerNo;

    private String parkingSpot;
    private int totalamt;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bill")
    private History history;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getTotalTimeinHours() {
        return totalTimeinHours;
    }

    public void setTotalTimeinHours(int totalTimeinHours) {
        this.totalTimeinHours = totalTimeinHours;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleOwnerNo() {
        return vehicleOwnerNo;
    }

    public void setVehicleOwnerNo(String vehicleOwnerNo) {
        this.vehicleOwnerNo = vehicleOwnerNo;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(String parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public int getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(int totalamt) {
        this.totalamt = totalamt;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
