package com.example.applicationundertest.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.applicationundertest.MainActivity;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	
	private MainActivity mActivity;
	private TextView mWelcomeText;
	@SuppressWarnings("deprecation")
	public MainActivityTest() {
		super("com.example.applicationundertest", MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);
		
		mActivity = getActivity();
		mWelcomeText = (TextView)mActivity.findViewById(com.example.applicationundertest.R.id.welcome_text);

	}
	
	public void testPreConditions(){
		
		assertTrue(mWelcomeText.getText().equals("Hello world!"));
		
	}
}
