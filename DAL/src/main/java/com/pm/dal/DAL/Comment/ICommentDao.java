package com.pm.dal.DAL.Comment;

import com.pm.pojo.Comment;

public interface ICommentDao {
	
	public Comment addComment(Comment comment) throws Exception;


	public boolean deleteCommentById(String id)throws Exception;

	public boolean IsExsitCommentByName(String Phone)throws Exception;

	public boolean updateComment(Comment comment) throws Exception;


	public Comment selectCommentById(String UID)throws Exception;
	
	public Comment Save(Comment comment)throws Exception;

}
