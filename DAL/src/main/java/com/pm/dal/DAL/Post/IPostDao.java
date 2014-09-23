package com.pm.dal.DAL.Post;

import com.pm.pojo.Post;

public interface IPostDao {

	
	public Post addPost(Post post) throws Exception;


	public boolean deletePostById(String id)throws Exception;

	public boolean IsExsitPostByName(String Phone)throws Exception;

	public boolean updatePost(Post post) throws Exception;


	public Post selectPostById(String UID)throws Exception;
	
	public Post Save(Post post)throws Exception;
}
