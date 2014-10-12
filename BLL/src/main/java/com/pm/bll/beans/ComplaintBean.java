package com.pm.bll.beans;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import com.pm.bll.interfaces.IComplaintOperation;
import com.pm.dal.DAL.Complaint.IComplaintDao;
import com.pm.dal.DAL.Complaint.ComplaintDaoImpl;
import com.pm.pojo.Complaint;


public class ComplaintBean implements IComplaintOperation {


	protected  IComplaintDao complaintdao = null;
	
	public ComplaintBean() throws IOException{
		this.complaintdao=new ComplaintDaoImpl();

	}

	public IComplaintDao getComplaintdao() {
		return complaintdao;
	}

	public void setComplaintdao(IComplaintDao repairTicketDao) {
		this.complaintdao = repairTicketDao;
	}


	public Complaint GetComplaintByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		
		return complaintdao.selectComplaintById(ID);
	}

	public Boolean deleteComplaintByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		return complaintdao.deleteComplaintById(ID);
	}


	public Complaint Save(Complaint complaint) throws Exception {
		// TODO Auto-generated method stub
		System.out.print("======ComplaintBean.java=========");
		return complaintdao.Save(complaint);
	}

	public List<Complaint> GetComplaintByUserId(String uid,
			Date time_start, int s, int offset) throws Exception {
		// TODO Auto-generated method stub
		return complaintdao.GetComplaintByUserId(uid, time_start, s, offset);
	}	

}