package com.pm.dal.DAL.Post;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.Post;

public class PostTest {

private static  SqlMapClient sqlMapClient = null;
	
	
	
	
	public  PostTest() throws IOException
	{
		if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
		
	}
	
	@Before
	public void Setup() throws SQLException
	{
		
		sqlMapClient.delete("deleteAllPost");
		sqlMapClient.delete("deleteAllPostTitle");
		
		
	}
	
	
	
	@Test
	public void TestInsert()
	{
		Post p=new Post();
		p.se
		
		
	}
	
	@Test
	public void TestUpdate()
	{
		
		
		
	}
	
	
	@Test
	public void TestAddNewPost()
	{
		
		
		
	}
	
	
	@Test
	public void TestReplyPost()
	{
		
		
		
	}
	
	@Test
	public void TestGetNewAddPost()
	{
		
		
		
	}
	
	@Test
	public void TestGetNewAddPostTitle()
	{
		
		
		
	}
	
	@Test
	public void TestGetNewAddPostforcertainPhone()
	{
		
		
		
	}
	
	
	
	@Test
	public void TestGetNewAddPostforcertainRootid()
	{
		
		
		
	}
	
	
	
}
