package com.pm.dal.DAL.Complaint;

import java.sql.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import com.pm.pojo.Complaint;

public class ComplaintDaoImplTest extends TestCase {
	
	@Test
	public void test() throws Exception
	{
		IComplaintDao dao= new ComplaintDaoImpl();
		
		Complaint complaint=new Complaint();
    	Assert.assertNull(dao.Save(complaint));	
    	complaint.setComplaintID("C0001");
    	complaint.setCUserID("Ansin");
    	complaint.setCTicketSubject("Test001: subject1");
    	complaint.setCTicketContent("Test001: Content1");
    	complaint.setCStatus(0);
    	complaint.setCContactTimeType(0);
    	System.out.print("=======ComplaintDaoImplTest.java=======");
		System.out.print(complaint.getComplaintID());
        Complaint c1 = dao.Save(complaint);
        Assert.assertNotNull(c1);
        Assert.assertTrue(dao.IsExsitComplaintById(c1.getComplaintID()));
        dao.deleteComplaintById(complaint.getComplaintID());
        Assert.assertNull(dao.selectComplaintById(c1.getComplaintID()));        	
	}
	
}
