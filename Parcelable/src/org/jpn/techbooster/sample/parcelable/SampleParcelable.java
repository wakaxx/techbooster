package org.jpn.techbooster.sample.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SampleParcelable implements Parcelable {  
    public int mData;  
    public String mString;
    
    @Override
	public int describeContents() {  
	    return 0;  
	}  
    
    @Override
    public void writeToParcel(Parcel out, int flags) {  
        out.writeInt(mData);  
        out.writeString(mString);
    }  

    public static final Parcelable.Creator<SampleParcelable> CREATOR  
    	= new Parcelable.Creator<SampleParcelable>() {  
    	public SampleParcelable createFromParcel(Parcel in) {  
    		return new SampleParcelable(in);  
    	}  

    	public SampleParcelable[] newArray(int size) {  
    		return new SampleParcelable[size];  
    	}  
    };  

    private SampleParcelable(Parcel in) {
    	// writeToParcelで保存した順番で読み出す必要がある
        mData = in.readInt();  
        mString = in.readString();
    }
    
    SampleParcelable(int data, String string) {
    	mData = data;
    	mString = string;
    }
}
