package com.pm.dal.DAL.RepairTicket;

import java.util.Date;
import java.util.List;

import com.pm.pojo.RepairTicket;

public interface IRepairTicketDao {
	
	
	public RepairTicket addRepairTicket(RepairTicket repairticket) throws Exception;

	public boolean IsExsitRepairTicketById(String repairTicketID) throws Exception;

	public boolean deleteRepairTicketById(String id)throws Exception;

	
	public RepairTicket updateRepairTicket(RepairTicket repairticket) throws Exception;

	public List<RepairTicket> GetRepairTicketByUserId(String uid,Date max, Date min,int pagesize) throws Exception;
	
	public RepairTicket selectRepairTicketById(String uid)throws Exception;
	
	public RepairTicket Save(RepairTicket repairticket)throws Exception;

}
