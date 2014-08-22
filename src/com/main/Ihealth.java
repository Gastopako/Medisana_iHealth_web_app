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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ihealth.web.main.DownloadIhealthResources;


@WebServlet("/Ihealth")
public class Ihealth extends HttpServlet {

	private static final long serialVersionUID = -8654558811175994806L;

    public static String client_id = "abecabeeea294fd4af510d1236e3eccc";
    public static String client_secret = "61e4975ccc7848cc88d1da5b547421f0";
    public static String redirect_uri = "http://158.129.12.62:8088/CARRE/IhealthCallback";
    public static String sc = "922682bde6754a8399a691b7ef82c3cd";
    public static String sv_OpenApiBP = "5edb3c838e4f4ff3a42591d0c7168914";
    public static String sv_OpenApiWeight = "5b317271e2b84e4a95e859484690a312";
    public static String sv_OpenApiBG = "c6886102b83441c2b7e65dd2d25a62ce";
    public static String sv_OpenApiSpO2 = "868cad8740c045658794504f544e2aed";
    public static String sv_OpenApiActivity = "a31793058a8742e3bb125fb31737d7ad";
    public static String sv_OpenApiSleep = "b458adc4947447c4bcf73998adeef9b3";
    public static String sv_OpenApiUserInfo = "548b05fb4213419e883e46a5bdc31785";

    private static String response_type_code = "code";
    private static String response_type_refresh_token = "refresh_token";
    private static String grant_type_authorization_code = "authorization_code";
    private static String APIName_BP = "OpenApiBP";
    private static String APIName_Weight = "OpenApiWeight";
    private static String APIName_BG = "OpenApiBG";
    private static String APIName_BO = "OpenApiSpO2";
    private static String APIName_AR = "OpenApiActivity";
    private static String APIName_SR = "OpenApiSleep";
    private static String APIName_User = "OpenApiUserInfo";

    private static String url_authorization = "https://api.ihealthlabs.com:8443/OpenApiV2/OAuthv2/userauthorization";
    private static String url_bp_data = "https://api.ihealthlabs.com:8443/openapiv2/user/{0}/bp.json/";
    private static String url_weight_data = "https://api.ihealthlabs.com:8443/openapiv2/user/{0}/weight.json/";
    private static String url_bg_data = "https://api.ihealthlabs.com:8443/openapiv2/user/{0}/glucose.json/";
    private static String url_bo_data = "https://api.ihealthlabs.com:8443/openapiv2/user/{0}/spo2.json/";
    private static String url_ar_data = "https://api.ihealthlabs.com:8443/openapiv2/user/{0}/activity.json/";
    private static String url_sr_data = "https://api.ihealthlabs.com:8443/openapiv2/user/{0}/sleep.json/";
    private static String url_user_data = "https://api.ihealthlabs.com:8443/openapiv2/user/{0}.json/";
    
    	public Ihealth() {
        super(); }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String LoginUrl = getLoginUrl();
		 System.out.println(LoginUrl);
		 
