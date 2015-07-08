package simpletest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.*;
import java.math.BigInteger;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


/** 
 * This is a very simple test to check the REST API connection.
 * It is intended to be deleted once the application has been
 * developed.
 * @author lydia
 * 
 * See http://www.javacodegeeks.com/2012/09/simple-rest-client-in-java.html
 *
 */

public class SimpleTestGetTags {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		// LER TODO: load from properties file
		String password = "temp";
		String username = "temp";

		try{
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet("https://" + username + ":" + md5(password) + "@www.moneytrackin.com/api/rest/getBalance");
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch(Exception e){
			System.out.println("Exception happened " + e);

		}
	}
	
    public static String md5(String input) {
        
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
