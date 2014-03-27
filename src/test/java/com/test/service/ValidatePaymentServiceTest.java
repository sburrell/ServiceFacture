package com.test.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.service.ValidatePaymentService;

public class ValidatePaymentServiceTest {
	ValidatePaymentService vp;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testValidateFacturePayment() throws IOException {
		String strId = UUID.randomUUID().toString();
		String response = vp.validateFacturePayment(strId);
		assertEquals("ok", response);
	}

}
