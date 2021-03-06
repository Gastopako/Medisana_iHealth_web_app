package com.medisanaspace.web.library;


public final class VitaDockServer {
	private VitaDockServer() {
	}

	/*
	 * Please note that you also have to change the application token in
	 * CloudClient.java if you switch the server.
	 * 
	 * - vitacloud.medisanaspace.com is the test server to which you can
	 * register yourself as developer during registration. Please note that this
	 * is an own server with no connection to cloud.vitadock.com.
	 * 
	 * - cloud.vitadock.com is the production server. After registration please
	 * contact us at cloud@vitadock.com to get upgraded to a developer account.
	 */

//	public static final String EXTERNAL_AUTH_URL = "vitacloud.medisanaspace.com/auth";// "vitacloud.medisanaspace.com/auth";//"cloud.vitadock.com/auth";
//	public static final String EXTERNAL_LOGIN_URL = "vitacloud.medisanaspace.com";// "vitacloud.medisanaspace.com";//"cloud.vitadock.com";
//	public static final String EXTERNAL_DATA_URL = "vitacloud.medisanaspace.com/data";// "vitacloud.medisanaspace.com/data";//"cloud.vitadock.com/data";

	public static final String EXTERNAL_AUTH_URL = "cloud.vitadock.com/auth";// "vitacloud.medisanaspace.com/auth";//"cloud.vitadock.com/auth";
	public static final String EXTERNAL_LOGIN_URL = "cloud.vitadock.com";// "vitacloud.medisanaspace.com";//"cloud.vitadock.com";
	public static final String EXTERNAL_DATA_URL = "cloud.vitadock.com/data";// "vitacloud.medisanaspace.com/data";//"cloud.vitadock.com/data";

	
	public static final String HTTPS_AUTH_URL = "https://" + EXTERNAL_AUTH_URL;
	public static final String HTTPS_LOGIN_URL = "https://" + EXTERNAL_LOGIN_URL;
	public static final String HTTPS_DATA_URL = "https://" + EXTERNAL_DATA_URL;
}
