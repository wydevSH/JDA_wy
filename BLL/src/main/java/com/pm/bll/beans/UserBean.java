package com.pm.bll.beans;

import java.io.IOException;

import com.pm.bll.interfaces.IUserOperation;
import com.pm.dal.DAL.User.IUserDao;
import com.pm.dal.DAL.User.UserDaoImpl;
import com.pm.pojo.User;


public class UserBean implements IUserOperation {


	protected  IUserDao userdao = null;

	public UserBean() throws IOException{
		this.userdao=new UserDaoImpl();

	}
	
	
	public IUserDao getUserbasedao() {
		return userdao;
	}

	public void setUserdao(IUserDao userdao) {
		this.userdao = userdao;
	}


	public User GetUserByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		
		
		return userdao.selectUserById(ID);
	}

	public User GetUserByPhone(String phone) throws Exception {
		// TODO Auto-generated method stub
		return userdao.selectUserByPhone(phone);
	}

	public Boolean deleteUserByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		return userdao.deleteUserById(ID);
	}



	public User Save(User user) throws Exception {
		// TODO Auto-generated method stub
		return userdao.Save(user);
	}











}
