package com.example.parkingLot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingLot.model.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {

}
