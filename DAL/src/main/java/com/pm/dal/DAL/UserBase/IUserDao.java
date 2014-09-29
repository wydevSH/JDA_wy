package com.pm.dal.DAL.UserBase;

import com.pm.pojo.User;



public interface IUserDao {

	public User addUser(User user) throws Exception;


	public boolean deleteUserById(String id)throws Exception;

	public boolean IsExsitUserByPhone(String Phone)throws Exception;

	public User updateUser(User user) throws Exception;


	public User selectUserByPhone(String phone)throws Exception;


	public User selectUserById(String UID)throws Exception;
	
	public User Save(User user)throws Exception;


}
