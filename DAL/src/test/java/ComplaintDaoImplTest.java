import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.pm.dal.DAL.Complaint.ComplaintDaoImpl;
import com.pm.pojo.Complaint;


public class ComplaintDaoImplTest {

	@Test
	public void test() throws Exception {
	
		Complaint ticket = new Complaint();
		
		ticket.setCHandlerPhone("12345");
		ticket.setCStatus(123);
		ticket.setCUserID("asasa");
		
		ComplaintDaoImpl impl= new ComplaintDaoImpl();
		Complaint ticket1 =  impl.Save(ticket);
		Assert.assertNotNull(ticket1);
		
	   ticket1.setCTicketContent("990");
	   impl.Save(ticket1);
	   Complaint t3= impl.GetComplaintById(ticket1.getComplaintID());
	   Assert.assertEquals(t3.getCTicketContent(),ticket1.getCTicketContent());
		
	//	impl.selectComplaintById(rid)
		
	}
	
	
//	@Test
	public void testMultInsert() throws Exception {
	
		Complaint ticket = new Complaint();
		
		ticket.setCHandlerPhone("12345");
		ticket.setCStatus(123);
		Complaint ticket1 = new Complaint();
		
		ticket.setCHandlerPhone("12345");
		ticket.setCStatus(123);
		Complaint ticket2 = new Complaint();
		
		ticket.setCHandlerPhone("12345");
		ticket.setCStatus(123);
		Complaint ticket3 = new Complaint();
		
		ticket.setCHandlerPhone("12345");
		ticket.setCStatus(123);
		Complaint ticket4 = new Complaint();
		
		ticket.setCHandlerPhone("12345");
		ticket.setCStatus(123);
		
		ComplaintDaoImpl impl= new ComplaintDaoImpl();
		impl.Save(ticket);
		impl.Save(ticket1);
		impl.Save(ticket2);
		impl.Save(ticket3);
		impl.Save(ticket4);
		
		List<Complaint>  l=impl.GetComplaintByUserId(null, null, 1, 10);
		 Assert.assertEquals(l.size(), 10);
		 ticket.setCUserID("114");
		 impl.Save(ticket);
		 List<Complaint>  l2=impl.GetComplaintByUserId("114", null, 0, 10);
		 Assert.assertEquals(l2.size(), 1);
	}

}