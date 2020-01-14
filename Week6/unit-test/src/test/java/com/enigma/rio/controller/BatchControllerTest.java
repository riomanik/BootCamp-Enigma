package com.enigma.rio.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.enigma.rio.db.entity.Batch;
import com.enigma.rio.service.BatchService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(BatchController.class)
public class BatchControllerTest {
	public BatchControllerTest() {}
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private BatchService service;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Test
	public void getListBatchTest() throws Exception {
		Mockito.when(service.getList()).thenReturn(
				this.buildListBatch()
				);
				
		MvcResult result = mvc.perform(get("/batches")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andReturn();
//		System.out.println(ObjectMapper.writeValueAsString(this.buildListBatch()));
		assertEquals(objectMapper.writeValueAsString(this.buildListBatch()), result.getResponse().getContentAsString());
				
	}
	
	@Test
	public void saveBatchTest() throws Exception {
		Mockito.when(service.save(any(Batch.class))).thenReturn(
				this.buildListBatch().get(0)
				);
		
		MvcResult result = mvc.perform(
				post("/batches")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(this.buildListBatch().get(0)))
				)
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andReturn();
		
		assertEquals(objectMapper.writeValueAsString(this.buildListBatch().get(0)), result.getResponse().getContentAsString());
	}

	private List<Batch> buildListBatch(){
		List<Batch> data = new ArrayList<>();
		for (int i = 0; i < 5; i++)  {
			Batch batch = new Batch();
			int seq = i+1;
			batch.setId(seq);
			batch.setSequence(seq);
			batch.setName("Batch "+(seq));
			batch.setDescription(batch.getName());
			data.add(batch);
		}
		return data;
	}
}
