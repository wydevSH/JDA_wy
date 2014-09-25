package com.pm.dal.DAL.Post;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.Post;

public class PostDaoImpl {

	private static  SqlMapClient sqlMapClient = null;
	
	
	
	
	public  PostDaoImpl() throws IOException
	{
		if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
		
	}
	
	
	public Post addPost(Post post) throws Exception {
		// TODO Auto-generated method stub
	
//			if(this.IsExsitPostByPhone(post.getUPhone()))
//				return null;	
//			post。(String.valueOf(System.currentTimeMillis()));
//			sqlMapClient.insert("addPost", post);		
		
			return post;
	}

	public boolean deletePostById(String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;
		
		object = sqlMapClient.delete("deletePostById", id);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}

	public Post updatePost(Post post) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;

		object = sqlMapClient.update("updatePost", post);
		
		if (object != 0) {
			return post;

		}
		return null;
	}


	public Post selectPostByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub
		Post post = null;
		
		post = (Post) sqlMapClient.queryForObject("selectPostByPhone",phone);
		
		return post;
	}

	public Post selectPostById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Post User = null;
		
		User = (Post) sqlMapClient.queryForObject("selectPostById", id);
	
		return User;
	}

// to be discussed !	
//	public boolean IsExsitPostByPhone(String phone) throws SQLException {
//		// TODO Auto-generated method stub	
//		
//		Post user = (Post) sqlMapClient.queryForObject("selectPostByPhone", phone);
//		
//		return user != null;
//		
//	
//	}

	
	public boolean IsExsitPostById(String uid) throws SQLException {
		// TODO Auto-generated method stub		
			
		return this.selectPostById(uid)!=null;
	
	
		
	}
	
	
	public Post Save(Post post) throws Exception {
		
		
		
		return post;
	
	}
}
