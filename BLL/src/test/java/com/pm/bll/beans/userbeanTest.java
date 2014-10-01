package com.pm.bll.beans;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.pm.pojo.User;

public class userbeanTest {

	@Test
	public void test() throws Exception {
		UserBean bean=new UserBean();
		User user=new User();
    	
		user.setUPhone("112345");
		user.setUPassword("11234");
		user.setURegTime(new Date());
		User user1=bean.Save(user);
		Assert.assertNotNull(user1);
	}

}
