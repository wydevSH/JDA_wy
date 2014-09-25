package com.pm.bll.beans;

import java.io.IOException;

import com.pm.bll.interfaces.IUserOperation;
import com.pm.dal.DAL.UserBase.IUserDao;
import com.pm.dal.DAL.UserBase.UserDaoImpl;
import com.pm.pojo.User;


public class UserBean implements IUserOperation {


	protected  IUserDao usrbasedao = null;

	public UserBean() throws IOException{
		this.usrbasedao=new UserDaoImpl();

	}
	
	
	public IUserDao getUsrbasedao() {
		return usrbasedao;
	}

	public void setUsrbasedao(IUserDao usrbasedao) {
		this.usrbasedao = usrbasedao;
	}


	public User GetUserByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		
		
		return usrbasedao.selectUserById(ID);
	}

	public User GetUserByPhone(String phone) throws Exception {
		// TODO Auto-generated method stub
		return usrbasedao.selectUserById(phone);
	}

	public Boolean deleteUserByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		return usrbasedao.deleteUserById(ID);
	}



	public User Save(User user) throws Exception {
		// TODO Auto-generated method stub
		return usrbasedao.Save(user);
	}











}
