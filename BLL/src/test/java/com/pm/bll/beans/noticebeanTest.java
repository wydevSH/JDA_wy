package com.pm.bll.beans;

import static org.junit.Assert.*;

import java.io.IOException;


import junit.framework.Assert;

import org.junit.Test;

import com.pm.pojo.Notice;

public class noticebeanTest {

	@Test
	public void test() throws Exception {
		NoticeBean bean=new NoticeBean();
		Notice notice=new Notice();
		notice.setNBiotopeID("Gongyuan");
    	notice.setNContent("Test_Content");
    	notice.setNPoster("Jeff1");
    	notice.setNSubject("Test_Subject");
    	notice.setNLabel("Tongji,Wuye,Gongyuan");
    	Notice notice1=bean.Save(notice);
    	Assert.assertNotNull(notice1);
    	bean.deleteNoticeByID(notice1.getNoticeID());
    	Assert.assertNull(bean.GetNoticeByID(notice1.getNoticeID()));
	}

}
