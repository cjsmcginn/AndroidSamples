package com.example.servicesample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ResponseReceiver extends BroadcastReceiver {
public static final String ACTION_REP = "com.example.servicesample.intent.action.MESSAGE_PROCESSED";
private IBroadcastListener broadcastListener;
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.d("DebugLog","Broadcast Received");
		if(broadcastListener != null)
			broadcastListener.onBroadcast();
	}
	/**
	 * @return the broadcastListener
	 */
	public IBroadcastListener getBroadcastListener() {
		return broadcastListener;
	}
	/**
	 * @param broadcastListener the broadcastListener to set
	 */
	public void setBroadcastListener(IBroadcastListener broadcastListener) {
		this.broadcastListener = broadcastListener;
	}

}
