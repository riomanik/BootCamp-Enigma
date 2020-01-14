package com.enigma.rio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigma.rio.db.entity.Batch;
import com.enigma.rio.db.repository.BatchRepository;


public class BatchServiceImpl implements BatchService{
	@Autowired
	private BatchRepository repository;
	
	@Override
	public List<Batch> getList(){
		return (List<Batch>) repository.findAll();
	}
	
	@Override
	public Batch getById(Integer id) {
		return repository.getById(id);
	}
	
	@Override
	public Batch save(Batch batch) {
		return repository.save(batch);
	}
	
	
}
