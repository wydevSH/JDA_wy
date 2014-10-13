package com.pm.tokengen;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Date;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.pm.md5.MD5Util;
import com.pm.token.pojo.Token;

public class TokenGenerator {
	
private static  SqlMapClient sqlMapClient = null;
	
    public TokenGenerator() throws IOException {

    	if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/conf/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
        
        
    }

    
    public String Genarate(String[] strs) throws SQLException
    {
    	StringBuilder sb= new  StringBuilder();
		for(String str:strs){
			
			sb.append(str);
			
		}
    	
    	String ret = MD5Util.MD5(sb.toString());
    	
    	Token t=new Token();
    	
    	 t.setPhone(strs[0]);
    	 t.setToken( MD5Util.MD5(ret));
    	 t.setExpiretime(new Date());
    	
    	 this.sqlMapClient.insert("addToken",t );
    	
    	  
    	return ret;
    	
    	
    	
    	
    	
    }




}
