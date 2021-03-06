package com.pm.pojo;

import java.util.Date;

public class Post {
	private String PostID;
	private String PPhone;
	private Date PSubmitTime;
	private int PIsVadilated;
	private String PRootID; 
	private String PSubject;
	private String PBodyText;
	private int PState;
	private String PReplyPostID;
	private Date PUpdateTime;
	
	public void setPostID(String PostID){
		this.PostID=PostID;
	}
	public String getPostID(){
		return PostID;
	}
	
	
	public String getPRootID() {
		return PRootID;
	}
	public void setPRootID(String pRootID) {
		PRootID = pRootID;
	}
	public String getPPhone() {
		return PPhone;
	}
	public void setPPhone(String pPhone) {
		PPhone = pPhone;
	}
	public void setPSubmitTime(Date PSubmitTime){
		this.PSubmitTime=PSubmitTime;
	}
	public Date getPSubmitTime(){
		return PSubmitTime;
	}
	public void setPIsVadilated(int PIsVadilated){
		this.PIsVadilated=PIsVadilated;
	}
	public int getPIsVadilated(){
		return PIsVadilated;
	}
	public void setPSubject(String PSubject){
		this.PSubject=PSubject;
	}
	public String getPSubject(){
		return PSubject;
	}
	public void setPBodyText(String PBodyText){
		this.PBodyText=PBodyText;
	}
	public String getPBodyText(){
		return PBodyText;
	}

	public void setPState(int PState){
		this.PState=PState;
	}
	public int getPState(){
		return PState;
	}

	
	public String getPReplyPostID() {
		return PReplyPostID;
	}
	public void setPReplyPostID(String pReplyPostID) {
		PReplyPostID = pReplyPostID;
	}
	public Date getPUpdateTime() {
		return PUpdateTime;
	}
	public void setPUpdateTime(Date pUpdateTime) {
		PUpdateTime = pUpdateTime;
	}

}

