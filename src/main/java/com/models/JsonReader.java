package com.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import com.google.gson.Gson;
 

public class JsonReader {
		
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static boolean readJsonFromUrl(String url) throws IOException 
	  {
	    InputStream is = new URL(url).openStream();
	    try 
	    {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      Gson gson = new Gson();
	      Facture f = gson.fromJson(jsonText, Facture.class);
	      if(f != null)
	      {
	    	  return true;
	      }
	      else
	      {
	    	  return false;
	      }
	    } 
	    finally 
	    {
	      is.close();
	    }
	  }
}
