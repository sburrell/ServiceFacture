package com.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.models.Facture;


// @Path here defines class level path. Identifies the URI path that&nbsp;
// a resource class will serve requests for.
@Path("ValidatePaymentService")
public class ValidatePaymentService {

	// @GET here defines, this method will method will process HTTP GET
	// requests.
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String validateFacturePayment(@PathParam("id") String strId) {			
		Facture facture  = Facture.getFactureByCommandID(strId); 
		facture.setIsPaid(true);
		notifyDeliveryService(facture);		
		return "ok";
	}

	private void notifyDeliveryService(Facture facture) {
		Facture validatedFacture = facture;
		//create json to send to delivery
	}
	

}
