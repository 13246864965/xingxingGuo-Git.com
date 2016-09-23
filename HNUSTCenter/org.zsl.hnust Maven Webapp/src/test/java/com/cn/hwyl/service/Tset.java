package com.cn.hwyl.service;

import java.util.HashMap;
import java.util.Map;

import com.cn.hwyl.pojo.Channel;
import com.cn.hwyl.pojo.HospitalServiceCenter;
import com.cn.hwyl.pojo.Organization;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Tset {
	public static void main(String[] args) throws Exception {
		
		System.out.println(Tset.hexString2String("00 FF F0 00 60 00 00 00 00 00 00 00 00 00 01 XX  FF"));
//		Gson gson = new Gson();
//		Organization or = new Organization();
//		or.setCity("1234");
//		or.setCountry("1324");
//		Channel ch = new Channel();
//		ch.setChannelCode("aaaaaaaaaaaa");
//		ch.setChannelType("bbbbbbbbbbbbbb");
//		HospitalServiceCenter ho = new HospitalServiceCenter();
//		ho.setRoleId("roleId");
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("or", or);
//		map.put("ch", ch);
//		map.put("ho", ho);
//		System.out.println(gson.toJson(map));
//		Map<String,Object> map1 = gson.fromJson(gson.toJson(map), new TypeToken<Map<String,Object>>() {
//		}.getType());
//		
//		Channel ch1 = gson.fromJson(gson.toJson(map1.get("ch")), new TypeToken<Channel>() {
//		}.getType());
//		System.out.println(ch1.getChannelCode());
		
		
//		ArrayList set = new ArrayList();
//		set.add(ho);
//		set.add(or);
//		set.add(ch);
//		System.out.println(gson.toJson(set));
//		ArrayList map1 = gson.fromJson(gson.toJson(set), new TypeToken<ArrayList>() {
//			}.getType());
//		
//		System.out.println(map1.get(0));
	}
	public static String hexString2String(String src) {  
        String temp = "";  
        for (int i = 0; i < src.length() / 2; i++) {  
            temp = temp  
                    + (char) Integer.valueOf(src.substring(i * 2, i * 2 + 2),  
                            16).byteValue();  
        }  
        return temp;  
    }  
	
}
