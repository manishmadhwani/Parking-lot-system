package com.example.parkingLot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Receipt {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int receiptId;

    private LocalDateTime entryDateTime;
    private String vehicleNo;
    private String vehicleType;
    private String vehicleVariant;
    private String ownerNo;
    private String parkingSpotId;
    private LocalDateTime date;
}
