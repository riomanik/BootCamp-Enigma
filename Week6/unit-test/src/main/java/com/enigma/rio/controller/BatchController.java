package com.enigma.rio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.rio.db.entity.Batch;
import com.enigma.rio.service.BatchService;


@RestController
@RequestMapping("/batches")
public class BatchController {
	@Autowired
	private BatchService service;
	
	@GetMapping
	public ResponseEntity<List<Batch>> getListBatch(){
		List<Batch> result = service.getList();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Batch> saveBatch(@RequestBody Batch batch){
		return new ResponseEntity<>(service.save(batch), HttpStatus.OK);
	}
}
