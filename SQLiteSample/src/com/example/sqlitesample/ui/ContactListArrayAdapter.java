package com.example.sqlitesample.ui;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sqlitesample.R;
import com.example.sqlitesample.domain.Contact;

public class ContactListArrayAdapter extends ArrayAdapter<Contact> {
	private final List<Contact> contacts;
	private final Context context;
	private final int resource;
	
	public ContactListArrayAdapter(Context context, int resource,List<Contact> contacts){
		super(context, resource, contacts);
		this.context = context;
		this.contacts = contacts;
		this.resource = resource;
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		LayoutInflater inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View result = inflater.inflate(R.layout.contact_list, parent, false);
		TextView nameText= (TextView) result.findViewById(R.id.contactName);
		Contact c = contacts.get(position);
		nameText.setText(c.getFirstName() + " " + c.getLastName() + ", " + c.getMiddleInitial());
		return result;
	}

}
