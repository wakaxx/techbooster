package org.japan.techbooster.sample.ObjectIntentSample;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class TestResults implements Serializable {
//public class TestResults implements Parcelable {	
	int english = 0;
	int mathematics = 0;
	int scientics = 0;
	int society = 0;
	 
	enum subject{
		ENGLISH,
		MATHEMATICS,
		SCIENTICS,
		SOCIETY;
	}
	
	public TestResults(int eng, int math, int science, int social) {
		english = eng;
		mathematics = math;
		scientics = science;
		society = social;		
	}
	
	public int getPoint(subject sub){	
		switch(sub){
			case ENGLISH: return english;
			case MATHEMATICS: return mathematics;
			case SCIENTICS: return scientics;
			case SOCIETY: return society;
			default : return -1;
		}		
	}
}
