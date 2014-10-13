package com.pm.tokensweeper;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.TimerTask;
 






import javax.servlet.ServletContext;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class JobTimer extends TimerTask {
    private ServletContext servletContext;
    private static boolean isRunning = false;
	private static  SqlMapClient sqlMapClient = null;
	
    public JobTimer(ServletContext servletContext) throws IOException {
        this.servletContext = servletContext;
        
    	if(sqlMapClient ==null){
			Reader reader = Resources.getResourceAsReader("com/pm/conf/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}
        
        
    }

    @Override
    public void run() {
        if (!isRunning) {
            isRunning = true;
            servletContext.log("Task started");
            servletContext.log("   ---->" + System.currentTimeMillis());
           
            try {
  
              Date curtime =new Date();
              
              this.sqlMapClient.update("updateExpire",curtime);
            	
            	
            	
            } catch (Exception e) {
                servletContext.log("Task exception "+e.toString());
            }
            isRunning = false;
            servletContext.log("Task end");
        } else {
            servletContext.log("still have task to run ");
        }
    }

}
