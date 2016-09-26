package com.cn.hwyl.main;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class WSDLProperties {
	/**
	 * 云平台wsdl地址
	 */
	private static String yunWsdl;
	/**
	 * 云平台namespace
	 */
	private static String yunNameSpace;
	/**
	 * 中心端wsdl地址
	 */
	private static String centerWsdl;
	/**
	 * 中心端namespace
	 */
	private static String centerNameSpace;
	/**
	 * 前置端wsdl 端口
	 */
	private static String frontWsdlPort;
	/**
	 * 前置端会诊端口
	 */
	private static String frontDoctorPort;
	/**
	 * 前置端刷卡端口
	 */
	private static String frontCardPort;
	static {

		ResourceBundle rs = PropertyResourceBundle.getBundle("wsdl");
		yunWsdl = rs.getString("yun_wsdl");
		yunNameSpace = rs.getString("yun_nameSpace");
		centerWsdl = rs.getString("center_wsdl");
		centerNameSpace = rs.getString("center_nameSpace");
		
		frontWsdlPort = rs.getString("front_wsdlPort");
		frontDoctorPort = rs.getString("front_doctorPort");
		frontCardPort = rs.getString("front_cardPort");
	}

	public static String getYunWsdl() {
		return yunWsdl;
	}

	public static void setYunWsdl(String yunWsdl) {
		WSDLProperties.yunWsdl = yunWsdl;
	}

	public static String getYunNameSpace() {
		return yunNameSpace;
	}

	public static void setYunNameSpace(String yunNameSpace) {
		WSDLProperties.yunNameSpace = yunNameSpace;
	}

	public static String getCenterWsdl() {
		return centerWsdl;
	}

	public static void setCenterWsdl(String centerWsdl) {
		WSDLProperties.centerWsdl = centerWsdl;
	}

	public static String getCenterNameSpace() {
		return centerNameSpace;
	}

	public static void setCenterNameSpace(String centerNameSpace) {
		WSDLProperties.centerNameSpace = centerNameSpace;
	}

	public static String getFrontWsdlPort() {
		return frontWsdlPort;
	}

	public static void setFrontWsdlPort(String frontWsdlPort) {
		WSDLProperties.frontWsdlPort = frontWsdlPort;
	}

	public static String getFrontDoctorPort() {
		return frontDoctorPort;
	}

	public static void setFrontDoctorPort(String frontDoctorPort) {
		WSDLProperties.frontDoctorPort = frontDoctorPort;
	}

	public static String getFrontCardPort() {
		return frontCardPort;
	}

	public static void setFrontCardPort(String frontCardPort) {
		WSDLProperties.frontCardPort = frontCardPort;
	}

	
	
}
