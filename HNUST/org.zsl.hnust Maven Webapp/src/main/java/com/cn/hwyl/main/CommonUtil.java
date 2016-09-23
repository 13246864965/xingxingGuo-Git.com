package com.cn.hwyl.main;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.log4j.Logger;

import com.cn.hwyl.pojo.Patients;
import com.cn.hwyl.pojo.entity.WardshipViewObject;

public class CommonUtil {

	private static Logger logger = Logger.getLogger(CommonUtil.class);

	private static final String key = "hljw2016";

	// 解密数据
	public static String MD5Decodedecrypt(String message) throws Exception {

		byte digest[] = new byte[message.length() / 2];
		for (int i = 0; i < digest.length; i++) {
			String byteString = message.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}
		byte[] bytesrc = digest;

		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

		byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte);
	}

	// 加密数据
	public static String MD5EncodeEncrypt(String message) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

		byte[] b = cipher.doFinal(message.getBytes("UTF-8"));

		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String plainText = Integer.toHexString(0xff & b[i]);
			if (plainText.length() < 2)
				plainText = "0" + plainText;
			hexString.append(plainText);
		}
		return hexString.toString();

	}

	public static WardshipViewObject getWardshipViewObjectByPatients(Patients patients) {
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
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String value = "111111";
		String jiami = java.net.URLEncoder.encode(value, "utf-8").toLowerCase();

		System.out.println("加密数据:" + jiami);
		String a = MD5EncodeEncrypt(jiami).toUpperCase();

		System.out.println("加密后的数据为:" + a);
		String b = java.net.URLDecoder.decode(MD5Decodedecrypt(a), "utf-8");
		System.out.println("解密后的数据:" + b);

	}
}
