package com.example.applicationundertest.test;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.applicationundertest.Contact;
import com.example.applicationundertest.JSONParser;
import com.example.applicationundertest.MainActivity;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mActivity;
	private TextView mWelcomeText;
	private ListView mListView;

	@SuppressWarnings("deprecation")
	public MainActivityTest() {
		super("com.example.applicationundertest", MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);

		mActivity = getActivity();
		mWelcomeText = (TextView) mActivity
				.findViewById(com.example.applicationundertest.R.id.welcome_text);
		mListView = mActivity.getListView();

	}

	public void testPreConditions() {

		assertTrue(mWelcomeText.getText().equals("Hello world!"));
		assertTrue(mListView.getOnItemClickListener() != null);
	}

	// Runs on UI thread can be used to select something
	@SuppressLint("NewApi")
	public void testWelcomeText() {

		mActivity.runOnUiThread(new Runnable() {

			@SuppressLint("NewApi")
			public void run() {
				
				mListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
				mListView.setItemChecked(2, true);		
				assertTrue(mListView.getCheckedItemCount() > 0);
			}
		});

	}
	@SuppressLint("NewApi")
	@UiThreadTest
	public void testStatePause(){
		mListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
		mListView.setItemChecked(2, true);		
		assertTrue(mListView.getCheckedItemCount() > 0);
		Instrumentation mInstr = this.getInstrumentation();
		mInstr.callActivityOnPause(mActivity);
		//clear all checked
		mListView.clearChoices();
		assertTrue(mListView.getCheckedItemCount() == 0);
		mInstr.callActivityOnResume(mActivity);
		assertTrue(mListView.getCheckedItemCount() > 0);
	}
	
	public void testGetJsonData(){
		JSONParser p = new JSONParser();
		List<Contact> actual = p.getContacts();
		assertTrue(actual.size()>0);
	
	}
}
