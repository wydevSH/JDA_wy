package com.pm.dal.DAL.Property;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.Property;

public class PropertyDaoImpl {

	private static  SqlMapClient sqlMapClient = null;
	
	
	
	
	public  PropertyDaoImpl() throws IOException
	{
		if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
		
	}
	
	
	public Property addProperty(Property property) throws Exception {
		// TODO Auto-generated method stub
	
			if(this.IsExsitPropertyByPhone(property.getUPhone()))
				return null;	
			property.setUID(String.valueOf(System.currentTimeMillis()));
			sqlMapClient.insert("addProperty", property);		
		
			return property;
	}

	public boolean deletePropertyById(String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;
		
		object = sqlMapClient.delete("deletePropertyById", id);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}

	public boolean updateProperty(Property property) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;

		object = sqlMapClient.update("updateProperty", property);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}


	public Property selectPropertyByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub
		Property property = null;
		
		property = (Property) sqlMapClient.queryForObject("selectPropertyByPhone",phone);
		
		return property;
	}

	public Property selectPropertyById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Property User = null;
		
		User = (Property) sqlMapClient.queryForObject("selectPropertyById", id);
	
		return User;
	}

	public boolean IsExsitPropertyByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub	
		
		Property user = (Property) sqlMapClient.queryForObject("selectPropertyByPhone", phone);
		
		return user != null;
		
	
	}

	
	public boolean IsExsitPropertyById(String uid) throws SQLException {
		// TODO Auto-generated method stub		
			
		return this.selectPropertyById(uid)!=null;
	
	
		
	}
	
	
	public Property Save(Property property) throws Exception {
		
		
		
		return property;
	
	}
}
