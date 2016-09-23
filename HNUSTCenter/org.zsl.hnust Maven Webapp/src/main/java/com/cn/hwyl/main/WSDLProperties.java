package com.cn.hwyl.main;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class WSDLProperties {
	private static String yunWsdl;
	private static String yunNameSpace;
	static {

		ResourceBundle rs = PropertyResourceBundle.getBundle("wsdl");
		yunWsdl = rs.getString("yun_wsdl");
		yunNameSpace = rs.getString("yun_nameSpace");
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
}
