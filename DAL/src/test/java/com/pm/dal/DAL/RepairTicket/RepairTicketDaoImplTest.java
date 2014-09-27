package com.pm.dal.DAL.RepairTicket;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.pm.pojo.RepairTicket;

public class RepairTicketDaoImplTest {

	@Test
	public void test() throws Exception {
	
		RepairTicket ticket = new RepairTicket();
		
		ticket.setRHandlerPhone("12345");
		ticket.setRStatus("123");
		
		RepairTicketDaoImpl impl= new RepairTicketDaoImpl();
		RepairTicket ticket1 =  impl.Save(ticket);
		Assert.assertNotNull(ticket1);
		
	   ticket1.setRComment("990");
	   impl.Save(ticket1);
	   RepairTicket t3= impl.GetRepairTicketById(ticket1.getRepairTicketID());
	   Assert.assertEquals(t3.getRComment(),ticket1.getRComment());
		
	//	impl.selectRepairTicketById(rid)
		
	}
	
	
	@Test
	public void testMultInsert() throws Exception {
	
		RepairTicket ticket = new RepairTicket();
		
		ticket.setRHandlerPhone("12345");
		ticket.setRStatus("123");
		RepairTicket ticket1 = new RepairTicket();
		
		ticket.setRHandlerPhone("12345");
		ticket.setRStatus("123");
		RepairTicket ticket2 = new RepairTicket();
		
		ticket.setRHandlerPhone("12345");
		ticket.setRStatus("123");
		RepairTicket ticket3 = new RepairTicket();
		
		ticket.setRHandlerPhone("12345");
		ticket.setRStatus("123");
		RepairTicket ticket4 = new RepairTicket();
		
		ticket.setRHandlerPhone("12345");
		ticket.setRStatus("123");
		
		RepairTicketDaoImpl impl= new RepairTicketDaoImpl();
		impl.Save(ticket);
		impl.Save(ticket1);
		impl.Save(ticket2);
		impl.Save(ticket3);
		impl.Save(ticket4);
		
		List<RepairTicket>  l=impl.GetRepairTicketByUserId(null, null, 1, 10);
		 Assert.assertEquals(l.size(), 10);
		 ticket.setRUserID("114");
		 impl.Save(ticket);
		 List<RepairTicket>  l2=impl.GetRepairTicketByUserId("114", null, 0, 10);
		 Assert.assertEquals(l2.size(), 1);
	}

}
