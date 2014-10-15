//package com.pm.dal.DAL.Post;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.sql.SQLException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.ibatis.common.resources.Resources;
//import com.ibatis.sqlmap.client.SqlMapClient;
//import com.ibatis.sqlmap.client.SqlMapClientBuilder;
//import com.pm.pojo.Post;
//import com.pm.pojo.PostTitle;
//import com.pm.pojo.RepairTicket;
//
//public class PostDaoImpl implements IPostDao{
//
//	private static  SqlMapClient sqlMapClient = null;
//	
//	
//	
//	
//	public  PostDaoImpl() throws IOException
//	{
//		if(sqlMapClient ==null){
//			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
//			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
//			reader.close();
//		}
//		
//		
//	}
//	
//	
//	public Post addPost(Post post) throws Exception {
//		// TODO Auto-generated method stub
//	    try{
//        	
//     	   sqlMapClient.startTransaction();     	   
//     	   int rowaffect = sqlMapClient.update("addPost", post);
//     	   PostTitle title = new  PostTitle();
//     	   title.setPIsVadilated(post.getPIsVadilated());
//     	   title.setPLastReplierID(post.getPLastReplierID());//here should change to phone?
//     	   title.setPLastUpdateTime(post.getPSubmitTime());
//     	   title.setPostID(post.getPostID());
//     	   title.setPPhone(post.getPPhone());
//     	   title.setPState(0);
//     	   title.setPSubject(post.getPSubject());
//     	   title.setPSubmitTime(post.getPSubmitTime());
//     	   
//     	   sqlMapClient.insert("addPostTitle", title);
//     	   sqlMapClient.commitTransaction();
//     	   if(rowaffect != 0)
//     		return post;
//     	
//     	   return null;
//        }catch(Exception e)
//        {
//     	   throw e;
//        }
//        finally{
//     	   
//     	   sqlMapClient.endTransaction();
//     	   
//        }
//	
//			
//	}
//
//	public boolean deletePostById(String id) throws Exception {
//
//		return false ;
//	}
//
//	/**
//	 * algorithem:
//	 * 1. check if post exist
//	 * 2. begin trans
//	 * 3. update the post
//	 * 4. update the post tilte(update time)
//	 * 5  endtrans
//	 * 
//	 * 
//	 * 
//	 */
//	public Post updatePost(Post post) throws Exception {
//		// TODO Auto-generated method stub
//      
//            
//           try{
//        	
//        	   sqlMapClient.startTransaction();
//        	   
//        	   int rowaffect = sqlMapClient.update("updatePost", post);
//        	 
//        	   sqlMapClient.update("updatePostTitleByPost", post);
//        	   sqlMapClient.commitTransaction();
//        	   if(rowaffect != 0)
//        		return post;
//        	
//        	   return null;
//           }catch(Exception e)
//           {
//        	   throw e;
//           }
//           finally{
//        	   
//        	   sqlMapClient.endTransaction();
//        	   
//           }
//	
//		
//	}
//
//
//
//
//	public Post selectPostById(String id) throws Exception {
//		// TODO Auto-generated method stub
//		Post User = null;
//		
//		User = (Post) sqlMapClient.queryForObject("selectPostById", id);
//	
//		return User;
//	}
//
//
//	
//	public boolean IsExsitPostById(String uid) throws Exception {
//		// TODO Auto-generated method stub		
//			
//		return this.selectPostById(uid)!=null;
//	
//	
//		
//	}
//	
//	
//
//
//
//	public List<PostTitle> selectRelatedPostTitle(String Phone, Date start,
//			Date end, int pagesize) throws Exception {
//		// TODO Auto-generated method stub
//		Map<String,Object> c=new HashMap<String,Object>();
//		c.put("Phone",Phone);
//		c.put("MAX", start);
//		c.put("MIN", end);	
//		c.put("_size", pagesize);
//	
//		List<PostTitle> PostTitles = (List<PostTitle>) sqlMapClient.queryForList("selectRelatedPostTitle", c);
//		
//		return PostTitles ;
//	}
//
//
//	public List<Post> selectPost(String rootid, Date start, Date end,
//			int pagesize) throws Exception {
//		Map<String,Object> c=new HashMap<String,Object>();
//		c.put("rootid", rootid);
//		c.put("MAX", start);
//		c.put("MIN", end);	
//		c.put("_size", pagesize);
//	
//		List<Post> Posts = (List<Post>) sqlMapClient.queryForList("selectPost", c);
//		
//		return Posts ;
//	}
//
//
//	public List<PostTitle> selectPostTitle(Date start, Date end, int pagesize)
//			throws Exception {
//		// TODO Auto-generated method stub
//		Map<String,Object> c=new HashMap<String,Object>();
//		c.put("MAX", start);
//		c.put("MIN", end);	
//		c.put("_size", pagesize);
//	
//		List<PostTitle> PostTitles = (List<PostTitle>) sqlMapClient.queryForList("selectPostTitle", c);
//		
//		return PostTitles ;
//	}
//}
