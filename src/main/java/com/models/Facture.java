package com.models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

public class Facture {
	private int id;
	private Date datetime;
	private int userId;
	private double total;
	private ArrayList<Product> products;
	private boolean IsPaid;
	
	public Facture() {
		super();
	}

	public Facture(Date datetime, int userId, ArrayList<Product> products) {
		super();
		this.setDatetime(datetime);
		this.setUserId(userId);
		this.setProducts(products);	
		this.IsPaid = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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
		ConnectionDB myDB = new ConnectionDB();
		String sql = "SELECT * FROM Factures WHERE ID=" + id;
		try {
			ResultSet rs = myDB.readDataBase(sql);
			Facture myFacture = new Facture();
			
			if(rs.next()){
				//myFacture.setId(rs.getLong("ID"));
				myFacture.setDatetime(rs.getDate("Date"));
				//myFacture.setCommandeId(rs.getLong("CommandeId"));
				//myFacture.setTotal(rs.getDouble("Total"));
				myFacture.setIsPaid(rs.getBoolean("isPaid"));
			}
			return myFacture;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Facture getFactureByCommandID(String strId) {
		Product p1 = new Product("book", 20.00, 2);
		Product p2 = new Product("shirt", 25.00, 1);
		Product p3 = new Product("cd", 10.00, 3);
		ArrayList<Product> tmpproducts = new ArrayList();
		tmpproducts.add(p1);
		tmpproducts.add(p2);
		tmpproducts.add(p3);
		Facture myFacture = new Facture(new Date(System.currentTimeMillis()), 1, tmpproducts);
		return myFacture;
	}
	
	
	
}
