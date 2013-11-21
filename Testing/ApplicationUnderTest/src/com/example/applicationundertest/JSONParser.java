package com.example.applicationundertest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
 
public class JSONParser {
 
	// url to make request
	private static String url = "http://api.androidhive.info/contacts/";
	 
	// JSON Node names
	private static final String TAG_CONTACTS = "contacts";
	private static final String TAG_ID = "id";
	private static final String TAG_NAME = "name";
	private static final String TAG_EMAIL = "email";
	private static final String TAG_ADDRESS = "address";
	private static final String TAG_GENDER = "gender";
	private static final String TAG_PHONE = "phone";
	private static final String TAG_PHONE_MOBILE = "mobile";
	private static final String TAG_PHONE_HOME = "home";
	private static final String TAG_PHONE_OFFICE = "office";
	 
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
 
    // constructor
    public JSONParser() {
 
    }
 
    public JSONObject getJSONFromUrl() {
 
        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
 
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();           
 
        } catch (UnsupportedEncodingException e) {
        	Log.e("JSON Parser",e.getLocalizedMessage());
        } catch (ClientProtocolException e) {
        	Log.e("JSON Parser",e.getLocalizedMessage());
        } catch (IOException e) {
        	Log.e("JSON Parser",e.getLocalizedMessage());
        }
         
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
 
        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
 
        // return JSON String
        return jObj;
 
    }
    public List<Contact> getContacts(){
    	JSONObject response = getJSONFromUrl();
    	List<Contact> result = new ArrayList<Contact>();
    	
    	try {
    		JSONArray contacts = null;
    	    // Getting Array of Contacts
    	    contacts = response.getJSONArray(TAG_CONTACTS);
    	     
    	    // looping through All Contacts
    	    for(int i = 0; i < contacts.length(); i++){
    	        JSONObject c = contacts.getJSONObject(i);
    	         Contact ct = new Contact();
    	         
    	        // Storing each json item in variable
    	     ct.setId(c.getString(TAG_ID));
    	     ct.setEmail(c.getString(TAG_EMAIL));
    	     ct.setName(c.getString(TAG_NAME));
    	     JSONObject phone = c.getJSONObject(TAG_PHONE);
    	     ct.setPhone(phone.getString(TAG_PHONE_HOME));
    	        result.add(ct);
    	         
    	    }
    	    
    	   
    	} catch (JSONException e) {
    	    Log.e("JSON Parser",e.getMessage());
    	}
    	return result;
    }
}
