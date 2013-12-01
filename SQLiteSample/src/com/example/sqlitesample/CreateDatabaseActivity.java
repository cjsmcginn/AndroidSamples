package com.example.sqlitesample;

import java.util.Locale;

import com.example.sqlitesample.ContactsDatabase;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
public class CreateDatabaseActivity extends Activity {

	private static final String CREATE_CONTACT_TABLE = "CREATE TABLE tbl_contacts ("
			+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "firstName TEXT,"
			+ "lastName TEXT,"
			+ "createdOnUtc DATE)";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_database);
		createDatabase();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_database, menu);
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public SQLiteDatabase createDatabase(){

		 ContactsDatabaseHelper helper = new ContactsDatabaseHelper(this.getApplicationContext());
		 SQLiteDatabase result = helper.getWritableDatabase();
		 return result;

	}

	

}
