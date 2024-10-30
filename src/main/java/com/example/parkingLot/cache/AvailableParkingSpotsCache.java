package com.example.parkingLot.cache;

import com.example.parkingLot.model.ParkingSpot;
import com.example.parkingLot.repository.ParkingSpotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class AvailableParkingSpotsCache {

    @Autowired
    ParkingSpotRepository parkingSpotRepositiry;
    private final Logger LOG = LoggerFactory.getLogger(AvailableParkingSpotsCache.class);

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
