package com.example.sqlitesample.test;



import com.example.sqlitesample.CreateDatabaseActivity;

import android.database.sqlite.SQLiteDatabase;
import android.test.ActivityInstrumentationTestCase2;
import android.test.AndroidTestCase;
import junit.framework.TestCase;

public class CreateDatabaseActivityTests extends ActivityInstrumentationTestCase2<CreateDatabaseActivity> {

	public CreateDatabaseActivityTests(){
		super("com.example.sqlitesample",CreateDatabaseActivity.class);
	}
	private CreateDatabaseActivity mTarget;
	protected void setUp() throws Exception {
		super.setUp();
		mTarget = getActivity();
		assertNotNull(mTarget);
	}

	public final void testCreateDatabase() {
		SQLiteDatabase actual = mTarget.createDatabase();
		assertNotNull(actual);
	}

}
