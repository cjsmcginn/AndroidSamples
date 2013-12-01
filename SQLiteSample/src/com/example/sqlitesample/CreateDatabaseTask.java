package com.example.sqlitesample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

public class CreateDatabaseTask extends AsyncTask<Context, Boolean, Boolean> {

	@Override
	protected Boolean doInBackground(Context... params) {
		Boolean result = false;
		 ContactsDatabaseHelper helper = new ContactsDatabaseHelper(params[0]);
		 SQLiteDatabase db = helper.getWritableDatabase();
		 result = db.isOpen();
		 return result;	
	}

}
