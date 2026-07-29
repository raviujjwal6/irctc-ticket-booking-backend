package com.irctc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.dao.TrainDao;
import com.irctc.entity.Train;
import com.irctc.exception.TrainNotFoundException;

@Service
public class TrainService {
	@Autowired
	private TrainDao trainDao;
	
	 public Train addTrain(Train train) {
	        return trainDao.save(train);
	    }

	    public List<Train> getAllTrains() {
	        return trainDao.findAll();
	    }

	    public Train getTrainById(Integer trainId) {

	        Train train = trainDao.findById(trainId);

	        if (train == null) {
	            throw new TrainNotFoundException("Train Not Found");
	        }

	        return train;
	    }

	    public Train updateTrain(Integer trainId, Train train) {

	        Train dbTrain = getTrainById(trainId);

	        dbTrain.setTrainNumber(train.getTrainNumber());
	        dbTrain.setTrainName(train.getTrainName());
	        dbTrain.setSource(train.getSource());
	        dbTrain.setDestination(train.getDestination());
	        dbTrain.setDepartureTime(train.getDepartureTime());
	        dbTrain.setArrivalTime(train.getArrivalTime());

	        return trainDao.save(dbTrain);
	    }

	    public String deleteTrain(Integer trainId) {

	        Train train = getTrainById(trainId);

	        trainDao.delete(train);

	        return "Train Deleted Successfully";
	    }

	    public List<Train> searchTrain(String source, String destination) {

	        List<Train> trains = trainDao.search(source, destination);

	        if (trains.isEmpty()) {
	            throw new TrainNotFoundException("No Train Found");
	        }

	        return trains;
	    }
	

}
