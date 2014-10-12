package com.pm.dal.DAL.Complaint;

import java.util.Date;
import java.util.List;

import com.pm.pojo.Complaint;

public interface IComplaintDao {

	public Complaint addComplaint(Complaint complaint) throws Exception;

	public boolean IsExsitComplaintById(String uid) throws Exception;

	public boolean deleteComplaintById(String id)throws Exception;

	
	public Complaint updateComplaint(Complaint complaint) throws Exception;

	public List<Complaint> GetComplaintByUserId(String uid,Date max, Date min,int pagesize) throws Exception;
	
	public Complaint selectComplaintById(String UID)throws Exception;
	
	public Complaint Save(Complaint complaint)throws Exception;
}
