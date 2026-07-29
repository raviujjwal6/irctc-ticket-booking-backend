package com.irctc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.irctc.entity.Train;
import com.irctc.service.TrainService;

@RestController
@RequestMapping("/trains")   
public class TrainController {

    @Autowired
    private TrainService trainService;

    // Add Train
    @PostMapping
    public Train addTrain(@RequestBody Train train) {
        return trainService.addTrain(train);
    }

    // Get All Trains
    @GetMapping
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    // Get Train By Id
    @GetMapping("/{trainId}")
    public Train getTrainById(@PathVariable Integer trainId) {
        return trainService.getTrainById(trainId);
    }

    // Update Train
    @PutMapping("/{trainId}")
    public Train updateTrain(@PathVariable Integer trainId,
                             @RequestBody Train train) {
        return trainService.updateTrain(trainId, train);
    }

    // Delete Train
    @DeleteMapping("/{trainId}")
    public String deleteTrain(@PathVariable Integer trainId) {
        return trainService.deleteTrain(trainId);
    }

    // Search Train
    @GetMapping("/search")
    public List<Train> searchTrain(@RequestParam String source,
                                   @RequestParam String destination) {
        return trainService.searchTrain(source, destination);
    }
}