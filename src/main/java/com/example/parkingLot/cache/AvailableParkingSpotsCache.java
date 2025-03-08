package com.example.parkingLot.cache;

import com.example.parkingLot.model.ParkingSpot;
import com.example.parkingLot.repository.ParkingSpotRepository;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Component
public class AvailableParkingSpotsCache {

    private final Logger LOG = LoggerFactory.getLogger(AvailableParkingSpotsCache.class);
    LinkedList<ParkingSpot> parkingSpots;
    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    @Setter
    @Getter
    List<ParkingSpot> twoWheelers;

    @Setter
    @Getter
    List<ParkingSpot> fourWheelers;

    @EventListener(ApplicationReadyEvent.class)
    public void loadAllParking() {
        LOG.info("Fetching available Parking spot for two wheelers from database .. ");
        twoWheelers = parkingSpotRepository.findAllAvailableTwoParkingSpots();

        Comparator<ParkingSpot> comp = (o1, o2) -> o1.getParkingSpotId().compareTo(o2.getParkingSpotId());
        twoWheelers.sort(comp);

        LOG.info("Fetching available Parking spot for four wheelers from database .. ");
        fourWheelers = parkingSpotRepository.findAllAvailableFourParkingSpots();
        fourWheelers.sort(comp);
    }
}
