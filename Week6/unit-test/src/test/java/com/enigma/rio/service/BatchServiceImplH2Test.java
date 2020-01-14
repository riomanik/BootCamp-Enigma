package com.enigma.rio.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.enigma.rio.db.entity.Batch;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BatchServiceImplH2Test {
	public BatchServiceImplH2Test() {}
	
	@Autowired
	private BatchService service;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void saveTest() throws Exception {
		for (Batch batch : buildListBatch()) {
			service.save(batch);
		}
		
		Assert.assertEquals(buildListBatch().get(0).getId(), service.getById(buildListBatch().get(0).getId()).getId());
	}
	
	@Test
	public void getListTest() throws Exception {
		List<Batch> expected = new ArrayList<>();
		
		for (Batch batch : buildListBatch()) {
			expected.add(entityManager.merge(batch));
		}
		entityManager.flush();
		
		List<Batch> actual = service.getList();
		
		Assert.assertEquals(expected, actual);
	}

	
	@Test
	public void getByIdTest() throws Exception {
		Batch savingBatch = new Batch();
		savingBatch.setName("getByIdTest");
		savingBatch.setDescription("getByIdTest desc");
		
		Batch expected = entityManager.persist(savingBatch);
		entityManager.flush();
		
		Batch actual = service.getById(expected.getId());
		System.out.println(expected);
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
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
