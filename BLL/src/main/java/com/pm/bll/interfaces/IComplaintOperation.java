package com.pm.bll.interfaces;

import com.pm.pojo.Complaint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Ansin W.
 * 
 *
 */
public interface IComplaintOperation {
	
    public Complaint GetComplaintByID(String ID) throws Exception;
    public List<Complaint> GetComplaintByUserId(String uid,Date max, Date min,int pagesize) throws Exception;
    public Boolean deleteComplaintByID(String ID) throws Exception;
    public Complaint Save(Complaint complaint) throws Exception;	
	
}
