package com.pm.pojo;

import java.util.Date;

public class RepairTicket {
	String RepairTicketID ;
	String RUserID			;
	String RTicketSubject	;
	String RTicketContent	;
	Date RContactTime	;
	String RHandler		;
	String RHandlerPhone	;
	int	   RResumeTimes	;
	String RStatus			;
	String RComment			;
	Date RUpdateTime	;
	
	

	public Date getRUpdateTime() {
		return RUpdateTime;
	}
	public void setRUpdateTime(Date rUpdateTime) {
		RUpdateTime = rUpdateTime;
	}
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
	public void setRHandlerPhone(String rHanderPhone) {
		RHandlerPhone = rHanderPhone;
	}
	public int getRResumeTimes() {
		return RResumeTimes;
	}
	public void setRResumeTimes(int rResumeTimes) {
		RResumeTimes = rResumeTimes;
	}
	public String getRStatus() {
		return RStatus;
	}
	public void setRStatus(String rStatus) {
		RStatus = rStatus;
	}
	public String getRComment() {
		return RComment;
	}
	public void setRComment(String rComment) {
		RComment = rComment;
	}
	
	
}
