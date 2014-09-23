package com.pm.dal.DAL.Pfee;

import com.pm.pojo.Pfee;

public interface IPfeeDao {

	public Pfee addPfee(Pfee pfee) throws Exception;


	public boolean deletePfeeById(String id)throws Exception;

	public boolean IsExsitPfeeByName(String Phone)throws Exception;

	public boolean updatePfee(Pfee pfee) throws Exception;


	public Pfee selectPfeeById(String UID)throws Exception;
	
	public Pfee Save(Pfee pfee)throws Exception;
}
