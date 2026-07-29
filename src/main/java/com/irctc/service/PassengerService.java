package com.irctc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.dao.PassengerDao;
import com.irctc.entity.Passenger;
import com.irctc.exception.PassengerNotFoundException;

@Service
public class PassengerService {
	@Autowired
	private PassengerDao passengerDao;

	public Passenger addPassenger(Passenger passenger) {
		return passengerDao.save(passenger);
	}

	public List<Passenger> getAllPassengers() {
		return passengerDao.findAll();
	}

	public Passenger getPassengerById(Integer passengerId) {

		Passenger passenger = passengerDao.findById(passengerId);

		if (passenger == null) {
			throw new PassengerNotFoundException("Passenger Not Found");
		}

		return passenger;
	}

	public Passenger updatePassenger(Integer passengerId, Passenger passenger) {

		Passenger dbPassenger = getPassengerById(passengerId);

		dbPassenger.setPassengerName(passenger.getPassengerName());
		dbPassenger.setAge(passenger.getAge());
		dbPassenger.setGender(passenger.getGender());
		dbPassenger.setBerthPreference(passenger.getBerthPreference());

		return passengerDao.save(dbPassenger);
	}

	public String deletePassenger(Integer passengerId) {

		Passenger passenger = getPassengerById(passengerId);

		passengerDao.delete(passenger);

		return "Passenger Deleted Successfully";
	}

	public List<Passenger> getPassengersByUser(Integer userId) {
		return passengerDao.findByUserId(userId);
	}

}
