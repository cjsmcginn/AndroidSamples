package com.example.sqlitesample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.sqlitesample.domain.Contact;
import com.example.sqlitesample.domain.Domain;

public class EditContactActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_contact);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_contact, menu);
		return true;
	}

	public void saveContact(View view)
	{
		Domain d = new Domain(this.getApplicationContext());
		EditText fNameView = (EditText)findViewById(R.id.editFirstName);
		EditText lNameView = (EditText)findViewById(R.id.editLastName);
		EditText mInitialView = (EditText)findViewById(R.id.editMiddleInitial);
		Contact newContact = new Contact();
		newContact.setFirstName(fNameView.getText().toString());
		newContact.setLastName(lNameView.getText().toString());
		newContact.setMiddleInitial(mInitialView.getText().toString());
		Long id = d.addContact(newContact);
		Log.i("DebugLog",String.valueOf(id));
	}
}
