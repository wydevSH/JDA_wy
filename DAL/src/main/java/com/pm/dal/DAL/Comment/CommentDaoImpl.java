package com.pm.dal.DAL.Comment;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Calendar;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.Comment;

public class CommentDaoImpl {

	private static  SqlMapClient sqlMapClient = null;
	
	
	
	
	public  CommentDaoImpl() throws IOException
	{
		if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
		
	}
	
	
	public Comment addComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
	
//			if(this.IsExsitCommentByPhone(comment.getUPhone()))
//				return null;	
//			comment.setUID(String.valueOf(System.currentTimeMillis()));
//			sqlMapClient.insert("addComment", comment);		
		
			return comment;
	}

	public boolean deleteCommentById(String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;
		
		object = sqlMapClient.delete("deleteCommentById", id);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}

	public boolean updateComment(Comment comment) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;

		object = sqlMapClient.update("updateComment", comment);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}


	public Comment selectCommentByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub
		Comment User = null;
		
		User = (Comment) sqlMapClient.queryForObject("selectCommentByPhone",phone);
		
		return User;
	}

	public Comment selectCommentById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Comment User = null;
		
		User = (Comment) sqlMapClient.queryForObject("selectCommentById", id);
	
		return User;
	}

	public boolean IsExsitCommentByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub	
		
		Comment user = (Comment) sqlMapClient.queryForObject("selectCommentByPhone", phone);
		
		return user != null;
		
	
	}

	
	public boolean IsExsitCommentById(String uid) throws SQLException {
		// TODO Auto-generated method stub		
			
		return this.selectCommentById(uid)!=null;
	
	
		
	}
	
	
	public Comment Save(Comment comment) throws Exception {
		// TODO Auto-generated method stub		
		
			
//			if(comment.getUID()==null ||comment.getUID().equals("")){//never add before 
//			
//			    if(comment.getUPhone()==null || comment.getUPhone().equals("")||this.IsExsitCommentByPhone(comment.getUPhone()))//check whether add some phone
//			    	return null;
//				 comment.setUID(String.valueOf(Calendar.getInstance().getTimeInMillis() ));
//				 return this.addComment(comment);
//			}
//			else{
//				if(!this.IsExsitCommentById(comment.getUID()))
//					return null;
//				  this.updateComment(comment);	
//				  return comment;
//			}
//			
			return null;

	}
}
