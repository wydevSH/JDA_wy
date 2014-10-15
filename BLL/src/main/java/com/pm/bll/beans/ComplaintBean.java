package com.pm.bll.beans;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.pm.bll.interfaces.IComplaintOperation;
import com.pm.dal.DAL.Complaint.ComplaintDaoImpl;
import com.pm.dal.DAL.Complaint.IComplaintDao;
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
			Date max, Date min,int pagesize) throws Exception {
		// TODO Auto-generated method stub
		return complaintdao.GetComplaintByUserId(uid, max, min, pagesize);
	}	

}
