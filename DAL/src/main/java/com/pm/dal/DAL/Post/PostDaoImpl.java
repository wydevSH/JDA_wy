package com.pm.dal.DAL.Post;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.Post;
import com.pm.pojo.PostTitle;
import com.pm.pojo.RepairTicket;

public class PostDaoImpl implements IPostDao{

	private static  SqlMapClient sqlMapClient = null;
	
	
	
	
	public  PostDaoImpl() throws IOException
	{
		if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
		
	}
	
	
	public Post addNewPost(Post post) throws Exception {
		// TODO Auto-generated method stub
	    try{
	    	
	      
     	   sqlMapClient.startTransaction();     	     	   
     	   sqlMapClient.insert("addPost", post);
     	   sqlMapClient.insert("addPostTitle", post);
     	   sqlMapClient.commitTransaction();
     		
     	   return post;
     	
     	  
        }catch(Exception e)
        {
     	   throw e;
        }
        finally{
     	   
     	   sqlMapClient.endTransaction();
     	   
        }
	
			
	}
	
	
	public Post addReplyPost(Post post) throws Exception {
		// TODO Auto-generated method stub
	    try{
        	
     	   sqlMapClient.startTransaction();     	   
     	   sqlMapClient.insert("addPost", post);
     	   int rowaffect = sqlMapClient.update("updatePostTitleByPost", post);
     	   if(rowaffect  <= 0)
     		   throw new SQLException("error to update title");
     	   
     	   sqlMapClient.commitTransaction();
     	   
     		return post;
	  
        }catch(Exception e)
        {
     	   throw e;
        }
        finally{
     	   
     	   sqlMapClient.endTransaction();
     	   
        }
	
			
	}

	public boolean IsExsitPostTitleById(String posttitleID) throws Exception {
		// TODO Auto-generated method stub
		return this.selectPostTitleById(posttitleID)!= null ;
	}


	public boolean deletePostById(String id) throws Exception {

		return false ;
	}

	/**
	 * algorithem:
	 * 1. check if post exist
	 * 2. begin trans
	 * 3. update the post
	 * 4. update the post tilte(update time)
	 * 5  endtrans
	 * 
	 * 
	 * 
	 */
	public Post updatePost(Post post) throws Exception {
		// TODO Auto-generated method stub
      
			if(post.getPRootID()==null &&post.getPRootID().equals(""))
				return null; 
           try{
        	
        	   sqlMapClient.startTransaction();
        	   
        	   int rowaffect = sqlMapClient.update("updatePost", post);
        	   if(rowaffect == 0)
        		   throw new SQLException("error to update post");
               PostTitle title=this.selectPostTitleById(post.getPostID());
               rowaffect=sqlMapClient.update("updatePostTitleByPost", post);
               if(rowaffect == 0)
        		   throw new SQLException("error to update post");
        	   sqlMapClient.commitTransaction();
        	   if(rowaffect != 0)
        		return post;
        	
        	  return null;
           }catch(Exception e)
           {
        	   throw e;
           }
           finally{
        	   
        	   sqlMapClient.endTransaction();
        	   
           }
	
	
		
	}


	public Post selectPostById(String id) throws Exception {
		// TODO Auto-generated method stub
		Post User = null;
		
		User = (Post) sqlMapClient.queryForObject("selectPostById", id);
	
		return User;
	}
	
	public PostTitle selectPostTitleById(String id) throws Exception {
		// TODO Auto-generated method stub
		PostTitle Title = null;
		
		Title = (PostTitle) sqlMapClient.queryForObject("selectPostTitleById", id);
	
		return Title;
	}

	
	public boolean IsExsitPostById(String uid) throws Exception {
		// TODO Auto-generated method stub		
			
		return this.selectPostById(uid)!=null;
	
	
		
	}
	
	



	public List<PostTitle> selectRelatedPostTitle(String Phone, Date start,
			Date end, int pagesize) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> c=new HashMap<String,Object>();
		c.put("Phone",Phone);
		c.put("MAX", start);
		c.put("MIN", end);	
		c.put("_size", pagesize);
	
		List<PostTitle> PostTitles = (List<PostTitle>) sqlMapClient.queryForList("selectPostTitlebyMultiCri", c);
		
		return PostTitles ;
	}


	public List<Post> selectPost(String rootid, Date start, Date end,
			int pagesize) throws Exception {
		Map<String,Object> c=new HashMap<String,Object>();
		c.put("rootid", rootid);
		c.put("MAX", start);
		c.put("MIN", end);	
		c.put("_size", pagesize);
	
		List<Post> Posts = (List<Post>) sqlMapClient.queryForList("selectPostbyMultiCri", c);
		
		return Posts ;
	}

	
	public Integer GetNewPostTitleCount(Date updatetime ) throws Exception
	{
		Map<String,Object> c=new HashMap<String,Object>();
		
		
		c.put("Min", updatetime);	

		Integer count = (Integer) sqlMapClient.queryForObject("GetNewPostTitleCountFromLast", c);
		
		return count ;
		
		
	}
	
	public Integer GetNewPostCount(Date updatetime ) throws Exception
	{
		
		Map<String,Object> c=new HashMap<String,Object>();
		
		
		c.put("MIN", updatetime);	

		Integer count = (Integer) sqlMapClient.queryForObject("GetNewPostCountFromLast", c);
		
		return count ;
	}
	 
	public List<PostTitle> selectPostTitle(Date start, Date end, int pagesize)
			throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> c=new HashMap<String,Object>();
		c.put("MAX", start);
		c.put("MIN", end);	
		c.put("_size", pagesize);
	
		List<PostTitle> PostTitles = (List<PostTitle>) sqlMapClient.queryForList("selectPostTitle", c);
		
		return PostTitles ;
	}

	public List<Post> selectPostByPhone(String Phone,Date start, Date end, int pagesize)
			throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> c=new HashMap<String,Object>();
		c.put("Phone",Phone);
		c.put("MAX", start);
		c.put("MIN", end);	
		c.put("_size", pagesize);
	
		List<Post> PostTitles = (List<Post>) sqlMapClient.queryForList("selectPostbyMultiCri", c);
		
		return PostTitles ;
	}



}
