package com.enigma.rio.service;

import java.util.List;

import com.enigma.rio.db.entity.Batch;

public interface BatchService {
	List<Batch> getList();
	Batch getById(Integer id);
	Batch save(Batch batch);
}
