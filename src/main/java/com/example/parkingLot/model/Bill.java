package com.example.parkingLot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
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
}
