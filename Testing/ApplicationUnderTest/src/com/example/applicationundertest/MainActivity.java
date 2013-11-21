package com.example.applicationundertest;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	public static final String PREFERENCES_FILE = "MainPrefs";
	
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
    @Override
    public void onPause(){
    	super.onPause();
        if (!writeInstanceState(this)) {
            Toast.makeText(this,
                    "Failed to write state!", Toast.LENGTH_LONG).show();
         }
    }
    @Override
    public void onResume(){
    	super.onResume();
    	readInstanceState(this);
    }
    @SuppressWarnings("unused")
	public boolean readInstanceState(Context c){
    	boolean result = false;
        /*
         * The preferences are stored in a SharedPreferences file. The abstract implementation of
         * SharedPreferences is a "file" containing a hashmap. All instances of an application
         * share the same instance of this file, which means that all instances of an application
         * share the same preference settings.
         */

        /*
         * Get the SharedPreferences object for this application
         */

        SharedPreferences p = c.getSharedPreferences(PREFERENCES_FILE, MODE_WORLD_READABLE);
        int itemPos = p.getInt("MyItemPosition", -1);
        ListView listView = getListView();
        listView.setItemChecked(itemPos, true);
        result =  (p.contains("MyItemPosition"));
    	return result;
    	
    }
    @SuppressWarnings("unused")
	public boolean writeInstanceState(Context c){
    	boolean result =false;
        /*
         * Get the SharedPreferences object for this application
         */

        @SuppressWarnings("deprecation")
		SharedPreferences p =
                c.getSharedPreferences(MainActivity.PREFERENCES_FILE, MODE_WORLD_READABLE);
        
        /*
         * Get the editor for this object. The editor interface abstracts the implementation of
         * updating the SharedPreferences object.
         */

        SharedPreferences.Editor e = p.edit();
        /*
         * Write the keys and values to the Editor
         */
        ListView listView = getListView();
        int itemPos = listView.getCheckedItemPosition();
        e.putInt("MyItemPosition", itemPos);
        result = e.commit();
    	return result;
    }
}
