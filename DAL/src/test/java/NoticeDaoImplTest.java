import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.pm.dal.DAL.Notice.NoticeDaoImpl;
import com.pm.pojo.Notice;


public class NoticeDaoImplTest {

	@Test
	public void test() throws Exception {
	
		Notice notice = new Notice();
		
		notice.setNContent("12345");
		
		
		NoticeDaoImpl impl= new NoticeDaoImpl();
		Notice notice1 =  impl.Save(notice);
		Assert.assertNull(notice1);
		notice.setNPoster("dsds");
		
	   notice.setNContent("990");
	   notice.setNBiotopeID("12234");
	   notice.setNContent("sasa");
	   notice.setNSubject("sd");
	   notice.setNLabel("sasa");
	   notice.setUpdateTime(new Date());
	   notice = impl.Save(notice);
	   Notice t3= impl.GetNoticeByID(notice.getNoticeID());
	   Assert.assertEquals(t3.getNContent(),notice.getNContent());
		
	//	impl.selectNoticeById(rid)
		
	}
	
	
    @Test
	public void testMultInsert() throws Exception {
	
		Notice notice = new Notice();
		
		notice.setNContent("12345");
	
		Notice notice1 = new Notice();
		
		notice.setNContent("12345");
	//	notice.setCStatus(123);
		Notice notice2 = new Notice();
		
		notice.setNContent("12345");
		//notice.setCStatus(123);
		Notice notice3 = new Notice();
		
		notice.setNContent("12345");
	//	notice.setCStatus(123);
		Notice notice4 = new Notice();
		
		notice.setNContent("12345");
		//notice.setCStatus(123);
		
		NoticeDaoImpl impl= new NoticeDaoImpl();
		impl.Save(notice);
		impl.Save(notice1);
		impl.Save(notice2);
		impl.Save(notice3);
		impl.Save(notice4);
		
		List<Notice>  l=impl.GetNotice(null, 1, 10);
		 Assert.assertEquals(l.size(), 10);
		 notice.setNLabel("114");
		 impl.Save(notice);
		 List<Notice>  l2=impl.GetNotice( null, 0, 10);
		 Assert.assertEquals(l2.size(), 1);
	}

}