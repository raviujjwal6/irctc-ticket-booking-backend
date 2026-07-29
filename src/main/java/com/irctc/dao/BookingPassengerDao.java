package com.irctc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.irctc.entity.BookingPassenger;
import com.irctc.repository.BookingPassengerRepository;

@Repository
public class BookingPassengerDao {

    @Autowired
    private BookingPassengerRepository bookingPassengerRepository;

    public BookingPassenger saveBookingPassenger(BookingPassenger bookingPassenger) {
        return bookingPassengerRepository.save(bookingPassenger);
    }

    public List<BookingPassenger> saveAllBookingPassengers(List<BookingPassenger> bookingPassengers) {
        return bookingPassengerRepository.saveAll(bookingPassengers);
    }
}