package com.pm.dal.DAL.Notice;

import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import com.pm.pojo.Notice;

public class NoticeDaoImplTest extends TestCase {
	
	@Test
	public void test() throws Exception
	{
		INoticeDao dao= new NoticeDaoImpl();
		
		Notice notice=new Notice();
    	Assert.assertNull(dao.Save(notice));
    	notice.setNBiotopeID("Gongyuan");
    	notice.setNPoster("ansin");
    	notice.setNPubTime(new Date());
    	notice.setNExpTime(new Date());
    	notice.setNSubject("test1");
    	notice.setNContent("test content1");
    	notice.setNLabel("JDA, Gongyuan, test, Ansin");
    	notice.setNIsTop(1);
    	notice.setNIsDeleted(1);
    	Notice n1 = dao.Save(notice);
    	Assert.assertNotNull(n1);
    	Assert.assertTrue(dao.IsExsitNoticeById(n1.getNoticeID()));
    	dao.deleteNoticeById(notice.getNoticeID());
    	Assert.assertNull(dao.selectNoticeByID(n1.getNoticeID()));
	}
	
}
