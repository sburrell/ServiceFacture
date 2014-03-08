package com.models;

import java.util.Date;
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

	public Facture(Date datetime, UUID userId, ArrayList<Product> products) {
		super();
		this.id = UUID.randomUUID();
		this.setDatetime(datetime);
		this.setUserId(userId);
		this.setProducts(products);	
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

	public void setTotal() {
		if(this.products.size()!=0)
		{
			for(Product p: this.products)
			{
				this.total += p.getPrice();
			}
		}
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
		setTotal();
	}
		
	public boolean isIsPaid() {
		return IsPaid;
	}

	public void setIsPaid(boolean isPaid) {
		IsPaid = isPaid;
	}

	public static Facture getFactureById(String id){			
		// get from DB		
		Product p1 = new Product("book", 20.00, 2);
		Product p2 = new Product("shirt", 25.00, 1);
		Product p3 = new Product("cd", 10.00, 3);
		ArrayList<Product> tmpproducts = new ArrayList();
		tmpproducts.add(p1);
		tmpproducts.add(p2);
		tmpproducts.add(p3);
		Facture myFacture = new Facture(new Date(System.currentTimeMillis()), UUID.randomUUID(), tmpproducts);
		return myFacture;
	}
	
	public static Facture getFactureByCommandID(String strId) {
		Product p1 = new Product("book", 20.00, 2);
		Product p2 = new Product("shirt", 25.00, 1);
		Product p3 = new Product("cd", 10.00, 3);
		ArrayList<Product> tmpproducts = new ArrayList();
		tmpproducts.add(p1);
		tmpproducts.add(p2);
		tmpproducts.add(p3);
		Facture myFacture = new Facture(new Date(System.currentTimeMillis()), UUID.randomUUID(), tmpproducts);
		return myFacture;
	}
	
	
	
}
