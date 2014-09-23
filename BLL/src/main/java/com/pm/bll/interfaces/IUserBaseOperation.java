package com.pm.bll.interfaces;

import com.pm.pojo.UserBase;




/**
 * 
 * @author jexia 
 * 
 *
 */
public interface IUserBaseOperation {

	
	public UserBase GetUserByID(String ID) throws Exception;
	public UserBase GetUserByPhone(String phone) throws Exception;
	public Boolean deleteUserByID(String ID) throws Exception;
	public UserBase Save(UserBase user) throws Exception;
}
