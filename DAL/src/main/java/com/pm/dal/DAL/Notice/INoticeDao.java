package com.pm.dal.DAL.Notice;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.pm.pojo.Notice;

public interface INoticeDao {
	
	public Notice addNotice(Notice notice) throws Exception;

	public boolean deleteNoticeById(String id)throws Exception;

	public Notice updateNotice(Notice notice) throws Exception;

	public Notice selectNoticeByID(String UID)throws Exception;
	
	public List<Notice> selectNotice(Date max, Date min,int pagesize) throws Exception;
	
    public List<Notice> selectNoticeByBiotopeID(String biotopeID, Date max, Date min, int pagesize)throws Exception;
	
	public boolean IsExsitNoticeById(String uid) throws Exception;
	
	public Notice Save(Notice notice)throws Exception;

}
