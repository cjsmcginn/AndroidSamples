package com.example.servicesample;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;

public class ContentIntentService extends IntentService {

	public ContentIntentService() {
		super("ContentIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		SystemClock.sleep(10000);
		Intent broadcastIntent = new Intent();
		broadcastIntent.setAction(ResponseReceiver.ACTION_REP);
		sendBroadcast(broadcastIntent);
	}

}
