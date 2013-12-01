package com.example.sqlitesample;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.example.sqlitesample.domain.Contact;
import com.example.sqlitesample.domain.Domain;
import com.example.sqlitesample.ui.ContactListArrayAdapter;
@SuppressLint("NewApi")
public class MainActivity extends Activity {

	private ContactListArrayAdapter contactsAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		CreateDatabaseTask task = new CreateDatabaseTask();
		task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,this);
		Domain d = new Domain(this.getApplicationContext());
		List<Contact> contactList = d.getContacts();
		
		Contact[] contacts = contactList.toArray(new Contact[contactList.size()]);		
		contactsAdapter  = new ContactListArrayAdapter(this,R.layout.contact_list,contactList);
		ListView lv = (ListView)findViewById(R.id.contactListView);
		lv.setAdapter(contactsAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void openEditContact(View view){
		Contact c = new Contact();
		Intent intent = new Intent(this,EditContactActivity.class);
		startActivity(intent);
		//contactsAdapter.add(c);
		//Intent intent = new Intent(this,EditContactActivity.class);
		//startActivity(intent);
	}

}
