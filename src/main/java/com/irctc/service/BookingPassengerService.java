package com.irctc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.dao.BookingPassengerDao;
import com.irctc.entity.BookingPassenger;

@Service
public class BookingPassengerService {

    @Autowired
    private BookingPassengerDao bookingPassengerDao;

    public BookingPassenger saveBookingPassenger(BookingPassenger bookingPassenger) {
        return bookingPassengerDao.saveBookingPassenger(bookingPassenger);
    }

    public List<BookingPassenger> saveAllBookingPassengers(List<BookingPassenger> bookingPassengers) {
        return bookingPassengerDao.saveAllBookingPassengers(bookingPassengers);
    }
}