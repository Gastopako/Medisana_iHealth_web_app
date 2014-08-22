package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.medisanaspace.web.library.AuthorizationBuilder;
import com.medisanaspace.web.library.HeaderPrinter;
import com.medisanaspace.web.library.VitaDockServer;
import com.medisanaspace.web.main.DownloadMedisanaResources;

@WebServlet("/Medisana")
public class Medisana extends HttpServlet {

	private static final long serialVersionUID = -5840667841095739840L;
	
	//Testinio serverio
//	public static String APPLICATION_TOKEN = "8qNC5GYYuzloCbvPDswwkMEhFAjjEw4cUpej4Pa2fV7BGJT2ff7E6NluyewLT4W7";
//	public static String APPLICATION_SECRET = "paosTaVfCZaDAxNEtjV7WtkoeDKhDUKCFbVfLCFvhvYuDje7KXUVP3Z0ilL0E6Ad";
	
	//Komercinio serverio
	public static String APPLICATION_TOKEN = "JycbU9obD6GXq95UhUEcxAJE8ME7DZnqbgPXe0jviyYytm1lnB04L8yKdpp0iWAT";
	public static String APPLICATION_SECRET = "ghqMm4W0XqaULJD8Vg35G4k87CLn6CbvRrkLfwKq915fdVWklN5W09Eg1qR9WXfo";
	
    public Medisana() {
        super(); }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		 doPost(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String[] getLoginUrlPayload = getLoginUrl();		
		 
		 String oauthSecret = getLoginUrlPayload[0]; 
		 String LoginUrl = getLoginUrlPayload[1];
		 
		 response.sendRedirect(LoginUrl); // Redirect'ina i Login page'a.
	
		 HttpSession session = request.getSession();
		 
		 session.setAttribute("oauthSecret", oauthSecret);
		 
		 String ss = "GiveCardiodockData";
	     session.setAttribute("button", ss); 

			     if (request.getParameter("action1") != null) {
			    // Invoke action 1.				
				String s = "GiveCardiodockData";
				session.setAttribute("button", s); }
			     
			else if (request.getParameter("action2") != null) {
			    // Invoke action 2.
				String s = "GiveGlucodockglucoseData";
				session.setAttribute("button", s); }
			     
			else if (request.getParameter("action3") != null) {
			    // Invoke action 3.
				String s = "GiveGlucodockinsulinData";
				session.setAttribute("button", s); }
			     
			else if (request.getParameter("action4") != null) {
			    // Invoke action 4.
				String s = "GiveGlucodockmealData";
				session.setAttribute("button", s); }
			     
			else if (request.getParameter("action5") != null) {
			    // Invoke action 5.
				String s = "GiveTargetscaleData";
				session.setAttribute("button", s); }
			     
			else if (request.getParameter("action6") != null) {
			    // Invoke action 6.
				String s = "GiveThermodockData";
				session.setAttribute("button", s); }
			     
			else if (request.getParameter("action7") != null) {
			    // Invoke action 7.
			    String s = "GiveActivitydockData";
			    session.setAttribute("button", s); }	
			     
			else if (request.getParameter("action8") != null) {
				// Invoke action 8.
				String s = "GiveTrackerstatsData";
			    session.setAttribute("button", s); }	
			     
			else if (request.getParameter("action9") != null) {
			    // Invoke action 9.
			    String s = "GiveTrackeractivityData";
			    session.setAttribute("button", s); }
			     
			else if (request.getParameter("action10") != null) {
			    // Invoke action 10.
			    String s = "GiveTrackersleepData";
			    session.setAttribute("button", s); }		    	   	    		 
	   }
	
	private String[] getLoginUrl(){
        	    	
    	    String oauthToken = null;
    	    String oauthSecret  = null;
		
	    	HttpPost httppost = null;
	    	String str = null;
	    	BufferedReader bufferReader = null;
	    	HttpResponse response = null;

	    	String uriOauthRequest = "";
	    	String authorization = "";
				    	
			// Acquire Unauthorized Access Token
	        DefaultHttpClient httpClient = new DefaultHttpClient();
			uriOauthRequest = VitaDockServer.HTTPS_AUTH_URL	+ "/unauthorizedaccesses";
					
			try {
			authorization = AuthorizationBuilder.createUnauthorizedAccessRequestAuthorizationHeader(
		    uriOauthRequest, APPLICATION_TOKEN, APPLICATION_SECRET); } 
		
			catch (Exception e) {	e.printStackTrace(); }
			
			httppost = new HttpPost(uriOauthRequest);
			httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");
			httppost.setHeader("Authorization", authorization);
			HeaderPrinter.printPost(httppost);

			try { response = httpClient.execute(httppost); } 
			catch (IOException e) {	e.printStackTrace(); }
			
			try {
				try {
				bufferReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent())); } 

