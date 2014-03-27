package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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
		@Path("/commandeId/{id}")
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
	public String getProductByIdFromCartService(@PathParam("id") String strId) throws JSONException {		
		Product p1 = new Product("book", 30.00, 3);
		Gson gson = new Gson();
		String response  = gson.toJson(p1);
		String testjson="{'id':1,'product_id':1,'user_id':1,'quantity':null,'url':'http://webservicecommande-85865.euw1.nitrousbox.com/carts/1.json'},{'id':2,'product_id':1,'user_id':1,'quantity':5,'url':'http://webservicecommande-85865.euw1.nitrousbox.com/carts/2.json'}";		
		//User user = this.getUserByID(parameters);
		JSONObject jo = new JSONObject(testjson);
		
		String userId = jo.get("user_id").toString();
		
		return userId;
	}
	
	// @POST here defines, this method will method will process HTTP POST
	// requests.
	@POST
	@Path("/commande")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createFactureFromJson(String parameters) throws JSONException {			
		
		String result = "Facture created : ";
		return Response.status(200).entity(result).build();
	}
	
	public User getUserByID(String userId)
	{
		
		return null;
	}
	
	public String getProductStringByID(String strId) throws IOException
	{
		URL url = new URL("http://webservicecommande-85865.euw1.nitrousbox.com/products/"+strId+".json");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
 
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		
		conn.disconnect();
		return output;
			
	}

}
