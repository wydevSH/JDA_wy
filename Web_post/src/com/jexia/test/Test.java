package com.jexia.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pm.pojo.User;


public class Test {
    public static void main(String[] args) throws IOException {
        String urlStr = "http://127.0.0.1:8080/userapp/adduser";
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);    // ���Է�������
        conn.setDoInput(true);    // ���Խ�������
        conn.setRequestMethod("POST");    // POST����
        // ����ע��˴���Ҫ����UserAgent������google�᷵��403
        conn.setRequestProperty
        ("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.connect();
        //    д���POST����
        
        System.out.println("connected to server ");
        
        Gson gson = new GsonBuilder()
        .setDateFormat("yyyy-MM-dd HH:mm:ss")
        .create();

		User usr= new User();
		usr.setUPhone("5093");
		usr.setUNickname("sasa");
		usr.setUPassword("sasasa");
		usr.setURegTime(Date.valueOf("2011-09-02"));
		
		
		String str = gson.toJson(usr);

        OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
        osw.write(str);
        osw.flush();
        osw.close();
        System.out.println("send to sever ");
        // ��ȡ��Ӧ����
        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String s;
       if ((s = in.readLine()) != null)
            System.out.println(s);      


        System.out.println("recv fin");
    }
    
   
}