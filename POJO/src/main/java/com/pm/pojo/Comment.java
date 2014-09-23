package com.pm.pojo;


public class Comment {
	private String CommentID;
	private String CMainPostID;
	private String CUserID;
	private int CReplyCont;
	private int CReplyTime;
	private int CState;
	public void setCommentID(String CommentID){
		this.CommentID=CommentID;
	}
	public String getCommentID(){
		return CommentID;
	}
	public void setCMainPostID(String CMainPostID){
		this.CMainPostID=CMainPostID;
	}
	public String getCMainPostID(){
		return CMainPostID;
	}
	public void setCUserID(String CUserID){
		this.CUserID=CUserID;
	}
	public String getCUserID(){
		return CUserID;
	}
	public void setCReplyCont(int CReplyCont){
		this.CReplyCont=CReplyCont;
	}
	public int getCReplyCont(){
		return CReplyCont;
	}
	public void setCReplyTime(int CReplyTime){
		this.CReplyTime=CReplyTime;
	}
	public int getCReplyTime(){
		return CReplyTime;
	}
	public void setCState(int CState){
		this.CState=CState;
	}
	public int getCState(){
		return CState;
	}
}

