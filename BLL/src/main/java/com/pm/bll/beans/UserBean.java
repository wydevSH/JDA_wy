package com.pm.bll.beans;

import java.io.IOException;

import com.pm.bll.interfaces.IUserBaseOperation;
import com.pm.dal.DAL.UserBase.IUserBaseDao;
import com.pm.dal.DAL.UserBase.UserBaseDaoImpl;
import com.pm.pojo.UserBase;


public class UserBean implements IUserBaseOperation {


	protected  IUserBaseDao usrbasedao = null;

	public UserBean() throws IOException{
		this.usrbasedao=new UserBaseDaoImpl();

	}
	
	
	public IUserBaseDao getUsrbasedao() {
		return usrbasedao;
	}

	public void setUsrbasedao(IUserBaseDao usrbasedao) {
		this.usrbasedao = usrbasedao;
	}


	public UserBase GetUserByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		
		
		return usrbasedao.selectUserBaseById(ID);
	}

	public UserBase GetUserByPhone(String phone) throws Exception {
		// TODO Auto-generated method stub
		return usrbasedao.selectUserBaseByPhone(phone);
	}

	public Boolean deleteUserByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		return usrbasedao.deleteUserBaseById(ID);
	}



	public UserBase Save(UserBase user) throws Exception {
		// TODO Auto-generated method stub
		return usrbasedao.Save(user);
	}











}
