package com.sat.architecture.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sat.architecture.config.Seat;
import com.sat.architecture.repository.SeatRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingService {

    @Autowired
    SeatRepository seatRepository;

    @Transactional
    public void handleBooking(String bookingRequest) {
        Long seatId = Long.parseLong(bookingRequest);
        Optional<Seat> seat = seatRepository.findAndLockAvailableSeat(seatId);

        if (seat.isPresent()) {
            Seat reservedSeat = seat.get();
            reservedSeat.setAvail(false);
            seatRepository.save(reservedSeat);

            System.out.println("Booking successful for seat: " + seatId);
        } else {
            System.out.println("Booking failed for seat: " + seatId);
        }
    }
}
