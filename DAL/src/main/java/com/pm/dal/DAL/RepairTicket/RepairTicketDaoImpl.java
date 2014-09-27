package com.pm.dal.DAL.RepairTicket;

import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.pojo.Complaint;
import com.pm.pojo.RepairTicket;

public class RepairTicketDaoImpl implements IRepairTicketDao{

	
	private static  SqlMapClient sqlMapClient = null;

	public  RepairTicketDaoImpl() throws IOException
	{
		if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/dal/DAL/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
		
		
	}
	
	
	public RepairTicket addRepairTicket(RepairTicket repairticket)
			throws Exception {
	
		repairticket.setRepairTicketID(String.valueOf(System.currentTimeMillis()));
		sqlMapClient.insert("addRepairTicket", repairticket);		
	
		return repairticket;
	}

	public boolean deleteRepairTicketById(String id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;
		
		object = sqlMapClient.delete("deleteRepairTicketById", id);
		
		if (object != 0) {
			flag = true;

		}
		return flag;
	}

	public RepairTicket updateRepairTicket(RepairTicket repairticket)
			throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		int object = 0;

		object = sqlMapClient.update("updateRepairTicket", repairticket);
		
		if (object != 0) {
			return repairticket;

		}
		return null;
	}

	public List<RepairTicket> GetRepairTicketByUserId(String uid,
			Date time_start, int s, int offset) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> c=new HashMap<String,Object>();
		c.put("time_update", time_start);
		c.put("user_id", uid);
		c.put("_start", s);
		c.put("_size", offset);
	
		List<RepairTicket> repairtickets = (List<RepairTicket>) sqlMapClient.queryForList("selectRepairTicket", c);
		
		return repairtickets ;
	}

	public RepairTicket GetRepairTicketById(String rid) throws Exception {
		// TODO Auto-generated method stub
		RepairTicket repairTicket = null;
		
		repairTicket = (RepairTicket) sqlMapClient.queryForObject("selectRepairTicketById", rid);
	
		return repairTicket;
	}

	public RepairTicket Save(RepairTicket repairticket) throws Exception {
		// TODO Auto-generated method stub
		if(repairticket.getRepairTicketID()==null ||repairticket.getRepairTicketID().equals("")){//never add before 			
			 
			repairticket.setRepairTicketID((String.valueOf(Calendar.getInstance().getTimeInMillis() )));
			return this.addRepairTicket(repairticket);
		}
		else{
			if(!this.IsExsitRepairTicketById(repairticket.getRepairTicketID())){//this is wrong!
				return null;
			}
			RepairTicket srepairticket = this.updateRepairTicket(repairticket);	
			return srepairticket;
		}
	}


	private boolean IsExsitRepairTicketById(String repairTicketID) throws Exception {
		// TODO Auto-generated method stub
		return this.GetRepairTicketById(repairTicketID) != null;
	}

}
