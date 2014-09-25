package com.pm.dal.DAL.Pfee;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Calendar;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.Pfee;

public class PfeeDaoImpl implements IPfeeDao {

	private static  SqlMapClient sqlMapClient = null;
	
	
	
	
	public  PfeeDaoImpl() throws IOException
	{
		if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
		
	}
	
	
	public Pfee addPfee(Pfee pfee) throws Exception {
		// TODO Auto-generated method stub

			boolean flag = false;
			int object = 0;
			pfee.setPMFeeID(String.valueOf(System.currentTimeMillis()));
			object =(Integer)sqlMapClient.insert("addPfee", pfee);
		
			if (object != 0) {
				
				return pfee;
			}
		
			return null;
	}

	public boolean deletePfeeById(String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;
		
		object = sqlMapClient.delete("deletePfeeById", id);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}

	public Pfee updatePfee(Pfee pfee) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;

		object = sqlMapClient.update("updatePfee", pfee);
		
		if (object != 0) {
			return pfee;

		}
		return null;
	}


	public Pfee selectPfeeByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub
		Pfee pfee = null;
		
		pfee = (Pfee) sqlMapClient.queryForObject("selectPfeeByPhone",phone);
		
		return pfee;
	}

	public Pfee selectPfeeById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Pfee User = null;
		
		User = (Pfee) sqlMapClient.queryForObject("selectPfeeById", id);
	
		return User;
	}

	public boolean IsExsitPfeeByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub	
		
		Pfee user = (Pfee) sqlMapClient.queryForObject("selectPfeeByPhone", phone);
		
		return user != null;
		
	
	}

	
	public boolean IsExsitPfeeById(String uid) throws SQLException {
		// TODO Auto-generated method stub		
			
		return this.selectPfeeById(uid)!=null;
	
	
		
	}
	
	
	public Pfee Save(Pfee pfee) throws Exception {
		
		if(pfee.getPMFeeID()==null ||pfee.getPMFeeID().equals(""))
		{			
			if(pfee.getFComments()==null ||pfee.getFComments().equals("") )
				return null;
			
			pfee.setPMFeeID((String.valueOf(Calendar.getInstance().getTimeInMillis() )));
			return this.addPfee(pfee);			
		}
		
		if(IsExsitPfeeById(pfee.getPMFeeID())){
			return this.updatePfee(pfee);
		}
		
		
		return pfee;
	
	}








	
	
}
