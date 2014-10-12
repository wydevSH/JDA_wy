package com.pm.bll.beans;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.pm.bll.interfaces.INoticeOperation;
import com.pm.dal.DAL.Notice.INoticeDao;
import com.pm.dal.DAL.Notice.NoticeDaoImpl;
import com.pm.pojo.Notice;


public class NoticeBean implements INoticeOperation {


	protected  INoticeDao noticedao = null;

	public NoticeBean() throws IOException{
		this.noticedao=new NoticeDaoImpl();

	}
	
	
	public INoticeDao getnoticedao() {
		return noticedao;
	}

	public void setNoticedao(INoticeDao noticedao) {
		this.noticedao = noticedao;
	}


	public Notice GetNoticeByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		
		
		return noticedao.selectNoticeByID(ID);
	}

	public List<Notice> GetNoticeByBiotopeID(String biotope, Date max, Date min,int pagesize) throws Exception {
		// TODO Auto-generated method stub
		return noticedao.selectNoticeByBiotopeID(biotope, max, min, pagesize);
	}

	public Boolean deleteNoticeByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		return noticedao.deleteNoticeById(ID);
	}



	public Notice Save(Notice notice) throws Exception {
		// TODO Auto-generated method stub
		return noticedao.Save(notice);
	}











}
