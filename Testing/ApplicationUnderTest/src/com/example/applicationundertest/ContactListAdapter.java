package com.example.applicationundertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ContactListAdapter extends ArrayAdapter<Contact> {
private final Context context;
private final Contact[] contacts;
	public ContactListAdapter(Context context, int resource, Contact[] contacts) {
		super(context, resource, contacts);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.contacts = contacts;
	}

	@Override
	public View getView(int position,View convertView,ViewGroup parent)
	{
		LayoutInflater inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		  View rowView = inflater.inflate(R.layout.list_item, parent, false);
		  TextView nameText= (TextView) rowView.findViewById(R.id.textView1);
		  TextView emailText= (TextView) rowView.findViewById(R.id.textView2);
		  TextView phoneText= (TextView) rowView.findViewById(R.id.textView3);
		  Contact c = contacts[position];
		  nameText.setText(c.getName());
		  emailText.setText(c.getEmail());
		  phoneText.setText(c.getPhone());
		  return rowView;
	}
}
