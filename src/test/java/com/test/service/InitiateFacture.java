package com.test.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.models.Facture;
import com.models.JsonReader;

public class InitiateFacture {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void InitFacture() throws IOException {
		Facture facture = new Facture();
		JsonReader jr = new JsonReader();
		Boolean success = jr.readJsonFromUrl("http://localhost:8080/RestfulExo/rest/FactureService/id/1");
		assertTrue(success);
	}

}
