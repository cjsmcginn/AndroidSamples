package com.example.servicesample;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity implements ServiceConnection {
	private IRemoteInterface mRemoteInterface;
	private ResponseReceiver mResponseReceiver;
	private IBroadcastListener mActivityBroadcastListener = new IBroadcastListener(){

		@Override
		public void onBroadcast() {
			// TODO Auto-generated method stub
			Log.d("DebugLog","Main Activity OnBroadcast Called");
		}};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		IntentFilter filter = new IntentFilter(ResponseReceiver.ACTION_REP);
		mResponseReceiver = new ResponseReceiver();
		mResponseReceiver.setBroadcastListener(mActivityBroadcastListener);
		registerReceiver(mResponseReceiver,filter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void startContentService(View view){
		//Context context = this.getApplicationContext();
		//Intent service = new Intent(context,ContentService.class);
		//this.startService(service);
		Boolean bound = this.bindService(new Intent(IRemoteInterface.class.getName()),this,Context.BIND_AUTO_CREATE);
		Log.i("DebugLog","Service Bound = " + String.valueOf(bound));
	}

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		// TODO Auto-generated method stub
		mRemoteInterface = IRemoteInterface.Stub.asInterface(service);
		Log.i("DebugLog","Interface Bound");
		try {
			ApiChannel target = mRemoteInterface.getApiChannel();
			Log.i("DebugLog", target.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("DebugLog",e.getMessage());
		}
		Intent ciIntent = new Intent(this, ContentIntentService.class);
		startService(ciIntent);
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		// TODO Auto-generated method stub
		mRemoteInterface = null;
		Log.i("DebugLog","Interface no longer bound");
	}
}
