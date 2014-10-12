package com.pm.bll.beans;

import junit.framework.Assert;
import org.junit.Test;
import com.pm.pojo.Complaint;

public class complaintbeanTest {

	@Test
	public void test() throws Exception {
		ComplaintBean bean=new ComplaintBean();
		Complaint complaint=new Complaint();
    	complaint.setCUserID("Ansin");
    	complaint.setCTicketSubject("Test002: subject2");
    	complaint.setCTicketContent("Test002: Content2");
    	complaint.setCStatus(0);
    	complaint.setCContactTimeType(0);
		Complaint complaint1 = bean.Save(complaint);
    	Assert.assertNotNull(complaint1);
    	bean.deleteComplaintByID(complaint1.getComplaintID());
    	Assert.assertNull(bean.GetComplaintByID(complaint1.getComplaintID()));
	}
}