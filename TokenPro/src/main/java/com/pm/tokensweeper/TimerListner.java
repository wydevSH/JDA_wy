package com.pm.tokensweeper;

import java.io.IOException;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class TimerListner implements ServletContextListener {
    
    private Timer timer;

    public void contextDestroyed(ServletContextEvent event) {
        if (timer != null) {
            timer.cancel();
            event.getServletContext().log("timer destroyed");
        }
    }

    public void contextInitialized(ServletContextEvent event) {
        timer = new Timer(true);
        event.getServletContext().log("timer started ");
        try {
			timer.schedule(new JobTimer(event.getServletContext()), 0, 4000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
        event.getServletContext().log("Task added ");
    }

}
