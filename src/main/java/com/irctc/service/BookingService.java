package com.irctc.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.dao.BookingDao;
import com.irctc.dao.BookingPassengerDao;
import com.irctc.entity.Booking;
import com.irctc.entity.BookingPassenger;
import com.irctc.exception.BookingNotFoundException;

@Service
public class BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private BookingPassengerDao bookingPassengerDao;

    public Booking bookTicket(Booking booking) {

        booking.setPnr(UUID.randomUUID().toString().substring(0, 8));
        booking.setBookingStatus("CONFIRMED");

        // Save Booking first
        Booking savedBooking = bookingDao.saveBooking(booking);

        // Save BookingPassenger records
        if (savedBooking.getBookingPassengers() != null) {

            for (BookingPassenger bp : savedBooking.getBookingPassengers()) {
                bp.setBooking(savedBooking);
            }

            bookingPassengerDao.saveAllBookingPassengers(savedBooking.getBookingPassengers());
        }

        return savedBooking;
    }

    public List<Booking> getAllBookings() {
        return bookingDao.getAllBookings();
    }

    public Booking getBookingById(Integer bookingId) {

        Booking booking = bookingDao.getBookingById(bookingId);

        if (booking == null) {
            throw new BookingNotFoundException("Booking Not Found");
        }

        return booking;
    }

    public String cancelBooking(Integer bookingId) {

        Booking booking = getBookingById(bookingId);

        booking.setBookingStatus("CANCELLED");

        bookingDao.saveBooking(booking);

        return "Ticket Cancelled Successfully";
    }

    public List<Booking> getBookingsByUser(Integer userId) {
        return bookingDao.getBookingsByUser(userId);
    }
}