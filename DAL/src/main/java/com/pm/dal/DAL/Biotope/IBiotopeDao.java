package com.pm.dal.DAL.Biotope;

import com.pm.pojo.Biotope;

public interface IBiotopeDao {

	public Biotope addBiotope(Biotope biotope) throws Exception;


	public boolean deleteBiotopeById(String id)throws Exception;

	public boolean IsExsitBiotopeByName(String name)throws Exception;

	public Biotope updateBiotope(Biotope biotope) throws Exception;


	public Biotope selectBiotopeById(String BID)throws Exception;
	
	public Biotope Save(Biotope biotope)throws Exception;
}
