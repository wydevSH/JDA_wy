package com.pm.dal.DAL.UserBase;

import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import com.pm.pojo.UserBase;

public class UserBaseDaoImplTest extends TestCase {
	
	@Test
	public void test() throws Exception
	{
		IUserBaseDao dao= new UserBaseDaoImpl();
		
		UserBase user=new UserBase();
    	Assert.assertNull(dao.Save(user));
		user.setUPhone("112345");
		user.setUPassword("11234");
		user.setURegTime(new Date());
	    UserBase u1 = dao.Save(user);
	    Assert.assertNotNull(u1);
	    Assert.assertTrue(dao.IsExsitUserBaseByPhone(u1.getUPhone()));
	    Assert.assertNotNull(dao.selectUserBaseById(u1.getUID()));
	    dao.deleteUserBaseById(user.getUID());
	    Assert.assertNull(dao.selectUserBaseById(u1.getUID()));
	}
	

}
