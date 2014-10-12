package com.pm.bll.interfaces;

import com.pm.pojo.RepairTicket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Ansin W.
 * 
 *
 */
public interface IRepairTicketOperation {
	
    public RepairTicket GetRepairTicketByID(String ID) throws Exception;
    public List<RepairTicket> GetRepairTicketByUserId(String uid,Date max, Date min,int pagesize) throws Exception;
    public Boolean deleteRepairTicketByID(String ID) throws Exception;
    public RepairTicket Save(RepairTicket repairticket) throws Exception;	
	
}
