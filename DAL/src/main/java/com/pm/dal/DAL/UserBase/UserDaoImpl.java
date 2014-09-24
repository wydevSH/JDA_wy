package com.pm.dal.DAL.UserBase;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Calendar;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.User;

public class UserDaoImpl implements IUserDao{

	private static  SqlMapClient sqlMapClient = null;
	
	
	
	
	public  UserDaoImpl() throws IOException
	{
		if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
		
	}
	
	
	public User addUser(User user) throws Exception {
		// TODO Auto-generated method stub
	
			if(this.IsExsitUserByPhone(user.getUPhone()))
				return null;	
			user.setUID(String.valueOf(System.currentTimeMillis()));
			sqlMapClient.insert("addUser", user);		
		
			return user;
	}

	public boolean deleteUserById(String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;
		
		object = sqlMapClient.delete("deleteUserById", id);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}

	public boolean updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;

		object = sqlMapClient.update("updateUser", user);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}


	public User selectUserByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub
		User User = null;
		
		User = (User) sqlMapClient.queryForObject("selectUserByPhone",phone);
		
		return User;
	}

	public User selectUserById(String id) throws SQLException {
		// TODO Auto-generated method stub
		User User = null;
		
		User = (User) sqlMapClient.queryForObject("selectUserById", id);
	
		return User;
	}

	public boolean IsExsitUserByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub	
		
		User user = (User) sqlMapClient.queryForObject("selectUserByPhone", phone);
		
		return user != null;
		
	
	}

	
	public boolean IsExsitUserById(String uid) throws SQLException {
		// TODO Auto-generated method stub		
			
		return this.selectUserById(uid)!=null;
	
	
		
	}
	
	
	public User Save(User user) throws Exception {
		// TODO Auto-generated method stub		
		
			
			if(user.getUID()==null ||user.getUID().equals("")){//never add before 
			
			    if(user.getUPhone()==null || user.getUPhone().equals("")||this.IsExsitUserByPhone(user.getUPhone()))//check whether add some phone
			    	return null;
				 user.setUID(String.valueOf(Calendar.getInstance().getTimeInMillis() ));
				 return this.addUser(user);
			}
			else{
				if(!this.IsExsitUserById(user.getUID()))
					return null;
				  this.updateUser(user);	
				  return user;
			}
			
	
	}


		
		
		
	



}
