package com.pm.dal.DAL.User;

import com.pm.pojo.User;



public interface IUserDao {

	public User addUser(User user) throws Exception;


	public boolean deleteUserById(String id)throws Exception;

	public boolean IsExsitUserByPhone(String Phone)throws Exception;

	public boolean updateUser(User user) throws Exception;


	public User selectUserByPhone(String phone)throws Exception;


	public User selectUserById(String UID)throws Exception;
	
	public User Save(User user)throws Exception;


}
