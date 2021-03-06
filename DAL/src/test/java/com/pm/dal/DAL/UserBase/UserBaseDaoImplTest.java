package com.pm.dal.DAL.UserBase;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.User;

public class UserBaseDaoImplTest extends TestCase {
	
	private static  SqlMapClient sqlMapClient = null;
	
   @Before
   protected void setUp() throws IOException, SQLException
   {
	   if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
	   sqlMapClient.delete("deleteUser");
	   
   }
	
	
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
	    u1 = dao.Save(u1);
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
	
	
	@Test
	public void testmultiinsertuser() throws Exception
	{
		
		IUserDao dao= new UserDaoImpl();
		
		User user=new User();
    	
		user.setUPhone("11231");
		user.setUPassword("11234");
		user.setURegTime(new Date());
		user.setUBirthday(new Date());
		user.setUGender(0);
	    User u1 = dao.Save(user);
	    user.setUID("11234");
		user.setUPassword("11234");
		user.setURegTime(new Date());
		user.setUBirthday(new Date());
		user.setUGender(0);
		u1= dao.Save(user);
	    Assert.assertNull(u1);
		
		
		
	}
	
	@Test
	public void testequaluser() throws Exception
	{
		
		IUserDao dao= new UserDaoImpl();
		
		User user=new User();
    	
		user.setUPhone("112316");
		user.setUPassword("11234");
		user.setURegTime(new Date());
		user.setUBirthday(new Date());
		user.setUGender(0);
	    User u1 = dao.Save(user);
	    User u2=dao.selectUserByPhone(user.getUPhone());
	    Assert.assertEquals(u1.getUID(), u2.getUID());
		
		
		
	}
	

}
