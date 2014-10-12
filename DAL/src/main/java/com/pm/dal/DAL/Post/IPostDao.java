package com.pm.dal.DAL.Post;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pm.pojo.Post;
import com.pm.pojo.PostTitle;

public interface IPostDao {

	


	public boolean deletePostById(String id)throws Exception;

    public List<PostTitle> selectRelatedPostTitle(String Phone,Date start,Date end,int pagesize)throws Exception;
    
    
	public Post updatePost(Post post) throws Exception;

	public Post addPost(Post post) throws Exception;

	public Post selectPostById(String PID)throws Exception;
	
	
	public List<Post> selectPost(String rootid,Date start,Date end,int pagesize)throws Exception;
	

	public List<PostTitle> selectPostTitle(Date start,Date end,int pagesize)throws Exception;
	
	
}
