package com.pm.dal.DAL.Notice;

import java.util.Date;
import java.util.List;

import com.pm.pojo.Notice;

public interface INoticeDao {
	
	public Notice addNotice(Notice notice) throws Exception;


	public boolean deleteNoticeById(String id)throws Exception;

	public Notice updateNotice(Notice notice) throws Exception;

	public Notice GetNoticeByID(String UID)throws Exception;
	public List<Notice> GetNotice(Date time_start, int s,int offset) throws Exception;
	
	public Notice Save(Notice notice)throws Exception;

}
