package com.pm.bll.interfaces;

import com.pm.pojo.User;




/**
 * 
 * @author jexia 
 * 
 *
 */
public interface IUserOperation {

	
	public User GetUserByID(String ID) throws Exception;
	public User GetUserByPhone(String phone) throws Exception;
	public Boolean deleteUserByID(String ID) throws Exception;
	public User Save(User user) throws Exception;
}
