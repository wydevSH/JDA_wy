package com.pm.dal.DAL.Biotope;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Calendar;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.Biotope;

public class BiotopeDaoImpl {
	
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
	
//			if(this(biotope。))
//				return null;	
//			biotope(String.valueOf(System.currentTimeMillis()));
//			sqlMapClient.insert("addBiotope", biotope);		
		
			return biotope;
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

	public boolean updateBiotope(Biotope biotope) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;

		object = sqlMapClient.update("updateBiotope", biotope);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}


	public Biotope selectBiotopeByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub
		Biotope User = null;
		
		User = (Biotope) sqlMapClient.queryForObject("selectBiotopeByPhone",phone);
		
		return User;
	}

	public Biotope selectBiotopeById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Biotope User = null;
		
		User = (Biotope) sqlMapClient.queryForObject("selectBiotopeById", id);
	
		return User;
	}

	public boolean IsExsitBiotopeByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub	
		
		Biotope user = (Biotope) sqlMapClient.queryForObject("selectBiotopeByPhone", phone);
		
		return user != null;
		
	
	}

	
	public boolean IsExsitBiotopeById(String uid) throws SQLException {
		// TODO Auto-generated method stub		
			
		return this.selectBiotopeById(uid)!=null;
	
	
		
	}
	
	
	public Biotope Save(Biotope biotope) throws Exception {
		// TODO Auto-generated method stub		
		
			
//			if(biotope.getUID()==null ||biotope.getUID().equals("")){//never add before 
//			
//			    if(biotope.getUPhone()==null || biotope.getUPhone().equals("")||this.IsExsitBiotopeByPhone(biotope.getUPhone()))//check whether add some phone
//			    	return null;
//				 biotope.setUID(String.valueOf(Calendar.getInstance().getTimeInMillis() ));
//				 return this.addBiotope(biotope);
//			}
//			else{
//				if(!this.IsExsitBiotopeById(biotope.getUID()))
//					return null;
//				  this.updateBiotope(biotope);	
//				  return biotope;
//			}
			
	     return null;

	}
}
