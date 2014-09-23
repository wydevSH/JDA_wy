package com.pm.pojo;

import java.util.Date;

public class Pfee {
	private String PMFeeID;
	private String FUserID;
	private float FeeofPM;
	private int FIsPaid;
	private Date FPaidDate;
	private String FComments;
	public void setPMFeeID(String PMFeeID){
		this.PMFeeID=PMFeeID;
	}
	public String getPMFeeID(){
		return PMFeeID;
	}
	public void setFUserID(String FUserID){
		this.FUserID=FUserID;
	}
	public String getFUserID(){
		return FUserID;
	}
	public void setFeeofPM(float FeeofPM){
		this.FeeofPM=FeeofPM;
	}
	public float getFeeofPM(){
		return FeeofPM;
	}
	public void setFIsPaid(int FIsPaid){
		this.FIsPaid=FIsPaid;
	}
	public int getFIsPaid(){
		return FIsPaid;
	}
	public void setFPaidDate(Date FPaidDate){
		this.FPaidDate=FPaidDate;
	}
	public Date getFPaidDate(){
		return FPaidDate;
	}
	public void setFComments(String FComments){
		this.FComments=FComments;
	}
	public String getFComments(){
		return FComments;
	}
}

