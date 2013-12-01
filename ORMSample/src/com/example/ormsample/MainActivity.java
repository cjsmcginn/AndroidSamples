package com.example.ormsample;

import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;

import com.example.ormsample.domain.DaoMaster;
import com.example.ormsample.domain.DaoSession;
import com.example.ormsample.domain.Person;
import com.example.ormsample.domain.PersonDao;
import com.example.ormsample.domain.PhoneNumber;
import com.example.ormsample.domain.PhoneNumberDao;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DaoMaster.OpenHelper oh = new DaoMaster.OpenHelper(this, "Contacts", null) {
			
			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
				// TODO Auto-generated method stub
				
			}
		};
		SQLiteDatabase db = oh.getReadableDatabase();
		DaoMaster daoMaster = new DaoMaster(db);
		
		DaoSession daoSession = daoMaster.newSession();
		PersonDao person = daoSession.getPersonDao();
		PhoneNumberDao phoneNumberDao = daoSession.getPhoneNumberDao();
		Person p = new Person();
		p.setFname("Tommy");
		p.setLname("Jones");
		person.insert(p);
		
		
		List<PhoneNumber> phoneNumbers = p.getPhoneNumbers();
		
		
		PhoneNumber newPhone = new PhoneNumber();
		newPhone.setCountryCode(1);
		newPhone.setAreaCode(407);
		newPhone.setPrefix(123);
		newPhone.setSuffix(2323);
		newPhone.setPersonId(p.getId());
		phoneNumberDao.insert(newPhone);
		
		phoneNumbers.add(newPhone);
		p.setCreatedOn(new Date());
		person.update(p);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
