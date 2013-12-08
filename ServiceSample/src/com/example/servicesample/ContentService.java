package com.example.servicesample;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class ContentService extends Service {
	
	private final IRemoteInterface.Stub mRemoteInterfaceBinder = new IRemoteInterface.Stub(){

		@Override
		public ApiChannel getApiChannel() throws RemoteException {
			// TODO Auto-generated method stub
			ApiChannel result =  new ApiChannel();
			result.setId(1);
			result.setImageUrl("http://donotresolve.com");
			result.setName("Some Name");
			return result;
			
		}
		
	};
	public ContentService() {
	}

	@Override
	public void onCreate() {
		Log.i("DebugLog", "Service Created");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("DebugLog", "Service Starting");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		Log.i("DebugLog", "Service Binding");
		return mRemoteInterfaceBinder;
	}

	
}
