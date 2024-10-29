package com.example.parkingLot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class History {
    @GeneratedValue
    @Id
    private int id;
    @OneToOne
    private Bill bill;
    private int receiptId;
}
