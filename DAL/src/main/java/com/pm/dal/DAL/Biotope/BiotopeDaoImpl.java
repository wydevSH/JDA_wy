package com.pm.dal.DAL.Biotope;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Calendar;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.Biotope;

public class BiotopeDaoImpl implements IBiotopeDao{
	
	private static  SqlMapClient sqlMapClient = null;
	
	
	
	
	public  BiotopeDaoImpl() throws IOException
	{
		if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
		
	}
	
	
	public Biotope addBiotope(Biotope biotope) throws Exception {
		// TODO Auto-generated method stub
	
		boolean flag = false;
		int object = 0;

		object = sqlMapClient.update("addBiotope", biotope);
		
		if (object != 0) {
			return biotope;

		}
		return null;
			
	}

	public boolean deleteBiotopeById(String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;
		
		object = sqlMapClient.delete("deleteBiotopeById", id);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}

	public Biotope updateBiotope(Biotope biotope) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;

		object = sqlMapClient.update("updateBiotope", biotope);
		
		if (object != 0) {
			return biotope;

		}
		return null;
	}


	public Biotope selectBiotopeByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		Biotope bitope = null;
		
		bitope = (Biotope) sqlMapClient.queryForObject("selectBiotopeByName",name);
		
		return bitope;
	}

	public Biotope selectBiotopeById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Biotope bitope = null;
		
		bitope = (Biotope) sqlMapClient.queryForObject("selectBiotopeById", id);
	
		return bitope;
	}

	public boolean IsExsitBiotopeByName(String name) throws SQLException {
		// TODO Auto-generated method stub	
		
		Biotope bitope = (Biotope) sqlMapClient.queryForObject("selectBiotopeByName", name);
		
		return bitope != null;
		
	
	}

	
	public boolean IsExsitBiotopeById(String uid) throws SQLException {
		// TODO Auto-generated method stub		
			
		return this.selectBiotopeById(uid)!=null;
	
	
		
	}
	
	
	public Biotope Save(Biotope biotope) throws Exception {
		// TODO Auto-generated method stub			
		
		if(biotope.getBiotopeID()==null ||biotope.getBiotopeID().equals("")){
			if(biotope.getBBiotopeName()== null ||biotope.getBAddress().equals(""))
				return null;
			if(biotope.getBAddress()== null ||biotope.getBAddress().equals("") )
				return null;
			return this.addBiotope(biotope);
			
		}
		else{
			if(!this.IsExsitBiotopeById(biotope.getBiotopeID()))
				return null;
				
			return this.updateBiotope(biotope);
			
			
		}

	}
}
