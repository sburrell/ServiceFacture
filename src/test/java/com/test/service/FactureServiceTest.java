package com.test.service;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.models.Facture;
import com.service.FactureService;

public class FactureServiceTest {
	
	FactureService fs;
	String strId = UUID.randomUUID().toString();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetFactureById() {
		String strId = UUID.randomUUID().toString();
		String response = fs.getFactureById(strId);
		System.out.println(response);
		//assertThat(response);
	}

}
