package com.pm.dal.DAL.Post;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.Post;
import com.pm.pojo.PostTitle;

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
	public void TestInsert() throws Exception
	{
		Post p=new Post();
		p.setPBodyText("dsadasdas");
		p.setPSubject("sasa");
		p.setPostID("11234");
		p.setPRootID("11234");
		p.setPPhone("122345");
		PostDaoImpl dao=new PostDaoImpl();
		
		Post p1 = dao.addNewPost(p);
		Assert.assertNotNull(p1);

		
	}
	
//	@Test
//	public void TestUpdate()
//	{
//		
//		
//		
//	}
//	
//	

//	
//	@Test
//	public void TestReplyPost()
//	{
//		
//		
//		
//	}
//	
//	@Test
//	public void TestGetNewAddPost()
//	{
//		
//		
//		
//	}
//	
//	@Test
//	public void TestGetNewAddPostTitle()
//	{
//		
//		
//		
//	}
//	
	@Test
	public void TestGetNewAddPostforcertainPhone() throws Exception
	{
		Post p=new Post();
		p.setPBodyText("dsadasdas");
		p.setPSubject("sasa");
		p.setPostID("11234");
		p.setPRootID("11234");
		p.setPPhone("122345");
		PostDaoImpl dao=new PostDaoImpl();
		dao.addNewPost(p);
		List<Post> p1 = dao.selectPostByPhone("122345", null, null, 10);
		List<PostTitle> p2 = dao.selectRelatedPostTitle("122345", null, null, 10);
		Assert.assertEquals(1, p1.size());
		Assert.assertEquals(1, p2.size());
		
		
	}
	
//	
//	
	@Test
	public void TestGetNewAddPostforcertainRootid() throws Exception
	{
		
		
		Post p=new Post();
		p.setPBodyText("dsadasdas");
		p.setPSubject("sasa");
		p.setPostID("11234");
		p.setPRootID("11234");
		p.setPPhone("122345");
		PostDaoImpl dao=new PostDaoImpl();
		dao.addNewPost(p);
		List<Post> p1 = dao.selectPost("11234", null, null, 10);
		Assert.assertNotNull(p1);
		Assert.assertEquals(1, p1.size());
		int i=dao.GetNewPostTitleCount(null);
		Assert.assertEquals(1, i);
		int i1=dao.GetNewPostCount(null);
		Assert.assertEquals(1, i1);
	}
	
	
	
}
