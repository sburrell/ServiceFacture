package com.test.model;

import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import com.models.ConnectionDB;
import com.models.Facture;
import com.models.Product;

public class FactureDBTest {
	Facture facture;
	ConnectionDB myDB;
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testGetFacture() {
		String sql = "SELECT * FROM FACTURES";
		try {
			ResultSet rs = myDB.readDataBase(sql);
			assertNotNull(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testGetFactureByID(){
		String sql = "SELECT * FROM FACTURES WHERE ID=" + 1;
		try {
			ResultSet rs = myDB.readDataBase(sql);
			assertNotNull(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetFactureByCommand(){
		String sql = "SELECT * FROM FACTURES WHERE CommandID=" + 1;
		try {
			ResultSet rs = myDB.readDataBase(sql);
			assertNotNull(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertFacture(){
		Facture facture = new Facture();
	}
	
}
