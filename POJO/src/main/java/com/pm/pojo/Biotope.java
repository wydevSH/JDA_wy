package com.pm.pojo;

import java.util.Date;

public class Biotope {
	private String BiotopeID;
	private String BBiotopeName;
	private String BPropertyID;
	private String BAddress;
	private Date BBeginYear;
	public void setBiotopeID(String BiotopeID){
		this.BiotopeID=BiotopeID;
	}
	public String getBiotopeID(){
		return BiotopeID;
	}
	public void setBBiotopeName(String BBiotopeName){
		this.BBiotopeName=BBiotopeName;
	}
	public String getBBiotopeName(){
		return BBiotopeName;
	}
	public void setBPropertyID(String BPropertyID){
		this.BPropertyID=BPropertyID;
	}
	public String getBPropertyID(){
		return BPropertyID;
	}
	public void setBAddress(String BAddress){
		this.BAddress=BAddress;
	}
	public String getBAddress(){
		return BAddress;
	}
	public void setBBeginYear(Date BBeginYear){
		this.BBeginYear=BBeginYear;
	}
	public Date getBBeginYear(){
		return BBeginYear;
	}
}

