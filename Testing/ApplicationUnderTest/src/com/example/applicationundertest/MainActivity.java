package com.example.applicationundertest;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
		String[] mStringArray = {"Joe","Tom","Dick","Harry","Tony"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
		        android.R.layout.simple_list_item_1, mStringArray);
		ListView listView = getListView();//(ListView) findViewById(R.id.example_list_view);
		listView.setAdapter(adapter);
        return true;
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
    	
    }
    
}
