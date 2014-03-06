package com.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

public class Facture {
	private UUID id;
	private Date datetime;
	private UUID userId;
	private double total;
	private ArrayList<Product> products;
	private boolean IsPaid;
	
	public Facture() {
		super();
		this.id = UUID.randomUUID();
	}

	public Facture(Date datetime, UUID userId, double total,
			ArrayList<Product> products) {
		super();
		this.id = UUID.randomUUID();
		this.datetime = datetime;
		this.userId = userId;
		this.total = total;
		this.products = new ArrayList<Product>();		
		this.IsPaid = false;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
		
	public boolean isIsPaid() {
		return IsPaid;
	}

	public void setIsPaid(boolean isPaid) {
		IsPaid = isPaid;
	}

	public static Facture getFactureById(String id){			
		// get from DB		
		Facture myFacture = new Facture(new Date(System.currentTimeMillis()), UUID.randomUUID(), 30.0, null);
		return myFacture;
	}
	
	public static Facture getFactureByCommandID(String strId) {
		Facture myFacture = new Facture(new Date(System.currentTimeMillis()), UUID.randomUUID(), 30.0, null);
		return myFacture;
	}
	
	
	
}
