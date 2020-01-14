package com.enigma.rio.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.enigma.rio.db.entity.Batch;

public interface BatchRepository extends CrudRepository<Batch, Integer>{
	Batch getById(Integer id);
}
