package restapi.interactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.security.*;
import java.math.BigInteger;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


/** 
 * This is intended to take care of the REST API connection to Money Tracker.
 * 
 * @author lydia
 *
 */


public abstract class MoneyTrackerInteractor {
	// TODO: load from .properties file
	private static String password;
	private static String user;
	private static String uri = "@www.moneytrackin.com/api/rest/";
	
	public static List<String> getRest (String httpRequest){ // throws ClientProtocolException, IOException {
		List<String> list = new ArrayList<String>();
		
		try{
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet("https://" + user + ":" + md5(password) + uri + httpRequest);
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				list.add(line);
//				System.out.println(line);
			}
		}
		catch(Exception e){
			System.out.println("Exception happened " + e);
		}
		return list;
	}

	private static String md5(String input) {

		String md5 = null;

		if(null == input) return null;

		try {

			//Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");

			//Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());

			//Converts message digest value in base 16 (hex) 
			md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5;
	}
}