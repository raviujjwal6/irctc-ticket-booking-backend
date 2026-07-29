package com.irctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.entity.BookingPassenger;

public interface BookingPassengerRepository extends JpaRepository<BookingPassenger, Integer> {

}