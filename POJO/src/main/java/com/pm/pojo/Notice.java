package com.pm.pojo;

import java.util.Date;

public class Notice {
	private String NoticeID;
	private String NBiotopeID;
	private String NPoster;
	private Date NPubTime;
	private Date NExpTime;
	private String NSubject;
	private String NContent;
	private String NLabel;
	private int NIsTop;
	private int NIsDeleted;
	private Date UpdateTime;
	
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	public void setNoticeID(String NoticeID){
		this.NoticeID=NoticeID;
	}
	public String getNoticeID(){
		return NoticeID;
	}
	public void setNBiotopeID(String NBiotopeID){
		this.NBiotopeID=NBiotopeID;
	}
	public String getNBiotopeID(){
		return NBiotopeID;
	}
	public void setNPoster(String NPoster){
		this.NPoster=NPoster;
	}
	public String getNPoster(){
		return NPoster;
	}
	public void setNPubTime(Date NPubTime){
		this.NPubTime=NPubTime;
	}
	public Date getNPubTime(){
		return NPubTime;
	}
	public void setNExpTime(Date NExpTime){
		this.NExpTime=NExpTime;
	}
	public Date getNExpTime(){
		return NExpTime;
	}
	public void setNSubject(String NSubject){
		this.NSubject=NSubject;
	}
	public String getNSubject(){
		return NSubject;
	}
	public void setNContent(String NContent){
		this.NContent=NContent;
	}
	public String getNContent(){
		return NContent;
	}
	public void setNLabel(String NLabel){
		this.NLabel=NLabel;
	}
	public String getNLabel(){
		return NLabel;
	}
	public void setNIsTop(int NIsTop){
		this.NIsTop=NIsTop;
	}
	public int getNIsTop(){
		return NIsTop;
	}
	public void setNIsDeleted(int NIsDeleted){
		this.NIsDeleted=NIsDeleted;
	}
	public int getNIsDeleted(){
		return NIsDeleted;
	}
}

