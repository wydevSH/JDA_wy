package com.pm.web;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pm.pojo.User;

public class gsonMapTest {

	@Test
	public void test() {

		User user=new User();
		user.setUID("12234");
		user.setUNickname("sasa");
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("j1", null);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String str=gson.toJson(m);
		System.out.println(str);
		 m = gson.fromJson(str, new TypeToken<Map<String,Object>>(){}.getType());
		System.out.println(m.get("j1"));
//      User u1=gson.fromJson(m.get("j1").toString(),User.class);
//		System.out.println(u1.getUID());
		
		
		String url= "/web/adduserbase";
		System.out.println(url.substring(url.lastIndexOf("/")+1));
		
		
	}

}
