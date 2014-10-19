package com.pm.bll.beans;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.pm.bll.interfaces.IPostOperation;
import com.pm.dal.DAL.Post.IPostDao;
import com.pm.dal.DAL.Post.PostDaoImpl;
import com.pm.pojo.Post;
import com.pm.pojo.PostTitle;

public class PostBean implements IPostOperation {

	
	protected IPostDao dao=null;
	
	
	public PostBean() throws IOException {
		
		dao=new PostDaoImpl();
	}

	
	
	public boolean deletePostById(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public List<PostTitle> selectRelatedPostTitle(String Phone, Date start,
			Date end, int pagesize) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectRelatedPostTitle(Phone, start, end, pagesize);
	}

	public Post updatePost(Post post) throws Exception {
		// TODO Auto-generated method stub
		return dao.updatePost(post);
	}

	public Post addNewPost(Post post) throws Exception {
		// TODO Auto-generated method stub
		return dao.addNewPost(post);
	}

	public Post addReplyPost(Post post) throws Exception {
		// TODO Auto-generated method stub
		return dao.addReplyPost(post);
	}

	public Post selectPostById(String PID) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPostById(PID);
	}

	public List<Post> selectPost(String rootid, Date start, Date end,
			int pagesize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Post> selectPostByPhone(String Phone, Date start, Date end,
			int pagesize) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPostByPhone(Phone, start, end, pagesize);
	}

	public List<PostTitle> selectPostTitle(Date start, Date end, int pagesize)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPostTitle(start, end, pagesize);
	}

}
