package com.example.sqlitesample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sqlitesample.ContactsDatabase.Addresses;
import com.example.sqlitesample.ContactsDatabase.Persons;
import com.example.sqlitesample.ContactsDatabase.PhoneNumbers;

public class ContactsDatabaseHelper extends SQLiteOpenHelper{


	
	public ContactsDatabaseHelper(Context context){
		super(context,ContactsDatabase.DATABASE_NAME,null,ContactsDatabase.DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		String personsCreate = "CREATE TABLE " + Persons.PERSONS_TABLE+"("
				+ Persons._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ Persons.PERSONS_CREATEDONUTC + " TEXT NOT NULL,"
				+ Persons.PERSONS_DOB + " TEXT,"
				+ Persons.PERSONS_FIRSTNAME + " TEXT NOT NULL,"
				+ Persons.PERSONS_LASTNAME + " TEXT NOT NULL,"
				+ Persons.PERSONS_MIDDLEINITIAL + " TEXT NOT NULL"				
				+");";
		String addressesCreate = "CREATE TABLE " + Addresses.ADDRESSES_TABLE+"("
				+ Addresses._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ Addresses.ADDRESSES_CITY + " TEXT NOT NULL,"
				+ Addresses.ADDRESSES_COUNTRY + " TEXT NOT NULL,"
				+ Addresses.ADDRESSES_CREATEDONUTC + " TEXT NOT NULL,"
				+ Addresses.ADDRESSES_LINE1 + " TEXT NOT NULL,"
				+ Addresses.ADDRESSES_LINE2 + " TEXT,"
				+ Addresses.ADDRESSES_POSTALCODE + " TEXT NOT NULL,"
				+ Addresses.ADDRESSES_STATEPROVINCE + " TEXT NOT NULL,"
				+ Addresses.ADDRESSES_TYPE_ID + " INTEGER NOT NULL,"
				+ Addresses.ADDRESSES_PERSON_ID + " INTEGER NOT NULL"
				+ ");";
		String phoneNumbersCreate = "CREATE TABLE " + PhoneNumbers.PHONENUMBERS_TABLE + "("
				+ PhoneNumbers._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ PhoneNumbers.PHONENUMBERS_AREACODE + " INTEGER NOT NULL,"
				+ PhoneNumbers.PHONENUMBERS_COUNTRYCODE + " INTEGER NOT NULL,"
				+ PhoneNumbers.PHONENUMBERS_CREATEDONUTC + " TEXT NOT NULL,"
				+ PhoneNumbers.PHONENUMBERS_EXTENSION + " INTEGER,"
				+ PhoneNumbers.PHONENUMBERS_PERSON_ID + " INTEGER NOT NULL,"
				+ PhoneNumbers.PHONENUMBERS_PREFIX + " INTEGER NOT NULL,"
				+ PhoneNumbers.PHONENUMBERS_SUFFIX + " INTEGER NOT NULL"
				+ ");";
		Log.i("DebugLog",personsCreate);
		Log.i("DebugLog",addressesCreate);
		Log.i("DebugLog",phoneNumbersCreate);
		
		db.execSQL(personsCreate);
		db.execSQL(addressesCreate);
		db.execSQL(phoneNumbersCreate);
		
	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
}
