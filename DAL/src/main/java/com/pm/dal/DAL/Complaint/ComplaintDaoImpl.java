package com.pm.dal.DAL.Complaint;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.Complaint;

public class ComplaintDaoImpl implements IComplaintDao {

	private static  SqlMapClient sqlMapClient = null;
	
	
	
	
	public  ComplaintDaoImpl() throws IOException
	{
		if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
		
	}
	
	
	public Complaint addComplaint(Complaint complaint) throws Exception {
		// TODO Auto-generated method stub
	
			if(this.IsExsitComplaintById(complaint.getComplaintID()))
				return null;	
			complaint.setComplaintID(String.valueOf(System.currentTimeMillis()));
			sqlMapClient.insert("addComplaint", complaint);		
		
			return complaint;
	}

	public boolean deleteComplaintById(String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;
		
		object = sqlMapClient.delete("deleteComplaintById", id);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}

	public Complaint updateComplaint(Complaint complaint) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;

		object = sqlMapClient.update("updateComplaint", complaint);
		
		if (object != 0) {
			return complaint;

		}
		return null;
	}




	public Complaint GetComplaintById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Complaint complaint = null;
		
		complaint = (Complaint) sqlMapClient.queryForObject("selectComplaintById", id);
	
		return complaint;
	}
	


	

	public List<Complaint> GetComplaintByUserId(String uid,Date time_start,int s,int offset) throws SQLException {
		// TODO Auto-generated method stub	
		
		Map<String,Object> c=new HashMap<String,Object>();
		c.put("time_update", time_start);
		c.put("user_id", uid);
		c.put("_start", s);
		c.put("_size", offset);
	
		List<Complaint> complaints = (List<Complaint>) sqlMapClient.queryForList("selectComplaint", c);
		
		return complaints ;
		
	
	}
	public boolean IsExsitComplaintById(String uid) throws SQLException {
		// TODO Auto-generated method stub		
			
		return this.GetComplaintById(uid)!=null;
	
	
		
	}
	
	
	public Complaint Save(Complaint complaint) throws Exception {
		// TODO Auto-generated method stub		
		
			
			if(complaint.getComplaintID()==null ||complaint.getComplaintID().equals("")){//never add before 			
			 
				 complaint.setComplaintID((String.valueOf(Calendar.getInstance().getTimeInMillis() )));
				 return this.addComplaint(complaint);
			}
			else{
				if(!this.IsExsitComplaintById(complaint.getComplaintID())){//this is wrong!
					return null;
				}
				
				 return this.updateComplaint(complaint);
			}
			
	

	}





}
