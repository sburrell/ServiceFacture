package com.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.models.Product;

public class ProductTest {
	Product product;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNewProduct() {
		product = new Product("book", 15.00 , 2);
		assertNotNull(product);		
	}

}
