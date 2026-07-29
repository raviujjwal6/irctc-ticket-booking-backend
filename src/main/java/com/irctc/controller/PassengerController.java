package com.irctc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.entity.Passenger;
import com.irctc.service.PassengerService;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return passengerService.addPassenger(passenger);
    }

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{passengerId}")
    public Passenger getPassengerById(@PathVariable Integer passengerId) {
        return passengerService.getPassengerById(passengerId);
    }

    @PutMapping("/{passengerId}")
    public Passenger updatePassenger(@PathVariable Integer passengerId,
                                     @RequestBody Passenger passenger) {
        return passengerService.updatePassenger(passengerId, passenger);
    }

    @DeleteMapping("/{passengerId}")
    public String deletePassenger(@PathVariable Integer passengerId) {
        return passengerService.deletePassenger(passengerId);
    }

    @GetMapping("/user/{userId}")
    public List<Passenger> getPassengersByUser(@PathVariable Integer userId) {
        return passengerService.getPassengersByUser(userId);
    }
}