		 response.sendRedirect(LoginUrl); // Redirect'ina i Login page'a.
		  
//		 HttpSession session = request.getSession();
//		 String ss = "GiveBPData";
//	     session.setAttribute("button",ss);		         
	
//			     if (request.getParameter("action1") != null) {
//			    // Invoke action 1.			
//				String s = "GiveBPData";
//				session.setAttribute("button",s); }
//			     
//			else if (request.getParameter("action2") != null) {
//			    // Invoke action 2.
//				String s = "GiveWeightData";
//				session.setAttribute("button",s); }
//			     
//			else if (request.getParameter("action3") != null) {
//			    // Invoke action 3.
//				String s = "GiveBGData";
//				session.setAttribute("button",s); }
//			     
//			else if (request.getParameter("action4") != null) {
//			    // Invoke action 4.
//				String s = "GiveBOData";
//				session.setAttribute("button",s); }
//			     
//			else if (request.getParameter("action5") != null) {
//			    // Invoke action 5.
//				String s = "GiveARData";
//				session.setAttribute("button",s); }
//			     
//			else if (request.getParameter("action6") != null) {
//			    // Invoke action 6.
//				String s = "GiveSRData";
//				session.setAttribute("button",s); }
//			     
//			else if (request.getParameter("action7") != null) {
//			    // Invoke action 7.
//			    String s = "GiveUserData";
//			    session.setAttribute("button",s); }	
//			     
//			else if (request.getParameter("action8") != null) {
//				// Invoke action 8.
//				String s = "GiveRefreshTokenData";
//			    session.setAttribute("button",s); }		 
	}
	
		
    public String getLoginUrl() {
      String LoginUrl = url_authorization
            + "?client_id=" + client_id
            + "&response_type=" + response_type_code
            + "&redirect_uri=" + redirect_uri
            + "&APIName=" + APIName_BP + " " + APIName_Weight + " " + APIName_BG + " " + APIName_BO + " " + APIName_SR + " " + APIName_User + " " + APIName_AR;
      return LoginUrl; }
	
	
		
    @WebServlet(urlPatterns = "/IhealthCallback")
    public static class IhealthCallback extends HttpServlet {
		
    	private static final long serialVersionUID = 8542765754983890351L;
				
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response); }
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
	    try {
	    
	    String code = null;	    
	    	
	    StringBuffer callback_url = request.getRequestURL();
       
	    HttpSession session = request.getSession();
	    
	    if (request.getParameter("code") != null)
	    {code = request.getParameter("code"); 
	    session.setAttribute("code", code);}
	    else
	    {code = session.getAttribute("code").toString();} 
	    
	    System.out.println("Callback URL: " + callback_url + "\n--------------");
	    System.out.println("Code: " + code + "\n--------------");
	    
	    String[] connectToServerPayload = connectToServer(code); 
	    
	    String accessToken = connectToServerPayload[0];
	    String refreshToken = connectToServerPayload[1];
	    String userID = connectToServerPayload[2];
	     
	    request.setAttribute("Code", code); 
	    
	    accessToken = RefreshAccessToken(refreshToken); 
	    
		request.setAttribute("data", downloadBPData(accessToken, userID).toString());
		
	     if (request.getParameter("action1") != null) {
	    // Invoke action 1.		
	    String BP = downloadBPData(accessToken, userID);
		System.out.println("BP: " + BP);
		request.setAttribute("data", BP); }
	     
	else if (request.getParameter("action2") != null) {
	    // Invoke action 2.
		String Weight = downloadWeightData(accessToken, userID);
		System.out.println("Weight: " + Weight);
		request.setAttribute("data", Weight); }
	     
	else if (request.getParameter("action3") != null) {
	    // Invoke action 3.
		String BG = downloadBGData(accessToken, userID);
		System.out.println("BG: " + BG);
		request.setAttribute("data", BG); }
	     
	else if (request.getParameter("action4") != null) {
	    // Invoke action 4.
		String BO = downloadBOData(accessToken, userID);
		System.out.println("BO: " + BO);
		request.setAttribute("data", BO);
	}
	else if (request.getParameter("action5") != null) {
	    // Invoke action 5.
		String AR = downloadARData(accessToken, userID);
		System.out.println("AR: "  + AR);
		request.setAttribute("data", AR); }
	     
	else if (request.getParameter("action6") != null) {
	    // Invoke action 6.
		String SR = downloadSRData(accessToken, userID);
		System.out.println("SR: " + SR);
		request.setAttribute("data", SR); }
	     
	else if (request.getParameter("action7") != null) {
	    // Invoke action 7.
		String User = downloadUserData(accessToken, userID);
		System.out.println("User: " + User);
		request.setAttribute("data", User); }	
     
	    request.getRequestDispatcher("IhealthUI.jsp").forward(request, response);

  
//	    HttpSession session = request.getSession();
	       
//	     if (request.getParameter("action1") != null) {
//	    // Invoke action 1.			
//		String s = "GiveBPData";
//		session.setAttribute("button",s);
//	}
//	else if (request.getParameter("action2") != null) {
//	    // Invoke action 2.
//		String s = "GiveWeightData";
//		session.setAttribute("button",s);
//	}
//	else if (request.getParameter("action3") != null) {
//	    // Invoke action 3.
//		String s = "GiveBGData";
//		session.setAttribute("button",s);
//	}
//	else if (request.getParameter("action4") != null) {
//	    // Invoke action 4.
//		String s = "GiveBOData";
//		session.setAttribute("button",s);
//	}
//	else if (request.getParameter("action5") != null) {
//	    // Invoke action 5.
//		String s = "GiveARData";
//		session.setAttribute("button",s);
//	}
//	else if (request.getParameter("action6") != null) {
//	    // Invoke action 6.
//		String s = "GiveSRData";
//		session.setAttribute("button",s);
//	}
//	else if (request.getParameter("action7") != null) {
//	    // Invoke action 7.
//	    String s = "GiveUserData";
//	    session.setAttribute("button",s);
//   }	
//	else if (request.getParameter("action8") != null) {
//		// Invoke action 8.
//		String s = "GiveRefreshTokenData";
//	    session.setAttribute("button",s);
//   }
//	       
//	        switch (session.getAttribute("button").toString()) {
//	    	   case "GiveBPData":
//	   	        String BP = downloadBPData();
//		        System.out.println("BP: " + BP);
//		        request.setAttribute("data", BP); 
//	    	   break;
//	    	   
//	    	   case "GiveWeightData":
//	   			String Weight = downloadWeightData();
//				System.out.println("Weight: " + Weight);
//				request.setAttribute("data", Weight); 	
//	    	   break;
//	    	   
//	    	   case "GiveBGData":
//	   			String BG = downloadBGData();
//				System.out.println("BG: " + BG);
//				request.setAttribute("data", BG); 	
//	    	   break;    	   
//	     
//	    	   case "GiveBOData":
//	   			String BO = downloadBOData();
//				System.out.println("BO: " + BO);
//				request.setAttribute("data", BO);
//	    	   break;
//	    	   
//	    	   case "GiveARData":
//	   			String AR = downloadARData();
//				System.out.println("AR: "  + AR);
//				request.setAttribute("data", AR); 
//	    	   break;
//	    	   
//	    	   case "GiveSRData":
//	   			String SR = downloadSRData();
//				System.out.println("SR: " + SR);
//				request.setAttribute("data", SR); 
//	    	   break;
//	    	   
//	    	   case "GiveUserData":
//	   			String User = downloadUserData();
//				System.out.println("User: " + User);
//				request.setAttribute("data", User); 
//	    	   break; }
	    
	    }
	    	    
	    finally {}  		
    }
	
      
    private String[] connectToServer(String code) {
    	
    String accessToken = null;
    String refreshToken = null;
    String userID = null;
    	
    HttpPost httppost = null;
    String str = null;
    BufferedReader bufferReader = null;
    HttpResponse response = null;
    
	DefaultHttpClient httpClient = new DefaultHttpClient();

	bufferReader = null;
	
	String uriOauthRequest = url_authorization
    + "?client_id=" + client_id
    + "&client_secret=" + client_secret
    + "&grant_type=" + grant_type_authorization_code
    + "&redirect_uri=" + redirect_uri
    + "&code=" + code;
      
	try {
		
		httppost = new HttpPost(uriOauthRequest);
		
		try { response = httpClient.execute(httppost); } 			
		catch (IOException e) {e.printStackTrace();}
		
		try { bufferReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent())); } 
		catch (IOException e) {e.printStackTrace();}
		
		try {
			while ((str = bufferReader.readLine()) != null) {
				
				System.out.println("Response: " + str + "\n--------------");	
				
				break; }	
			
			// Su google GSON istraukiama AccessToken verte is JSON responso:
			JsonObject jobj = new Gson().fromJson(str, JsonObject.class);
			
			accessToken = jobj.get("AccessToken").toString();
			refreshToken = jobj.get("RefreshToken").toString();
			userID = jobj.get("UserID").toString();
			
			System.out.println("AccessToken: " +  accessToken  + "\n--------------");	
			System.out.println("RefreshToken: " +  refreshToken  + "\n--------------");	
			System.out.println("UserID: " +  userID  + "\n--------------");	
					 
		} catch (Exception e) {}	
	} 
	
	finally {
		if (bufferReader != null) {
			try { bufferReader.close(); } 
			catch (IOException e) { e.printStackTrace(); } }
		httpClient.getConnectionManager().shutdown(); }
		
	String[] connectToServerPayload = new String[3];
	connectToServerPayload[0] = accessToken;
	connectToServerPayload[1] = refreshToken;
	connectToServerPayload[2] = userID;
	
	return connectToServerPayload;
}
    
    
  
    public String RefreshAccessToken(String OldrefreshToken)
    {	
    	
        String accessToken = null;
        String refreshToken = null;
        String userID = null;
    	
        HttpPost httppost = null;
        String str = null;
        BufferedReader bufferReader = null;
        HttpResponse response = null;
        
    	DefaultHttpClient httpClient = new DefaultHttpClient();

    	bufferReader = null;
    	
        String refreshUrl = url_authorization
            + "?client_id=" + client_id
            + "&client_secret=" + client_secret
            + "&refresh_token=" + OldrefreshToken.replace("\"", "")
            + "&response_type=" + response_type_refresh_token
            + "&redirect_uri=" + redirect_uri;


    	try {	
    		httppost = new HttpPost(refreshUrl);
    		
    		try { response = httpClient.execute(httppost); } 			
    		catch (IOException e) { e.printStackTrace(); }
    		
    		try { bufferReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent())); } 
    		catch ( IOException e) { e.printStackTrace(); }
    		
    		try {
    			while ((str = bufferReader.readLine()) != null) {
    				
    				System.out.println("Response: " + str + "\n--------------");	
    				
    				break;}	
    			
    			// Su google GSON istraukiama AccessToken verte is JSON responso:
    			JsonObject jobj = new Gson().fromJson(str, JsonObject.class);
    			
    			accessToken = jobj.get("AccessToken").toString();
    			refreshToken = jobj.get("RefreshToken").toString();
    			userID = jobj.get("UserID").toString();
    			
    			System.out.println("AccessToken: " +  accessToken  + "\n--------------");	
    			System.out.println("RefreshToken: " +  refreshToken  + "\n--------------");	
    			System.out.println("UserID: " +  userID  + "\n--------------");	
    					 
    		} catch (Exception e) {}	
    	} 
    	
    	finally	{
    		if (bufferReader != null) {
    			try { bufferReader.close(); } 
    			catch (IOException e) { e.printStackTrace(); } }
    		httpClient.getConnectionManager().shutdown(); }
    	
    	return accessToken;
    	
    }
    
    
    
    private String downloadBPData(String accessToken, String userID) {
    	String responseBP = null;
		DownloadIhealthResources mDownloadIhealthResources = new DownloadIhealthResources();
		
		try { responseBP = mDownloadIhealthResources.syncData(url_bp_data, userID, accessToken, client_id, client_secret, redirect_uri, sc, sv_OpenApiBP, "en_UK");	} 
		catch (Exception e) { e.printStackTrace(); }
						
		return responseBP; }	
    
    
    private String downloadWeightData(String accessToken, String userID) {
    	String responseWeight = null;
		DownloadIhealthResources mDownloadIhealthResources = new DownloadIhealthResources();
		
		try { responseWeight = mDownloadIhealthResources.syncData(url_weight_data, userID, accessToken, client_id, client_secret, redirect_uri, sc, sv_OpenApiWeight, "User"); } 
		catch (Exception e) { e.printStackTrace(); }
						
		return responseWeight; }	


    private String downloadBGData(String accessToken, String userID) {
    	String responseBG = null;
		DownloadIhealthResources mDownloadIhealthResources = new DownloadIhealthResources();
		
		try { responseBG = mDownloadIhealthResources.syncData(url_bg_data, userID, accessToken, client_id, client_secret, redirect_uri, sc, sv_OpenApiBG, "en_UK"); } 
		catch (Exception e) { e.printStackTrace(); }
						
		return responseBG; }	
    
   
    private String downloadBOData(String accessToken, String userID) {
    	String responseBO = null;
		DownloadIhealthResources mDownloadIhealthResources = new DownloadIhealthResources();
		
		try { responseBO = mDownloadIhealthResources.syncData(url_bo_data, userID, accessToken, client_id, client_secret, redirect_uri, sc, sv_OpenApiSpO2, "en_UK"); } 
		catch (Exception e) { e.printStackTrace(); }
						
		return responseBO; }	
    
    
    private String downloadARData(String accessToken, String userID) {
    	String responseAR = null;
		DownloadIhealthResources mDownloadIhealthResources = new DownloadIhealthResources();
		
		try { responseAR = mDownloadIhealthResources.syncData(url_ar_data, userID, accessToken, client_id, client_secret, redirect_uri, sc, sv_OpenApiActivity, "en_UK"); } 
		catch (Exception e) { e.printStackTrace();}
						
		return responseAR; }	
     
    
    private String downloadSRData(String accessToken, String userID) {
    	String responseSR = null;
		DownloadIhealthResources mDownloadIhealthResources = new DownloadIhealthResources();
		
		try { responseSR = mDownloadIhealthResources.syncData(url_sr_data, userID, accessToken, client_id, client_secret, redirect_uri, sc, sv_OpenApiSleep, "en_UK"); }		
		catch (Exception e) { e.printStackTrace(); }
						
		return responseSR; }	
      
    
    private String downloadUserData(String accessToken, String userID) {
    	String responseUser = null;
		DownloadIhealthResources mDownloadIhealthResources = new DownloadIhealthResources();
		
		try { responseUser = mDownloadIhealthResources.syncData(url_user_data, userID, accessToken, client_id, client_secret, redirect_uri, sc, sv_OpenApiUserInfo, "en_UK"); } 
		catch (Exception e) {e.printStackTrace();}
						
		return responseUser; }	
     

    
    }
	
	
	

}
