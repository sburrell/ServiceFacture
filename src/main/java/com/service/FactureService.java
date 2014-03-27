package com.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.models.Facture;
import com.models.Product;
import com.models.User;


// @Path here defines class level path. Identifies the URI path that&nbsp;
// a resource class will serve requests for.
@Path("FactureService")
public class FactureService {

	// @GET here defines, this method will method will process HTTP GET
	// requests.
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFactureById(@PathParam("id") String strId) {		
		Facture facture = Facture.getFactureById(strId);
		Gson gson = new Gson();
		String response  = gson.toJson(facture);
		return response;
	}
	
	// @GET here defines, this method will method will process HTTP GET
		// requests.
		@GET
		@Path("/commande/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public String getFactureByCommandeId(@PathParam("id") String strId) {		
			Facture facture = Facture.getFactureById(strId);
			Gson gson = new Gson();
			String response  = gson.toJson(facture);
			return response;
		}
	
	// @GET here defines, this method will method will process HTTP GET
	// requests.
	@GET
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getProduct(@PathParam("id") String strId) {		
		Product p1 = new Product("book", 30.00, 3);
		Gson gson = new Gson();
		String response  = gson.toJson(p1);
		return response;
	}
	
	// @POST here defines, this method will method will process HTTP POST
	// requests.
	@POST
	@Path("/commande/")
	@Consumes(MediaType.APPLICATION_JSON)
	public String getCommandeFromJson(String parameters) {			
		Gson gson = new Gson();
		User user = this.getUserByID(parameters);
		
		Facture myFacture = new Facture();
		myFacture.setDatetime(new java.util.Date());
		myFacture.setCommandeId(2);
		myFacture.setIsPaid(false);
		myFacture.setTotal(45.67);
		myFacture.insertFacture();
		return "ok";
	}
	
	public User getUserByID(String userId)
	{
		
		return null;
	}

}
