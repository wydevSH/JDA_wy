package com.pm.bll.interfaces;

import java.util.List;
import java.util.Date;

import com.pm.pojo.Notice;




/**
 * 
 * @author jexia 
 * 
 *
 */
public interface INoticeOperation {

	
	public Notice GetNoticeByID(String ID) throws Exception;
	public List<Notice> GetNoticeByBiotopeID (String biotope, Date max, Date min,int pagesize) throws Exception;
	public Boolean deleteNoticeByID(String ID) throws Exception;
	public Notice Save(Notice Notice) throws Exception;
}
