package com.example.parkingLot.cache;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.parkingLot.model.ParkingSpot;
import com.example.parkingLot.repository.ParkingSpotRepository;

@Component
public class AvailableParkingSpotsCache {

	private Logger LOG = LoggerFactory.getLogger(AvailableParkingSpotsCache.class);

	@Autowired
	ParkingSpotRepository parkingSpotRepositiry;

	public List<ParkingSpot> getAllTwoParkingSpots() {
		LOG.info("Fetching available Parking spot for two wheelers from database .. ");
		List<ParkingSpot> parkingSpots = parkingSpotRepositiry.findAllAvailableTwoParkingSpots();
		Collections.sort(parkingSpots, (t1, t2) -> t1.getParkingSpotId().compareTo(t2.getParkingSpotId()));
		return parkingSpots;
	}

	public List<ParkingSpot> getAllFourParkingSpots() {
		LOG.info("Fetching available Parking spot for four wheelers from database .. ");
		List<ParkingSpot> parkingSpots = parkingSpotRepositiry.findAllAvailableFourParkingSpots();
		Collections.sort(parkingSpots, (t1, t2) -> t1.getParkingSpotId().compareTo(t2.getParkingSpotId()));
		return parkingSpots;
	}
}
