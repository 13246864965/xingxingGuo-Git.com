package com.cn.hwyl.main;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import com.cn.hwyl.pojo.entity.SendMessage;

public class SendMessageMain {
	private static Logger logger = Logger.getLogger(SendMessageMain.class);

	public static String sendToPhone(SendMessage message) throws HttpException, IOException {

		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://www.stongnet.com/sdkhttp/sendsms.aspx");
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf8");// 在头文件中设置转码
		NameValuePair[] data = { 
				new NameValuePair("reg", "101100-WEB-HUAX-507457"),
				new NameValuePair("pwd", "SYMTMRUR"), 
				new NameValuePair("sourceadd", ""),
				new NameValuePair("phone", message.getPhone()), 
				new NameValuePair("content", message.getContent()) };
		post.setRequestBody(data);
		client.executeMethod(post);
		String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
		post.releaseConnection();
		logger.info("手机号为：" + message.getPhone() + "请求远程会诊成功！！");
		return result;
	}
}