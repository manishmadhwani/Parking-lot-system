package com.example.parkingLot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Bill {

    @Setter
    @Getter
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int billId;
    @Setter
    @Getter
    private int receiptId;
    @Setter
    @Getter
    private LocalDateTime date;
    @Setter
    @Getter
    private LocalTime startTime;
    @Setter
    @Getter
    private LocalTime endTime;
    @Setter
    @Getter
    private int totalTimeinHours;
    @Setter
    @Getter
    private String vehicleType;
    @Setter
    @Getter
    private String vehicleNo;
    @Setter
    @Getter
    private String vehicleOwnerNo;
    @Setter
    @Getter
    private String parkingSpot;
    @Setter
    @Getter
    private int totalamt;
    @Setter
    @Getter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bill")
    private History history;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(String parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(int totalamt) {
        this.totalamt = totalamt;
    }

    public int getTotalTimeinHours() {
        return totalTimeinHours;
    }

    public void setTotalTimeinHours(int totalTimeinHours) {
        this.totalTimeinHours = totalTimeinHours;
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

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", receiptId=" + receiptId +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalTimeinHours=" + totalTimeinHours +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", vehicleOwnerNo='" + vehicleOwnerNo + '\'' +
                ", parkingSpot='" + parkingSpot + '\'' +
                ", totalamt=" + totalamt +
                ", history=" + history +
                '}';
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
