package com.pm.dal.DAL.User;

import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import com.pm.pojo.User;

public class UserDaoImplTest extends TestCase {
	
	@Test
	public void test() throws Exception
	{
		IUserDao dao= new UserDaoImpl();
		
		User user=new User();
    	Assert.assertNull(dao.Save(user));
		user.setUPhone("112345");
		user.setUPassword("11234");
		user.setURegTime(new Date());
		user.setUBirthday(new Date());
		user.setUGender(0);
	    User u1 = dao.Save(user);
	    Assert.assertNotNull(u1);
	    Assert.assertTrue(dao.IsExsitUserByPhone(u1.getUPhone()));
	    Assert.assertNotNull(dao.selectUserById(u1.getUID()));
	    dao.deleteUserById(user.getUID());
	    Assert.assertNull(dao.selectUserById(u1.getUID()));
	}
	
	@Test
	public void testExistIDwithoutphone() throws Exception
	{
		
		IUserDao dao= new UserDaoImpl();
		
		User user=new User();
    	user.setUID("1123445");
		user.setUPhone("");
		user.setUPassword("11234");
		user.setURegTime(new Date());
		user.setUBirthday(new Date());
		user.setUGender(0);
	    User u1 = dao.Save(user);
	    Assert.assertNull(u1);
		
		
		
	}

}
