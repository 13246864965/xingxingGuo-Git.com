package com.cn.hwyl.main;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class WSDLProperties {
	private static String yunWsdl;
	private static String yunNameSpace;
	private static String centerWsdl;
	private static String centerNameSpace;
	static {

		ResourceBundle rs = PropertyResourceBundle.getBundle("wsdl");
		yunWsdl = rs.getString("yun_wsdl");
		yunNameSpace = rs.getString("yun_nameSpace");
		centerWsdl = rs.getString("center_wsdl");
		centerNameSpace = rs.getString("center_nameSpace");
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
	
	
}
