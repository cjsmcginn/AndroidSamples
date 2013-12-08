package com.example.servicesample;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public class ApiChannel implements Parcelable{

	
	public static final Parcelable.Creator<ApiChannel> CREATOR = new Parcelable.Creator<ApiChannel>() {

		@Override
		public ApiChannel createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new ApiChannel(source);
		}

		@Override
		public ApiChannel[] newArray(int size) {
			// TODO Auto-generated method stub
			return new ApiChannel[size];
		}
	};
	private static final String TAG_ID="id";
	private static final String TAG_NAME="name";
	private static final String TAG_IMAGE_URL="imageUrl";
	private String imageUrl;
	private int id;
	private String name;
	private Bitmap bitmap;
	
	public ApiChannel(){}
	private ApiChannel(Parcel source){
		readFromParcel(source);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static ApiChannel fromJSON(JSONObject channelJson) throws JSONException{
		ApiChannel result = new ApiChannel();		
		result.setId(channelJson.getInt(TAG_ID));
		result.setName(channelJson.getString(TAG_NAME));
		result.setImageUrl(channelJson.getString(TAG_IMAGE_URL));
		return result;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(id);
		dest.writeString(name);
		dest.writeString(imageUrl);
		
	}
	
	public void readFromParcel(Parcel src){
		id = src.readInt();
		name=src.readString();
		imageUrl = src.readString();
	}

}
