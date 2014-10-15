package com.pm.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pm.bll.beans.ComplaintBean;
import com.pm.bll.beans.NoticeBean;
import com.pm.bll.beans.UserBean;
import com.pm.bll.beans.RepairTicketBean;
import com.pm.bll.interfaces.IUserOperation;
import com.pm.bll.interfaces.INoticeOperation;
import com.pm.bll.interfaces.IRepairTicketOperation;
import com.pm.bll.interfaces.IComplaintOperation;
import com.pm.pojo.User;
import com.pm.pojo.Notice;
import com.pm.pojo.RepairTicket;
import com.pm.pojo.Complaint;



public class TestServlet extends HttpServlet{

    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter(); 
		out.write("hehe");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			   throws ServletException, IOException { 
		
		Map<String,Object> ret=new HashMap<String,Object>();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		System.out.println("INTO POST");
		try{
		
			String url =request.getRequestURL().toString();
			String MethodName = url.substring(url.lastIndexOf("/")+1);//get method name 
		 
			int len = request.getContentLength(); 
			System.out.println("got request len is "+ String.valueOf(len));
			InputStream is = request.getInputStream(); 

			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8")); 
			String buffer = null; 
			StringBuffer requestBody = new StringBuffer(); 
			while ((buffer = br.readLine()) != null) { 
				requestBody.append(buffer);
			}      
	    
			
			if(MethodName.equalsIgnoreCase("adduser"))
			{
				IUserOperation oper_user =new UserBean();
				System.out.println("in the method ["+MethodName+"]");
				ret.put("MethodName", MethodName);
				User user=gson.fromJson(requestBody.toString(), User.class);
				user = oper_user.Save(user);
				ret.put("retVal", user);
				ret.put("status",Long.valueOf(0));
			}
			
			
			else if(MethodName.equalsIgnoreCase("existsuser"))
			{
				IUserOperation oper_user =new UserBean();
				ret.put("MethodName", MethodName);
				String phone=gson.fromJson(requestBody.toString(), String.class);
				User user=oper_user.GetUserByPhone(phone);
			
				ret.put("retVal", user);
				ret.put("status",Long.valueOf(0));
			}
			
			
			else if(MethodName.equalsIgnoreCase("addnotice"))
			{
				INoticeOperation oper_notice =new NoticeBean();
				System.out.println("in the method ["+MethodName+"]");
				ret.put("MethodName", MethodName);
				Notice notice=gson.fromJson(requestBody.toString(), Notice.class);
				notice = oper_notice.Save(notice);
				ret.put("retVal", notice);
				ret.put("status",Long.valueOf(0));			 
			}
			
			
			else if(MethodName.equalsIgnoreCase("existnotice"))
			{
				INoticeOperation oper_notice =new NoticeBean();
				ret.put("MethodName", MethodName);
				String noticeid=gson.fromJson(requestBody.toString(), String.class);
				Notice notice=oper_notice.GetNoticeByID(noticeid);			
				ret.put("retVal", notice);
				ret.put("status",Long.valueOf(0));
			}	
			
			
			else if(MethodName.equalsIgnoreCase("addrepairticket"))
			{
				IRepairTicketOperation oper_rt =new RepairTicketBean();
				System.out.println("in the method ["+MethodName+"]");
				ret.put("MethodName", MethodName);
				RepairTicket repairticket=gson.fromJson(requestBody.toString(), RepairTicket.class);
				repairticket = oper_rt.Save(repairticket);
				ret.put("retVal", repairticket);
				ret.put("status",Long.valueOf(0));			 
			}
			
			
			else if(MethodName.equalsIgnoreCase("existrepairticket"))
			{
				IRepairTicketOperation oper_rt =new RepairTicketBean();
				ret.put("MethodName", MethodName);
				String repairticketid=gson.fromJson(requestBody.toString(), String.class);
				RepairTicket repairticket=oper_rt.GetRepairTicketByID(repairticketid);			
				ret.put("retVal", repairticket);
				ret.put("status",Long.valueOf(0));
			}	
			
			
			else if(MethodName.equalsIgnoreCase("addcomplaint"))
			{
				IComplaintOperation oper_complaint =new ComplaintBean();
				System.out.println("in the method ["+MethodName+"]");
				ret.put("MethodName", MethodName);
				Complaint complaint=gson.fromJson(requestBody.toString(), Complaint.class);
				complaint = oper_complaint.Save(complaint);
				ret.put("retVal", complaint);
				ret.put("status",Long.valueOf(0));			 
			}
			
			
			else if(MethodName.equalsIgnoreCase("existcomplaint"))
			{
				IComplaintOperation oper_complaint =new ComplaintBean();
				ret.put("MethodName", MethodName);
				String complaintid=gson.fromJson(requestBody.toString(), String.class);
				Complaint complaint=oper_complaint.GetComplaintByID(complaintid);		
				ret.put("retVal", complaint);
				ret.put("status",Long.valueOf(0));
			}	
		

		} catch(Exception e){
		
			
			ret.put("status",Long.valueOf(-1));
			ret.put("errormsg", e.getMessage());
			System.out.println("error is "+ e.getMessage());
		}
	
		PrintWriter out = response.getWriter(); 
		String retstr=gson.toJson(ret);
		out.write(retstr); 
		out.flush(); 
		out.close(); 
		System.out.println("send fin ");
		
}
	
}
