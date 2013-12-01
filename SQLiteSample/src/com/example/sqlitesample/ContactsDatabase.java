package com.example.sqlitesample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class ContactsDatabase {
public static final String DATABASE_NAME="Contacts";
public static final int DATABASE_VERSION=1;
private ContactsDatabase(){}

public static final class Persons implements BaseColumns{
	public static final String PERSONS_TABLE="tbl_persons";
	public static final String PERSONS_FIRSTNAME="firstName";
	public static final String PERSONS_LASTNAME="lastName";
	public static final String PERSONS_MIDDLEINITIAL="middleInitial";
	public static final String PERSONS_DOB="dob";
	public static final String PERSONS_CREATEDONUTC="createdOnUtc";
}
public static final class Addresses implements BaseColumns{
	public static final String ADDRESSES_TABLE="tbl_addresses";
	public static final String ADDRESSES_LINE1="line1";
	public static final String ADDRESSES_LINE2="line2";
	public static final String ADDRESSES_CITY="city";
	public static final String ADDRESSES_STATEPROVINCE="stateProvince";
	public static final String ADDRESSES_COUNTRY="country";
	public static final String ADDRESSES_POSTALCODE="postalCode";
	public static final String ADDRESSES_TYPE_ID="typeId";
	public static final String ADDRESSES_CREATEDONUTC="createdOnUtc";
	public static final String ADDRESSES_PERSON_ID="personId";
	
}
public static final class PhoneNumbers implements BaseColumns{
	public static final String PHONENUMBERS_TABLE = "tbl_phonenumbers";
	public static final String PHONENUMBERS_TYPE_ID="typeId";
	public static final String PHONENUMBERS_AREACODE="areaCode";
	public static final String PHONENUMBERS_COUNTRYCODE="countryCode";
	public static final String PHONENUMBERS_PREFIX="prefix";
	public static final String PHONENUMBERS_SUFFIX="suffix";
	public static final String PHONENUMBERS_EXTENSION="extension";
	public static final String PHONENUMBERS_CREATEDONUTC="createdOnUtc";
	public static final String PHONENUMBERS_PERSON_ID="personId";
	
}
public static final class EmailAddresses implements BaseColumns{
	public static final String EMAILADDRESSES_TABLE = "tbl_emailaddresses";
	public static final String EMAILADDRESSES_CREATEDONUTC="createdOnUtc";
	public static final String EMAILADDRESSES_TYPE_ID="typeId";
	public static final String EMAILADDRESSES_EMAIL="email";
	public static final String EMAILADDRESSES_PERSON_ID="personId";
}



}
