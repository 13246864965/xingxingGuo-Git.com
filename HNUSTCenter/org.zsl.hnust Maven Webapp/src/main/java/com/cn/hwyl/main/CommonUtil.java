package com.cn.hwyl.main;

import java.security.MessageDigest;

import org.apache.log4j.Logger;

import com.cn.hwyl.pojo.Patients;
import com.cn.hwyl.pojo.entity.WardshipViewObject;

public class CommonUtil {
		/** 
		 * 采用MD5加密
	     * MD5加密 生成32位md5码
	     * @param 待加密字符串
	     * @return 返回32位md5码
	     */
	
	private static Logger logger = Logger.getLogger(CommonUtil.class);
	    public static String md5Encode(String inStr) throws Exception {
	        MessageDigest md5 = null;
	        try {
	            md5 = MessageDigest.getInstance("MD5");
	        } catch (Exception e) {
	        	logger.error(e.getMessage());
	            return "";
	        }

	        byte[] byteArray = inStr.getBytes("UTF-8");
	        byte[] md5Bytes = md5.digest(byteArray);
	        StringBuffer hexValue = new StringBuffer();
	        for (int i = 0; i < md5Bytes.length; i++) {
	            int val = ((int) md5Bytes[i]) & 0xff;
	            if (val < 16) {
	                hexValue.append("0");
	            }
	            hexValue.append(Integer.toHexString(val));
	        }
	        return hexValue.toString();
	    }

	    
	    public static WardshipViewObject getWardshipViewObjectByPatients(Patients patients){
	    	WardshipViewObject wsvo = new WardshipViewObject();
	    	wsvo.setWardshipId(patients.getcFirstaidid());
	    	wsvo.setUserName(patients.getcPatientsname());
	    	wsvo.setSex(patients.getcPatientssex());
	    	wsvo.setYear(patients.getcPatientsage().toString());
	    	wsvo.setRelationPhone(patients.getcPatientsphonenumber());
	    	wsvo.setUrgentMan(patients.getcPatientsemergencycontact());
	    	wsvo.setUrgentManPhone(patients.getcPatientsemergencyphonenumber());
	    	wsvo.setCertNo(patients.getcIDNmber());
			return wsvo;
	    }
	    /**
	     * 测试主函数
	     * @param args
	     * @throws Exception
	     */
	    public static void main(String args[]) throws Exception {
	        String str = new String("123456");
	        System.out.println("原始：" + str);
	        System.out.println("MD5后：" + md5Encode(str));
	    }
	}


