package com.pm.bll.interfaces;

import java.util.ArrayList;
import com.pm.pojo.Notice;




/**
 * 
 * @author jexia 
 * 
 *
 */
public interface INoticeOperation {

	
	public Notice GetNoticeByID(String ID) throws Exception;
	public ArrayList<Notice> GetNoticeByBiotopeID (String biotope) throws Exception;
	public Boolean deleteNoticeByID(String ID) throws Exception;
	public Notice Save(Notice Notice) throws Exception;
}
