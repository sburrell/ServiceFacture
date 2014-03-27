package com.test.model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

import com.models.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.models.Facture;

public class FactureTest {
	Facture facture;
	ArrayList<Product> products= new ArrayList<Product>();	

	@Before
	public void setUp() throws Exception {
		
		Product p1 = new Product("book", 20.00, 2);
		Product p2 = new Product("shirt", 25.00, 1);
		Product p3 = new Product("cd", 10.00, 3);
		products.add(p1);
		products.add(p2);
		products.add(p3);		
	}

	@Test
	public void testFactureDateUUIDDoubleArrayListOfProduct() {
	//	facture = new Facture(new Date(System.currentTimeMillis()), UUID.randomUUID(), products);
	//	assertNotNull(facture);
	}
	
	@Test
	public void testSetTotal() throws IllegalArgumentException
	{
	//	facture = new Facture(new Date(System.currentTimeMillis()), UUID.randomUUID(), products);
	//	assertEquals(55.00, facture.getTotal(), 0.001);
	}

	@Test
	public void testSetProducts() {
	//	facture = new Facture(new Date(System.currentTimeMillis()), UUID.randomUUID(), products);
	//	assertEquals(3,facture.getProducts().size());
	}

}
