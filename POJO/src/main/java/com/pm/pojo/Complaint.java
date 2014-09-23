package com.pm.pojo;

public class Complaint {
	private String ComplaintID;
	private String CUserID;
	private String CTicketSubject;
	private String CTicketContent;
	private int CContactTimeType;
	private String CHandler;
	private String CHandlerPhone;
	private int CResumeTimes;
	private int CStatus;
	public void setComplaintID(String ComplaintID){
		this.ComplaintID=ComplaintID;
	}
	public String getComplaintID(){
		return ComplaintID;
	}
	public void setCUserID(String CUserID){
		this.CUserID=CUserID;
	}
	public String getCUserID(){
		return CUserID;
	}
	public void setCTicketSubject(String CTicketSubject){
		this.CTicketSubject=CTicketSubject;
	}
	public String getCTicketSubject(){
		return CTicketSubject;
	}
	public void setCTicketContent(String CTicketContent){
		this.CTicketContent=CTicketContent;
	}
	public String getCTicketContent(){
		return CTicketContent;
	}
	public void setCContactTimeType(int CContactTimeType){
		this.CContactTimeType=CContactTimeType;
	}
	public int getCContactTimeType(){
		return CContactTimeType;
	}
	public void setCHandler(String CHandler){
		this.CHandler=CHandler;
	}
	public String getCHandler(){
		return CHandler;
	}
	public void setCHandlerPhone(String CHandlerPhone){
		this.CHandlerPhone=CHandlerPhone;
	}
	public String getCHandlerPhone(){
		return CHandlerPhone;
	}
	public void setCResumeTimes(int CResumeTimes){
		this.CResumeTimes=CResumeTimes;
	}
	public int getCResumeTimes(){
		return CResumeTimes;
	}
	public void setCStatus(int CStatus){
		this.CStatus=CStatus;
	}
	public int getCStatus(){
		return CStatus;
	}
}

