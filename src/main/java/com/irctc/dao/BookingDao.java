package com.irctc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.irctc.entity.Booking;
import com.irctc.repository.BookingRepository;

@Repository
public class BookingDao {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Integer bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    public Booking getBookingByPnr(String pnr) {
        return bookingRepository.findByPnr(pnr);
    }

    public List<Booking> getBookingsByUser(Integer userId) {
        return bookingRepository.findByUserUserId(userId);
    }

    public void deleteBooking(Integer bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}