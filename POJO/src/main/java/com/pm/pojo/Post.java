package com.pm.pojo;

import java.util.Date;

public class Post {
	private String PostID;
	private String PUserID;
	private Date PSubmitTime;
	private int PIsVadilated;
	private String PSubject;
	private String PBodyText;
	private int PReplyNum;
	private int PClickNum;
	private int PState;
	private String PLastReplierID;
	private Date PLastRepTime;
	
	public void setPostID(String PostID){
		this.PostID=PostID;
	}
	public String getPostID(){
		return PostID;
	}
	public void setPUserID(String PUserID){
		this.PUserID=PUserID;
	}
	public String getPUserID(){
		return PUserID;
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
	public void setPReplyNum(int PReplyNum){
		this.PReplyNum=PReplyNum;
	}
	public int getPReplyNum(){
		return PReplyNum;
	}
	public void setPClickNum(int PClickNum){
		this.PClickNum=PClickNum;
	}
	public int getPClickNum(){
		return PClickNum;
	}
	public void setPState(int PState){
		this.PState=PState;
	}
	public int getPState(){
		return PState;
	}
	public void setPLastReplierID(String PLastReplierID){
		this.PLastReplierID=PLastReplierID;
	}
	public String getPLastReplierID(){
		return PLastReplierID;
	}
	public void setPLastRepTime(Date PLastRepTime){
		this.PLastRepTime=PLastRepTime;
	}
	public Date getPLastRepTime(){
		return PLastRepTime;
	}
}

