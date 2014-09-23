package com.pm.dal.DAL.Property;

import com.pm.pojo.Property;

public interface IPropertyDao {

	public Property addProperty(Property property) throws Exception;


	public boolean deletePropertyById(String id)throws Exception;

	public boolean IsExsitPropertyByName(String Phone)throws Exception;

	public boolean updateProperty(Property property) throws Exception;


	public Property selectPropertyById(String UID)throws Exception;
	
	public Property Save(Property property)throws Exception;
}
