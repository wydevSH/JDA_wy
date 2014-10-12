package com.pm.pojo;

import java.sql.Date;

public class RepairTicket {
	
	String RepairTicketID ;
	String RUserID			;
	String RTicketSubject	;
	String RTicketContent	;
	Date RContactTime	;
	String RHandler		;
	String RHandlerPhone	;
	int RResumeTimes	;
	int RStatus			;
	String RComment			;
	Date RUpdateTime;
	int    RCount;
	
	public String getRepairTicketID() {
		return RepairTicketID;
	}
	public void setRepairTicketID(String repairTicketID) {
		RepairTicketID = repairTicketID;
	}
	public String getRUserID() {
		return RUserID;
	}
	public void setRUserID(String rUserID) {
		RUserID = rUserID;
	}
	public String getRTicketSubject() {
		return RTicketSubject;
	}
	public void setRTicketSubject(String rTicketSubject) {
		RTicketSubject = rTicketSubject;
	}
	public String getRTicketContent() {
		return RTicketContent;
	}
	public void setRTicketContent(String rTicketContent) {
		RTicketContent = rTicketContent;
	}
	public Date getRContactTime() {
		return RContactTime;
	}
	public void setRContactTime(Date rContactTime) {
		RContactTime = rContactTime;
	}
	public String getRHandler() {
		return RHandler;
	}
	public void setRHandler(String rHandler) {
		RHandler = rHandler;
	}
	public String getRHandlerPhone() {
		return RHandlerPhone;
	}
	public void setRHandlerPhone(String rHandlerPhone) {
		RHandlerPhone = rHandlerPhone;
	}
	public int getRResumeTimes() {
		return RResumeTimes;
	}
	public void setRResumeTimes(int rResumeTimes) {
		RResumeTimes = rResumeTimes;
	}
	public int getRStatus() {
		return RStatus;
	}
	public void setRStatus(int rStatus) {
		RStatus = rStatus;
	}
	public String getRComment() {
		return RComment;
	}
	public void setRComment(String rComment) {
		RComment = rComment;
	}
	public Date getRUpdateTime() {
		return RUpdateTime;
	}
	public void setRUpdateTime(Date rUpdateTime) {
		RUpdateTime = rUpdateTime;
	}
	public int getRcount() {
		return RCount;
	}
	public void setRcount(int rcount) {
		RCount = rcount;
	}

}
