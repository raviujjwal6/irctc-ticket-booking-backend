package com.irctc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.irctc.entity.Train;
import com.irctc.repository.TrainRepository;

@Repository
public class TrainDao {
	@Autowired
	private TrainRepository repository;

	public Train save(Train train) {
		return repository.save(train);
	}

	public List<Train> findAll() {
		return repository.findAll();
	}

	public Train findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public void delete(Train train) {
		repository.delete(train);
	}

	public List<Train> search(String source, String destination) {

		return repository.findBySourceAndDestination(source, destination);
	}

}
