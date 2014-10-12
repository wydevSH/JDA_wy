package com.pm.bll.beans;

import static org.junit.Assert.*;
import java.io.IOException;
import junit.framework.Assert;
import org.junit.Test;
import com.pm.pojo.RepairTicket;

public class repairticketbeanTest {

	@Test
	public void test() throws Exception {
		RepairTicketBean bean=new RepairTicketBean();
		RepairTicket repairticket=new RepairTicket();
		repairticket.setRUserID("ansin");
		repairticket.setRTicketSubject("Test01, subject1");
		repairticket.setRTicketContent("Test01: Repair Windows");
		repairticket.setRStatus(0);		
		RepairTicket repairticket1 = bean.Save(repairticket);
    	Assert.assertNotNull(repairticket1);
    	bean.deleteRepairTicketByID(repairticket1.getRepairTicketID());
    	Assert.assertNull(bean.GetRepairTicketByID(repairticket1.getRepairTicketID()));
	}
}