package com.pm.dal.DAL.Notice;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.Notice;

public class NoticeDaoImpl implements INoticeDao{

	private static  SqlMapClient sqlMapClient = null;
	
	
	
	
	public  NoticeDaoImpl() throws IOException
	{
		if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
		
	}
	
	
	public Notice addNotice(Notice notice) throws Exception {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addNotice", notice);
		return selectNoticeByID(notice.getNoticeID());
	}

	public boolean deleteNoticeById(String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;
		
		object = sqlMapClient.delete("deleteNoticeById", id);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}

	public Notice updateNotice(Notice notice) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;

		object = sqlMapClient.update("updateNotice", notice);
		
		if (object != 0) {
			return notice;

		}
		return null;
	}



	public Notice selectNoticeByID(String id) throws SQLException {
		// TODO Auto-generated method stub
		Notice notice = null;
		
		notice = (Notice) sqlMapClient.queryForObject("selectNoticeById", id);
	
		return notice;
	}
	

	public List<Notice> selectNotice(Date max, Date min, int pagesize)
			throws Exception {
		List<Notice> notices = null;
		Map<String,Object> c=new HashMap<String,Object>();
		c.put("max", max);
		c.put("min", min);
		c.put("_size", pagesize);
		notices = (List<Notice>) sqlMapClient.queryForList("selectNotice", c);
		

		return notices;
	}


	public List<Notice> selectNoticeByBiotopeID(String biotopeID, Date max,
			Date min, int pagesize) throws Exception {
		// TODO Auto-generated method stub
		List<Notice> notices = null;
		Map<String,Object> c=new HashMap<String,Object>();
		c.put("biotopeID", biotopeID);
		c.put("max", max);
		c.put("min", min);
		c.put("_size", pagesize);
		notices = (List<Notice>) sqlMapClient.queryForList("selectNoticeByBiotopeID", c);
		

		return notices;
	}
	
		
	public boolean IsExsitNoticeById(String uid) throws SQLException {
		// TODO Auto-generated method stub		
			
		return this.selectNoticeByID(uid)!=null;
	
	
		
	}
	
	
	public Notice Save(Notice notice) throws Exception {
		
	if(notice.getNoticeID()==null || notice.getNoticeID().equals("")){
		
	    if(notice.getNBiotopeID()==null || notice.getNBiotopeID().equals(""))
	    	return null;
		 notice.setNoticeID(String.valueOf(Calendar.getInstance().getTimeInMillis()));
		 System.out.print("===NoticeDaoImpl.java : save()===");
		 System.out.print(notice.getNoticeID());
		 return this.addNotice(notice);
	}
	else{
		if(IsExsitNoticeById(notice.getNoticeID()))
			System.out.print(notice.getNoticeID());
			return this.updateNotice(notice);
		    
	    }

    }

}
