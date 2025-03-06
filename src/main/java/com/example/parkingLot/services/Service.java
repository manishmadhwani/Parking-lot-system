package com.example.parkingLot.services;

import com.example.parkingLot.cache.AvailableParkingSpotsCache;
import com.example.parkingLot.dtos.CustomerRequest;
import com.example.parkingLot.excptions.ReceiptNotFoundException;
import com.example.parkingLot.interfaces.ServiceInterface;
import com.example.parkingLot.model.*;
import com.example.parkingLot.repository.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.logging.Logger;

import static com.example.parkingLot.dtos.Constants.receiptNotFoundException;

@org.springframework.stereotype.Service
public class Service implements ServiceInterface {

    private static final Logger LOGGER = Logger.getLogger(Service.class.getName());

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ParkingSpotRepository parkingSpotRepositiry;

    @Autowired
    AvailableParkingSpotsCache availableParkingCache;

    @Autowired
    ReceiptRepository receiptRepository;

    @Autowired
    BillRepository billRepository;

    @Autowired
    HistoryRepository historyRepository;

    private static int calTotalTimeInMins(LocalDateTime exitTime,
                                          LocalDateTime entryTime) {
        int hours = exitTime.getHour() - entryTime.getHour();
        int mins = exitTime.getMinute() - entryTime.getMinute();

        return mins;
    }

    private static int calRate(Receipt receipt,
                               int totalhrsInTime) {
        int amount = 0;
        if (VehicleTypeEnum.FOUR_WHEELER.name().equals(receipt.getVehicleType()))
            amount = (BaseClass.getFourWhellerRate()) * totalhrsInTime;
        else if (VehicleTypeEnum.TWO_WHEELER.name().equals(receipt.getVehicleType())) {
            amount = (BaseClass.getTwoWhellerRate()) * totalhrsInTime;
        }
        return amount;
    }


    /**
    * Generate a receipt for the customer who enters
    * @Param CustomerRequest
    * @Return Receipt
    * */
    @Override
    public Receipt generateAReciept(CustomerRequest customerRequest) {
        ParkingSpot parkingSpot = null;
        if (customerRequest.getVehicleType().equals(VehicleTypeEnum.TWO_WHEELER.name())) {
            parkingSpot = availableParkingCache.getAllTwoParkingSpots()
                    .stream().filter(t -> t.getParkingSpotEVNONEV()
                            .equals(customerRequest.getVehicleTypeVariant())).findFirst().get();

        } else if (customerRequest.getVehicleType().equals(VehicleTypeEnum.FOUR_WHEELER.name())) {
            parkingSpot = availableParkingCache.getAllFourParkingSpots().stream()
                    .filter(t -> t.getParkingSpotEVNONEV()
                            .equals(customerRequest.getVehicleTypeVariant())).findFirst().get();
        }

        parkingSpot.setOccupiedFlag(Boolean.TRUE);
        ParkingSpot spot = parkingSpotRepositiry.save(parkingSpot);

        Receipt receipt = generateReceipt(customerRequest, spot);
        createEntryToVehicle(customerRequest);
        return receipt;
    }

    private void createEntryToVehicle(CustomerRequest customerRequest) {
        // Save into the history table
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNo(customerRequest.getVehicleNo());
        vehicle.setLastVisited(new Date(System.currentTimeMillis()));
        vehicle.setVehicleVariant(customerRequest.getVehicleTypeVariant());
        vehicle.setVehicleType(customerRequest.getVehicleType());
        vehicleRepository.save(vehicle);
    }

    /**
     * Generate a receipt for the customer who enters
     * @Param CustomerRequest,
     *          ParkingSpot
     * @Return Receipt
     * */
    private Receipt generateReceipt(CustomerRequest customerRequest, ParkingSpot spot) {
        // save receipt to the data-base
        Receipt receipt = new Receipt();
        receipt.setOwnerNo(customerRequest.getCustNumber());
        receipt.setVehicleNo(customerRequest.getVehicleNo());
        receipt.setVehicleVariant(customerRequest.getVehicleTypeVariant());
        receipt.setVehicleType(customerRequest.getVehicleType());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        receipt.setDate(now);
        receipt.setParkingSpotId(spot.getParkingSpotId());
        receiptRepository.save(receipt);
        return receipt;
    }

    @Transactional
    @Override
    public Bill genrateABill(int receiptId) throws ReceiptNotFoundException {
        // TODO Auto-generated method stub
        // get the receipt from the data-base
        LOGGER.info("[genrateABill] The the saved receipt from receiptId : " + receiptId);
        @SuppressWarnings("deprecation") Receipt receipt = receiptRepository.getOne(receiptId);

        if (receipt == null || Objects.isNull(receipt)) throw new ReceiptNotFoundException(receiptNotFoundException);

        Bill bill = getBill(receiptId, receipt);
        LOGGER.info("[genrateABill] Generating a bill for billId : "
                + bill.getBillId() + " and amount : " + bill.getTotalamt());
        History history = new History();
        history.setBill(bill);
        history.setReceiptId(receiptId);

        LOGGER.info("[genrateABill] Saving to the history table : " + history);
        bill.setHistory(history);
        billRepository.save(bill);

        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = null;
        sessionFactory.getCurrentSession();
        return bill;
    }

    private Bill getBill(int receiptId, Receipt receipt) {
        Bill bill = new Bill();
        bill.setReceiptId(receiptId);
        bill.setParkingSpot(receipt.getParkingSpotId());
        bill.setVehicleNo(receipt.getVehicleNo());
        bill.setVehicleType(receipt.getVehicleType());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        bill.setDate(now);

        bill.setStartTime(receipt.getDate().toLocalTime());
        bill.setEndTime(now.toLocalTime());

        int totalTimeInMis = calTotalTimeInMins(now, receipt.getDate());

        int amount = calRate(receipt, totalTimeInMis);

        bill.setTotalamt(amount);
        bill.setTotalTimeinHours(totalTimeInMis);
        bill.setVehicleOwnerNo(receipt.getOwnerNo());
        return bill;
    }
}