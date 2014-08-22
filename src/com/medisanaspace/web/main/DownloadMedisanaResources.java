package com.medisanaspace.web.main;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;


import com.medisanaspace.web.library.AuthorizationBuilder;
import com.medisanaspace.web.library.HeaderPrinter;

/*Worker task that uploads, retrieves and deletes data on the server.*/

public class DownloadMedisanaResources {

	public static final int DELETE_TIME_ID = 0;
	public static final int SYNC_TIME_ID = 1;
	public static final int SAVE_TIME_ID = 2;

	private static final String ENCODING = "UTF-8";

	private static final String AUTHORIZATION_STRING = "Authorization";

	public DownloadMedisanaResources() {}


	
	public static int countData(final String token, final String secret,
			final int moduleId, final String accessToken,
			final String accessSecret) throws Exception {
		String dateSince = "0";
		String authorization = AuthorizationBuilder
				.createCountDataRequestAuthorizationHeader(dateSince,
						AuthorizationBuilder.createCountUrl(moduleId), token,
						secret, accessToken, accessSecret);
		HttpGet httpget = new HttpGet(
				AuthorizationBuilder.createCountUrl(moduleId));
		httpget.setHeader(AUTHORIZATION_STRING, authorization);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HeaderPrinter.printPost(httpget);

		HttpResponse response = httpClient.execute(httpget);
		return Integer.parseInt(IOUtils.toString(response.getEntity()
				.getContent(), ENCODING));
	}


	public static String saveRandomArrayJSONData(final String token,
			final String secret, final String jsonString, final int moduleId,
			final String accessToken, final String accessSecret)
			throws Exception {

		String authorization = AuthorizationBuilder
				.createSaveDataRequestAuthorizationHeader(
						AuthorizationBuilder.createRequestArrayUrl(moduleId),
						jsonString, token, secret, accessToken, accessSecret);
		HttpPost httppost = new HttpPost(
				AuthorizationBuilder.createRequestArrayUrl(moduleId));
		httppost.setHeader(AUTHORIZATION_STRING, authorization);
		httppost.setHeader("Content-Type", "application/json;charset=utf-8");
		DefaultHttpClient httpClient = new DefaultHttpClient();
		httppost.setEntity(new StringEntity(jsonString, ENCODING));

		HeaderPrinter.printPost(httppost);

		HttpResponse response = httpClient.execute(httppost);
		String responseString = IOUtils.toString(response.getEntity()
				.getContent(), ENCODING);

		System.out.println("Response: " + responseString + "\n--------------");
		
		return responseString;

	}

	
	public String syncData(final String token, final String secret,
			final int moduleId, final String accessToken,
			final String accessSecret) throws Exception {
		int start = -1;
		int max = 100;
		String dateSince = "0";
		DefaultHttpClient httpClient = new DefaultHttpClient();

		String authorization = AuthorizationBuilder
				.createLoadDataRequestAuthorizationHeader(
						AuthorizationBuilder.createSyncUrl(moduleId), start,
						max, dateSince, token, secret, accessToken,
						accessSecret);
		String requestUrl = AuthorizationBuilder.createSyncUrl(moduleId, start,
				max, dateSince);
		HttpGet httpget = new HttpGet(requestUrl);
		httpget.setHeader(AUTHORIZATION_STRING, authorization);
		HeaderPrinter.printPost(httpget);

		HttpResponse response = httpClient.execute(httpget);
		InputStream testStream = response.getEntity().getContent();
		byte[] bytes = IOUtils.toByteArray(testStream);
				
		String responseString = new String(bytes, ENCODING);

		return responseString;
	}


	public static int deleteAllData(final String token, final String secret,
			final int moduleId, final String accessToken,
			final String accessSecret) throws Exception {

		String authorization = AuthorizationBuilder
				.createSaveDataRequestAuthorizationHeader(
						AuthorizationBuilder.createDeleteAllArrayUrl(moduleId),
						null, token, secret, accessToken, accessSecret);
		HttpPost httppost = new HttpPost(
				AuthorizationBuilder.createDeleteAllArrayUrl(moduleId));
		httppost.setHeader(AUTHORIZATION_STRING, authorization);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HeaderPrinter.printPost(httppost);

		HttpResponse response = httpClient.execute(httppost);
		String responseString = IOUtils.toString(response.getEntity()
				.getContent(), ENCODING);
		int number = 0;
		try {
			number = Integer.parseInt(responseString);
		} catch (NumberFormatException e) {
			throw new Exception(response.getStatusLine().getReasonPhrase());
		}
		return number;
	}
	
}


