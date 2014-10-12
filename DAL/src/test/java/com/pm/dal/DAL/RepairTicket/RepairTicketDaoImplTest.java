package com.pm.dal.DAL.RepairTicket;

import java.sql.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import com.pm.pojo.RepairTicket;

public class RepairTicketDaoImplTest extends TestCase {
	
	@Test
	public void test() throws Exception
	{
		IRepairTicketDao dao= new RepairTicketDaoImpl();
		
		RepairTicket repairticket=new RepairTicket();
    	Assert.assertNull(dao.Save(repairticket));	
		repairticket.setRUserID("david");
		repairticket.setRTicketSubject("Test02, subject1");
		repairticket.setRTicketContent("Test02: Repair Windows");
		repairticket.setRStatus(0);	
		System.out.print("====RepairTicketDaoImplTest====");
		System.out.print(repairticket.getRepairTicketID());
        RepairTicket rt1 = dao.Save(repairticket);
        Assert.assertNotNull(rt1);
        Assert.assertTrue(dao.IsExsitRepairTicketById(rt1.getRepairTicketID()));
        dao.deleteRepairTicketById(repairticket.getRepairTicketID());
        Assert.assertNull(dao.selectRepairTicketById(rt1.getRepairTicketID()));    	
	}
	
}
