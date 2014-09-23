package com.pm.pojo;

import java.util.Date;

public class Message {
	String MID;
	String MRelatedUserID;
	int MType;
	String MContent;
	Date MTimeCreated;
	public String getMID() {
		return MID;
	}
	public void setMID(String mID) {
		MID = mID;
	}
	public String getMRelatedUserID() {
		return MRelatedUserID;
	}
	public void setMRelatedUserID(String mRelatedUserID) {
		MRelatedUserID = mRelatedUserID;
	}
	public int getMType() {
		return MType;
	}
	public void setMType(int mType) {
		MType = mType;
	}
	public String getMContent() {
		return MContent;
	}
	public void setMContent(String mContent) {
		MContent = mContent;
	}
	public Date getMTimeCreated() {
		return MTimeCreated;
	}
	public void setMTimeCreated(Date mTimeCreated) {
		MTimeCreated = mTimeCreated;
	}

	
	
}
