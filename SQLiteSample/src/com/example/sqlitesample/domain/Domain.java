package com.example.sqlitesample.domain;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlitesample.ContactsDatabase;
import com.example.sqlitesample.ContactsDatabaseHelper;
public class Domain {
		private final Context context;
		private SQLiteDatabase mDatabase;
		public Domain(Context c){
		
			ContactsDatabaseHelper helper = new ContactsDatabaseHelper(c);
			mDatabase = helper.getWritableDatabase();
			this.context = c;
		}
		@SuppressLint("SimpleDateFormat")
		protected String getCurrentUTC(){
			SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
			dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
			return  dateFormatGmt.format(new Date());
		}
		public List<Contact> getContacts(){
			List<Contact> result = new ArrayList<Contact>();
			Cursor c = mDatabase.query(ContactsDatabase.Persons.PERSONS_TABLE, null,null,null,null,null,null);
			c.moveToFirst();
			while(c.isAfterLast()==false){
				Contact contact = new Contact(c.getLong(0), c.getString(3),c.getString(4),c.getString(5));
				result.add(contact);
				c.moveToNext();
			}
			
			c.close();
			
			return result;
		}
		public Long addContact(Contact contact){
			Long result = null;
			ContentValues values = new ContentValues();
			values.put(ContactsDatabase.Persons.PERSONS_FIRSTNAME, contact.getFirstName());
			values.put(ContactsDatabase.Persons.PERSONS_LASTNAME, contact.getLastName());
			values.put(ContactsDatabase.Persons.PERSONS_MIDDLEINITIAL, contact.getMiddleInitial());
			values.put(ContactsDatabase.Persons.PERSONS_CREATEDONUTC, getCurrentUTC());
			result = mDatabase.insert(ContactsDatabase.Persons.PERSONS_TABLE, null, values);
			return result;
			
		}
}

