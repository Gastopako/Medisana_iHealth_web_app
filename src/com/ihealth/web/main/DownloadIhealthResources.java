package com.ihealth.web.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class DownloadIhealthResources {
	
	public DownloadIhealthResources() { }

    public String syncData(final String DataDownloadUrl, final String UserID, final String accessToken, final String client_id, 
    		final String client_secret, final String redirect_uri, final String sc, final String sv, final String locale) throws Exception {
    	
    HttpPost httppost = null;
    String responseStr = null;
    BufferedReader bufferReader = null;
    HttpResponse response = null;
    
	DefaultHttpClient httpClient = new DefaultHttpClient();

	bufferReader = null;
	
    String DataRequestUrl = MessageFormat.format(DataDownloadUrl, UserID.replace("\"", ""))
            + "?access_token=" + accessToken.replace("\"", "")
            + "&client_id=" + client_id
            + "&client_secret=" + client_secret
            + "&redirect_uri=" + redirect_uri
            + "&sc=" + sc
            + "&sv=" + sv
            + "&locale=" + locale;

	try {
		httppost = new HttpPost(DataRequestUrl);
		
		try {response = httpClient.execute(httppost); } 			
		catch (IOException e) {e.printStackTrace(); }
		
		try {bufferReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent())); } 
		catch (IOException e) {e.printStackTrace(); }
		
		try {
			while ((responseStr = bufferReader.readLine()) != null) 
			{break;}		

		} catch (Exception e) { } } 
	
	finally {
		if (bufferReader != null) {			
			try {bufferReader.close();} 
			catch (IOException e) {e.printStackTrace(); } }
		httpClient.getConnectionManager().shutdown(); }
	
	return responseStr;										
}
	



}


