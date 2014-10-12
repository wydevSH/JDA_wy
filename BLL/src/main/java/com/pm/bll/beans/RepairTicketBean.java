package com.pm.bll.beans;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import com.pm.bll.interfaces.IRepairTicketOperation;
import com.pm.dal.DAL.RepairTicket.IRepairTicketDao;
import com.pm.dal.DAL.RepairTicket.RepairTicketDaoImpl;
import com.pm.pojo.RepairTicket;


public class RepairTicketBean implements IRepairTicketOperation {


	protected  IRepairTicketDao repairticketdao = null;
	
	public RepairTicketBean() throws IOException{
		this.repairticketdao=new RepairTicketDaoImpl();

	}

	public IRepairTicketDao getRepairTicketdao() {
		return repairticketdao;
	}

	public void setRepairTicketdao(IRepairTicketDao repairTicketDao) {
		this.repairticketdao = repairTicketDao;
	}


	public RepairTicket GetRepairTicketByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		
		return repairticketdao.selectRepairTicketById(ID);
	}

	public Boolean deleteRepairTicketByID(String ID) throws Exception {
		// TODO Auto-generated method stub
		return repairticketdao.deleteRepairTicketById(ID);
	}


	public RepairTicket Save(RepairTicket repairticket) throws Exception {
		// TODO Auto-generated method stub
		System.out.print("======RepairTicketBean.java=========");
		return repairticketdao.Save(repairticket);
	}

	public List<RepairTicket> GetRepairTicketByUserId(String uid,
			Date time_start, int s, int offset) throws Exception {
		// TODO Auto-generated method stub
		return repairticketdao.GetRepairTicketByUserId(uid, time_start, s, offset);
	}	

}
