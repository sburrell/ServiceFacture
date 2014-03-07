package com.models;

import java.util.UUID;

public class Product {
	private long id;
	private String name;
	private double price;
	private int quantity;	
	private static long Id_Counter = 0;
	
	public Product(String name, double price, int quantity) {
		super();
		this.id = Id_Counter +1;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.Id_Counter++;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
