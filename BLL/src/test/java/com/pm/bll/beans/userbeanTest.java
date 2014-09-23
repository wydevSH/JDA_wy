package com.pm.bll.beans;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.pm.pojo.UserBase;

public class userbeanTest {

	@Test
	public void test() throws Exception {
		UserBean bean=new UserBean();
		UserBase user=new UserBase();
    	
		user.setUPhone("112345");
		user.setUPassword("11234");
		user.setURegTime(new Date());
		UserBase user1=bean.Save(user);
		Assert.assertNotNull(user1);
	}

}
