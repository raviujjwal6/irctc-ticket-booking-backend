package com.irctc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.irctc.entity.Passenger;
import com.irctc.repository.PassengerRepository;

@Repository
public class PassengerDao {
	@Autowired
    private PassengerRepository passengerRepository;

    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    public Passenger findById(Integer passengerId) {
        return passengerRepository.findById(passengerId).orElse(null);
    }

    public void delete(Passenger passenger) {
        passengerRepository.delete(passenger);
    }

    public List<Passenger> findByUserId(Integer userId) {
        return passengerRepository.findByUserUserId(userId);
    }

}
