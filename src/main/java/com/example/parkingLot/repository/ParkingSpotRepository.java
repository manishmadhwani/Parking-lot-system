package com.example.parkingLot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.parkingLot.model.ParkingSpot;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM PARKINGSPOTS prk where prk.occupiedFlag = FALSE and prk.parkingSpotType = 'TWO_WHEELER'")
	List<ParkingSpot> findAllAvailableTwoParkingSpots();
	
	@Query(nativeQuery = true, value = "SELECT * FROM PARKINGSPOTS prk where prk.occupiedFlag = FALSE and prk.parkingSpotType = 'FOUR_WHEELER'")
	List<ParkingSpot> findAllAvailableFourParkingSpots();

}
