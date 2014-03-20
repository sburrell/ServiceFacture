package com.service;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
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
	public String validateFacturePayment(@PathParam("id") String strId) throws IOException {			
		Facture facture  = Facture.getFactureByCommandID(strId); 
		facture.setIsPaid(true);
		notifyDeliveryService(facture);		
		return "ok";
	}

	private void notifyDeliveryService(Facture facture) throws IOException {
		Facture validatedFacture = facture;
		Gson gson = new Gson();
		gson.toJson(facture);
		URL myURL = new URL("http://jarrodssite.com/DeliveryService/notify");
	    URLConnection myURLConnection = myURL.openConnection();
	    myURLConnection.connect();
	    myURLConnection.setDoOutput(true);
	    OutputStreamWriter out = new OutputStreamWriter(myURLConnection.getOutputStream());
	    out.write("string=" + gson);
	    out.close();
	    
	}
	

}
