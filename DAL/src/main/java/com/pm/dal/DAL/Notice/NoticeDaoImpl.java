package com.pm.dal.DAL.Notice;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
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
			
		    if(notice.getNoticeID() == null ||notice.getNoticeID().equals("")){
		    	
		    	notice.setNoticeID(String.valueOf(System.currentTimeMillis()));
				sqlMapClient.insert("addNotice", notice);		
		
				return notice;
		    }
		    
		    return null;
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

	public List<Notice> selectNotice(Date time_start, int s,int offset) throws SQLException {
		// TODO Auto-generated method stub
		List<Notice> notices = null;
		Map<String,Object> c=new HashMap<String,Object>();
		c.put("time_pub", time_start);
		c.put("_start", s);
		c.put("_size", offset);
		notices = (List<Notice>) sqlMapClient.queryForList("selectNotice", c);
		

		return notices;
	}
	
	public boolean IsExsitNoticeById(String uid) throws SQLException {
		// TODO Auto-generated method stub		
			
		return this.selectNoticeByID(uid)!=null;
	
	
		
	}
	
	
	public Notice Save(Notice notice) throws Exception {
		
		if(notice.getNoticeID()==null ||notice.getNoticeID().equals(""))
		{			
			if(notice.getNPoster()==null ||notice.getNPoster().equals("") )
				return null;
			
			notice.setNoticeID((String.valueOf(Calendar.getInstance().getTimeInMillis() )));
			return this.addNotice(notice);			
		}
		
		if(IsExsitNoticeById(notice.getNoticeID())){
			return this.updateNotice(notice);
		}
		
		return null;
	
	}






}
