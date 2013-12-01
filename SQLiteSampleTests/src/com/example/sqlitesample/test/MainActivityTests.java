package com.example.sqlitesample.test;

import com.example.sqlitesample.MainActivity;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

public class MainActivityTests extends AndroidTestCase {

	private MainActivity mTarget;
	protected void setUp() throws Exception {
		super.setUp();
		mTarget = new MainActivity();
	}

	public final void testCreateDatabase() {
//		SQLiteDatabase actual = mTarget.createDatabase();
//		assertNotNull(actual);
	}
	public final void testOnCreateBundle() {
		//fail("Not yet implemented");
	}

}
