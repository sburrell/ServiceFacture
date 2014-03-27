package com.client;

import java.util.UUID;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class FactureClient {
	public static final String BASE_URI = "http://webservicecommande-85865.euw1.nitrousbox.com";
	public static final String PATH_ID = "/products/2.json";

	public static void main(String[] args) {
		UUID id = UUID.randomUUID();
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource resource = client.resource(BASE_URI);
		WebResource nameResource = resource.path("rest").path(PATH_ID + id);
		System.out.println("Client Response \n"
				+ getClientResponse(nameResource));
	}

	/**
	 * Returns client response. e.g :&nbsp; GET
	 * http://localhost:8080/RESTfulWS/rest/UserInfoService/name/Pavithra&nbsp;
	 * returned a response status of 200 OK
	 * 
	 * @param service
	 * @return
	 */
	private static String getClientResponse(WebResource resource) {
		return resource.accept(MediaType.TEXT_XML).get(ClientResponse.class)
				.toString();
	}

	/**
	 * Returns the response as XML e.g :
	 * <User><Name>Pavithra</Name></User>&nbsp; &nbsp;
	 * 
	 * @param service
	 * @return
	 */
	private static String getResponse(WebResource resource) {
		return resource.accept(MediaType.TEXT_XML).get(String.class);
	}
}