package com.cn.hwyl.main;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.ws.Endpoint;

import org.apache.log4j.Logger;


/**
 * 服务监听类 用于启动前置端webservice服务 
 * 用于当启动服务的同时启动wsdl服务。
 * @author hwyl
 *
 */
public class StartMsdlServiceMain implements ServletContextListener{
	
	private static Logger logger = Logger.getLogger(StartMsdlServiceMain.class);
	private static String localIP;
	private static String frontWsdlPort;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info(new SimpleDateFormat().format(new Date())+":StartMsdlService contextDestroyed !!");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		/**
		 * 参数1：服务的发布地址 参数2：服务的实现者
		 */
		try {
			localIP=CommonUtil.getLocalIP();
			logger.info("前置端wsdl IP             :>>>>>>>>>>>>>" + localIP);
			frontWsdlPort = WSDLProperties.getFrontWsdlPort();
			logger.info("前置端wsdl frontWsdlPort             :>>>>>>>>>>>>>" + frontWsdlPort);
			Endpoint.publish("http://"+localIP+":"+frontWsdlPort+"/api/services/CPManageWebservice", new WebServiceCP());
			logger.info(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"   成功启动wsdl服务！！！");
		} catch (Exception e) {
			logger.error(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+":StartMsdlService contextInitialized faild!!");
		}
	}
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8081/api/services/CPManageWebservice", new WebServiceCP());
		logger.info(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"   成功启动wsdl服务！！！");
	}

}