				catch (IOException e) { e.printStackTrace();}
				
				final StringBuffer strBuffer = new StringBuffer();
				try {
					while ((str = bufferReader.readLine()) != null) {
						strBuffer.append(str); } } 
				
				catch (IOException e) { e.printStackTrace(); }

				str = strBuffer.toString();
				System.out.println("    Response: " + str + "\n--------------");
				
				if (str.split("&").length < 2) {
					
					try { throw new Exception(str);	} 
					catch (Exception e) {	e.printStackTrace(); } }
				
				oauthToken = str.split("&")[0].split("=")[1];
				oauthSecret = str.split("&")[1].split("=")[1];		
			} 
			
			finally {
				if (bufferReader != null) {
					try { bufferReader.close();	} 
					
					catch (IOException e) {	e.printStackTrace(); } }
				
				httpClient.getConnectionManager().shutdown(); }
		
			String LoginUrl = VitaDockServer.HTTPS_LOGIN_URL + "/desiredaccessrights/request?oauth_token=" + oauthToken;
					
			String[] getLoginUrlPayload = new String[2];

			getLoginUrlPayload[0] = oauthSecret;
			getLoginUrlPayload[1] = LoginUrl;
			
        return getLoginUrlPayload;
    }
		    	    		    		     
		    @WebServlet(urlPatterns = "/MedisanaCallback")
		    public static class MedisanaCallback extends HttpServlet {

				private static final long serialVersionUID = 4360255889465779310L;

			@Override
		    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response); }
			
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    	
                response.setContentType("text/html;charset=UTF-8");

    		    try {
    		    	
    		    StringBuffer callback_url = request.getRequestURL();
    		    
    		    String oauth_verifier = request.getParameter("oauth_verifier");
    		    String oauth_token = request.getParameter("oauth_token");
    		    
    		    System.out.println("Callback URL: " + callback_url + "\n--------------");
    		    System.out.println("Token: " + oauth_token + "\n--------------");
    		    System.out.println("Verifier: " + oauth_verifier + "\n--------------");	    
    		    
    		    HttpSession session = request.getSession();  
    		    
    		    String oauth_secret = session.getAttribute("oauthSecret").toString();
    		    
    		    String[] connectToServerPayload = connectToServer(oauth_token, oauth_secret, oauth_verifier);
    			String accessToken = connectToServerPayload[0];
    			String accessSecret = connectToServerPayload[1];
    		        		      		       		   
    		    // Vietoj redirect duomenu persintimui ir redirectinimui i jsp peidza naudojamas RequestDispatcher	
 		    	request.setAttribute("Verifier", oauth_verifier); 
 		    	 		    			    

   		        switch (session.getAttribute("button").toString()) {
   		    	   case "GiveCardiodockData":
   	 		        String Cardiodock = downloadCardiodockData(accessToken, accessSecret);
   	   		        System.out.println("Cardiodock: " + Cardiodock);
   	   		        request.setAttribute("data", Cardiodock);
   		    	   break;
   		    	   
   		    	   case "GiveGlucodockglucoseData":
   					String Glucodockglucose = downloadGlucodockglucoseData(accessToken, accessSecret);
   					System.out.println("Glucodockglucose: " + Glucodockglucose);
   					request.setAttribute("data", Glucodockglucose); 	
   				   break;
   				   
   		    	   case "GiveGlucodockinsulinData":
   					String Glucodockinsulin = downloadGlucodockinsulinData(accessToken, accessSecret);
   					System.out.println("Glucodockinsulin: " + Glucodockinsulin);
   					request.setAttribute("data", Glucodockinsulin); 
   				   break;
   				   
   		    	   case "GiveGlucodockmealData":
   					String Glucodockmeal = downloadGlucodockmealData(accessToken, accessSecret);
   					System.out.println("Glucodockmeal: " + Glucodockmeal);
   					request.setAttribute("data", Glucodockmeal);  
   				   break;
   				   
   		    	   case "GiveTargetscaleData":
   					String Targetscale = downloadTargetscaleData(accessToken, accessSecret);
   					System.out.println("Targetscale: "  + Targetscale);
   					request.setAttribute("data", Targetscale); 
   				   break;
   				   
   		    	   case "GiveThermodockData":
   					String Thermodock = downloadThermodockData(accessToken, accessSecret);
   					System.out.println("Thermodock: " + Thermodock);
   					request.setAttribute("data", Thermodock);  
   				   break;
   				   
   		    	   case "GiveActivitydockData":
      		    	String Activitydock = downloadActivitydockData(accessToken, accessSecret);
      		    	System.out.println("Activitydock: " + Activitydock);
      		    	request.setAttribute("data", Activitydock); 
      		       break; 
      		       
   		    	   case "TrackerstatsData":
   					String Trackerstats = downloadTrackerstatsData(accessToken, accessSecret);
   					System.out.println("Trackeractivity: " + Trackerstats);
   					request.setAttribute("data", Trackerstats); 
   				   
   		    	   case "GiveTrackeractivityData":
   					String Trackeractivity = downloadTrackeractivityData(accessToken, accessSecret);
   					System.out.println("Trackeractivity: " + Trackeractivity);
   					request.setAttribute("data", Trackeractivity); 
   					
   		    	   case "GiveTrackersleepData":
   					String Trackersleep = downloadTrackersleepData(accessToken, accessSecret);
   					System.out.println("Trackersleep: " + Trackersleep);
   					request.setAttribute("data", Trackersleep); 
   		    	   break;
   		    	   
   		        }  
    		    request.getRequestDispatcher("MedisanaUI.jsp").forward(request, response); 
    		    }      		     
    		    
    		    finally {} 
    		    }
            
            
            
            
            private String downloadCardiodockData(String accessToken, String accessSecret) {
            	String responseCardiodock = null;
        		DownloadMedisanaResources mDownloadMedisanaResources = new DownloadMedisanaResources();
        		
        		try { responseCardiodock = mDownloadMedisanaResources.syncData(APPLICATION_TOKEN, APPLICATION_SECRET, AuthorizationBuilder.CARDIODOCK_MODULE_ID, accessToken, accessSecret); } 
        		catch (Exception e) { e.printStackTrace(); }
        						
        		return responseCardiodock;	
            }	    			    	   
            
            private String downloadGlucodockglucoseData(String accessToken, String accessSecret) {
            	String responseGlucodockglucose = null;
        		DownloadMedisanaResources mDownloadMedisanaResources = new DownloadMedisanaResources();
        		
        		try {
        			responseGlucodockglucose = mDownloadMedisanaResources.syncData(APPLICATION_TOKEN, APPLICATION_SECRET,
        					       AuthorizationBuilder.GLUCODOCK_GLUCOSE_MODULE_ID, accessToken, accessSecret);		
        		} 
        		catch (Exception e) {e.printStackTrace();}
        						
        		return responseGlucodockglucose;	
            }	
            
            private String downloadGlucodockinsulinData(String accessToken, String accessSecret) {
            	String responseGlucodockinsulin = null;
        		DownloadMedisanaResources mDownloadMedisanaResources = new DownloadMedisanaResources();
        		
        		try {
        			responseGlucodockinsulin = mDownloadMedisanaResources.syncData(APPLICATION_TOKEN, APPLICATION_SECRET,
        					       AuthorizationBuilder.GLUCODOCK_INSULIN_MODULE_ID, accessToken, accessSecret);		
        		} 
        		catch (Exception e) {e.printStackTrace();}
        						
        		return responseGlucodockinsulin;	
            }	  
            
            private String downloadGlucodockmealData(String accessToken, String accessSecret) {
            	String responseGlucodockmeal = null;
        		DownloadMedisanaResources mDownloadMedisanaResources = new DownloadMedisanaResources();
        		
        		try {
        			responseGlucodockmeal = mDownloadMedisanaResources.syncData(APPLICATION_TOKEN, APPLICATION_SECRET,
        					       AuthorizationBuilder.GLUCODOCK_MEAL_MODULE_ID, accessToken, accessSecret);		
        		} 
        		catch (Exception e) {e.printStackTrace();}
        						
        		return responseGlucodockmeal;	
            }	
            
            private String downloadTargetscaleData(String accessToken, String accessSecret) {
            	String responseTargetscale = null;
        		DownloadMedisanaResources mDownloadMedisanaResources = new DownloadMedisanaResources();
        		
        		try {
        			responseTargetscale = mDownloadMedisanaResources.syncData(APPLICATION_TOKEN, APPLICATION_SECRET,
        					       AuthorizationBuilder.TARGETSCALE_MODULE_ID, accessToken, accessSecret);		
        		} 
        		catch (Exception e) {e.printStackTrace();}
        						
        		return responseTargetscale;	
            }	
            
            private String downloadThermodockData(String accessToken, String accessSecret) {
            	String responseThermodock = null;
        		DownloadMedisanaResources mDownloadMedisanaResources = new DownloadMedisanaResources();
        		
        		try	{
        			responseThermodock = mDownloadMedisanaResources.syncData(APPLICATION_TOKEN, APPLICATION_SECRET,
        					       AuthorizationBuilder.THERMODOCK_MODULE_ID, accessToken, accessSecret);		
        		} 
        		catch (Exception e) {e.printStackTrace();}
        						
        		return responseThermodock;	
            }	
            
            private String downloadActivitydockData(String accessToken, String accessSecret) {
            	String responseActivitydock = null;
        		DownloadMedisanaResources mDownloadMedisanaResources = new DownloadMedisanaResources();
        		
        		try {
        			responseActivitydock = mDownloadMedisanaResources.syncData(APPLICATION_TOKEN, APPLICATION_SECRET,
        					       AuthorizationBuilder.ACTIVITYDOCK_MODULE_ID, accessToken, accessSecret);		
        		} 
        		catch (Exception e) {e.printStackTrace();}
        						
        		return responseActivitydock;	
            }	
                        
            private String downloadTrackerstatsData(String accessToken, String accessSecret) {
            	String responseTrackerstats = null;
        		DownloadMedisanaResources mDownloadMedisanaResources = new DownloadMedisanaResources();
        		
        		try {
        			responseTrackerstats = mDownloadMedisanaResources .syncData(APPLICATION_TOKEN, APPLICATION_SECRET,
        					       AuthorizationBuilder.TRACKER_STATS_ID, accessToken, accessSecret);		
        		} 
        		catch (Exception e) {e.printStackTrace();}
        						
        		return responseTrackerstats;	
            }	
            
            private String downloadTrackeractivityData(String accessToken, String accessSecret)
            {
            	String responseTrackeractivity = null;
        		DownloadMedisanaResources mDownloadMedisanaResources = new DownloadMedisanaResources();
        		
        		try {
        			responseTrackeractivity = mDownloadMedisanaResources .syncData(APPLICATION_TOKEN, APPLICATION_SECRET,
        					       AuthorizationBuilder.TRACKER_ACTIVITY_ID, accessToken, accessSecret);		
        		} 
        		catch (Exception e) {e.printStackTrace();}
        						
        		return responseTrackeractivity;	
            }	
            
            
            private String downloadTrackersleepData(String accessToken, String accessSecret)
            {
            	String responseTrackeractivity = null;
        		DownloadMedisanaResources mDownloadMedisanaResources  = new DownloadMedisanaResources();
        		
        		try {
        			responseTrackeractivity = mDownloadMedisanaResources.syncData(APPLICATION_TOKEN, APPLICATION_SECRET,
        					       AuthorizationBuilder.TRACKER_SLEEP_ID, accessToken, accessSecret);		
        		} 
        		catch (Exception e) {e.printStackTrace();}
        						
        		return responseTrackeractivity;	
            }	
     
		        
		    private String[] connectToServer(String oauthToken, String oauthSecret, String verifierToken) {
			
		    String accessToken = null; 
		    String accessSecret = null;
		    	
		    String AUTHORIZATION_STRING = "Authorization";
		    
		    HttpPost httppost = null;
		    String str = null;
		    BufferedReader bufferReader = null;
		    HttpResponse response = null;

		    String authorization = "";
		   		    
			DefaultHttpClient httpClient = new DefaultHttpClient();
		    
		    String uriOauthRequest = VitaDockServer.HTTPS_AUTH_URL + "/accesses/verify";
			System.out.println(uriOauthRequest);
			
			bufferReader = null;
			try {
				
				try {authorization = AuthorizationBuilder.createAccessRequestAuthorizationHeader(APPLICATION_TOKEN,
									                   APPLICATION_SECRET, oauthToken, oauthSecret, verifierToken);} 
				catch (Exception e) {e.printStackTrace();}
				
				httppost = new HttpPost(uriOauthRequest);
				httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");
				httppost.setHeader(AUTHORIZATION_STRING, authorization);
				HeaderPrinter.printPost(httppost);
				
				try {response = httpClient.execute(httppost);} 			
				catch (ClientProtocolException e) {e.printStackTrace();} 
				catch (IOException e) {e.printStackTrace();}
				
				str = null;
				try {bufferReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));} 
				catch (IllegalStateException e) {e.printStackTrace();} 
				catch (IOException e) {e.printStackTrace();}
				
				try {
					while ((str = bufferReader.readLine()) != null) {
						
						System.out.println("    Response: " + str + "\n--------------");
						
						accessToken = str.split("&")[0].split("=")[1];
						accessSecret = str.split("&")[1].split("=")[1];
						break;}
					
				} catch (Exception e) {System.out.println(str);}
				
			} 
			
			finally 
			{
				if (bufferReader != null) 
				{
					try {bufferReader.close();} 
					catch (IOException e) {e.printStackTrace();}
				}
				httpClient.getConnectionManager().shutdown();
			}
			
			
			String[] connectToServerPayload = new String[2];
			connectToServerPayload[0] = accessToken;
			connectToServerPayload[1] = accessSecret;
			
			return connectToServerPayload;							
			
		}
		    
		  
		    
		    
		    
		    
		    
		    
          
            
            
            
            
            
	 }
		    
		    		    		    		    



		  
}
