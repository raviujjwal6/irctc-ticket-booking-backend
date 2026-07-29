package com.irctc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

    List<Booking> findByUserUserId(Integer userId);

    Booking findByPnr(String pnr);

}
