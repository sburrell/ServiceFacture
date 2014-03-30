package com.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

public class Facture {
	private int id;
	private Date datetime;
	private int commandeId;
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

	public Facture(int id, Date datetime, int commandeId, double total,
			boolean isPaid) {
		super();
		this.id = id;
		this.datetime = datetime;
		this.commandeId = commandeId;
		this.total = total;
		IsPaid = isPaid;
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
	
	public int getCommandeId() {
		return commandeId;
	}

	public void setCommandeId(int commandeId) {
		this.commandeId = commandeId;
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
		//setTotal();
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
				myFacture.setId(rs.getInt("ID"));
				myFacture.setDatetime(rs.getDate("Date"));
				myFacture.setCommandeId(rs.getInt("CommandeId"));
				myFacture.setTotal(rs.getDouble("Total"));
				myFacture.setIsPaid(rs.getBoolean("isPaid"));
			}
			return myFacture;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Facture> getFacturesByDate(Date date){			
		ConnectionDB myDB = new ConnectionDB();
		String sql = "SELECT * FROM Factures WHERE DATE=" + date;
		ArrayList<Facture> myFactures = new ArrayList<Facture>();
		try {
			ResultSet rs = myDB.readDataBase(sql);
			while(rs.next()){
				Facture f = new Facture(rs.getInt("ID"), rs.getDate("Date"), rs.getInt("CommandeId"), rs.getDouble("Total"), rs.getBoolean("isPaid"));			
				myFactures.add(f);
			}
			return myFactures;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Facture> getPaidFactures(){			
		ConnectionDB myDB = new ConnectionDB();
		String sql = "SELECT * FROM Factures WHERE isPaid=" + true;
		ArrayList<Facture> myFactures = new ArrayList<Facture>();
		try {
			ResultSet rs = myDB.readDataBase(sql);
			while(rs.next()){
				Facture f = new Facture(rs.getInt("ID"), rs.getDate("Date"), rs.getInt("CommandeId"), rs.getDouble("Total"), rs.getBoolean("isPaid"));			
				myFactures.add(f);
			}
			return myFactures;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Facture> getUnPaidFactures(){			
		ConnectionDB myDB = new ConnectionDB();
		String sql = "SELECT * FROM Factures WHERE isPaid=" + false;
		ArrayList<Facture> myFactures = new ArrayList<Facture>();
		try {
			ResultSet rs = myDB.readDataBase(sql);
			while(rs.next()){
				Facture f = new Facture(rs.getInt("ID"), rs.getDate("Date"), rs.getInt("CommandeId"), rs.getDouble("Total"), rs.getBoolean("isPaid"));			
				myFactures.add(f);
			}
			return myFactures;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Facture getFactureByCommandID(String id) {
		ConnectionDB myDB = new ConnectionDB();
		String sql = "SELECT * FROM Factures WHERE CommandeId=" + id;
		try {
			ResultSet rs = myDB.readDataBase(sql);
			Facture myFacture = new Facture();
			if(rs.next()){
				myFacture.setId(rs.getInt("ID"));
				myFacture.setDatetime(rs.getDate("Date"));
				myFacture.setCommandeId(rs.getInt("CommandeId"));
				myFacture.setTotal(rs.getDouble("Total"));
				myFacture.setIsPaid(rs.getBoolean("isPaid"));
			}
			return myFacture;
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertFacture(){
		ConnectionDB myDB = new ConnectionDB();
		Date date = this.getDatetime();
		int commandeId = this.getCommandeId();
		double total = this.getTotal();
		Boolean isPaid = this.isIsPaid();
		
		String sql = "INSERT INTO Facture VALUES "
				+ date + ", "
				+ commandeId + ", "
				+ total + ", "
				+ isPaid;
		
		try {
			ResultSet rs = myDB.readDataBase(sql);
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//Fonction créant un fichier txt de la facture
	public void toFile(){	
		try {
			File monPDF = new File("Facture" + this.getId() +".txt");
			monPDF.createNewFile();
			FileWriter fw = new FileWriter(monPDF);
			fw.write(this.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
