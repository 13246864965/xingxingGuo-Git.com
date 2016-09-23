package com.cn.hwyl.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hwyl.pojo.FileInfo;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFileService;
import com.google.gson.Gson;

/**
 * springmvc 下载 
 * 浏览影像文件接口
 */
@Component
@Scope("prototype")
@RequestMapping("/downloadFile")
public class DownloadController {
	private static Logger logger = Logger.getLogger(DownloadController.class);

	@RequestMapping("download")
	public void downLoad(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String fileName = request.getParameter("fileName");
		String filePath = request.getParameter("filePath");
		if (!"".equals(fileName)) {
			File file = new File(filePath);
			if (file.exists()) {
				System.out.println(fileName);
				InputStream inputStream = null;
				OutputStream outputStream = null;
				// 以流的形式下载文件
				try {
					inputStream = new BufferedInputStream(new FileInputStream(file));
					outputStream = new BufferedOutputStream(response.getOutputStream());
					// byte[] buffer = new byte[inputStream.available()];
					int count = 0;
					while (count == 0) {
						count = inputStream.available();
					}
					byte[] buffer = new byte[count];
					inputStream.read(buffer);
					inputStream.close();
					// 清空response
					response.reset();
					// 设置response的Header
					response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
					response.addHeader("Content-Length", "" + file.length());
					response.setContentType("application/octet-stream;charset=UTF-8");
					outputStream.write(buffer);
					outputStream.flush();
				} catch (Exception e) {
					logger.error("下载文件出错" + e.getMessage());
					return;
				} finally {
					inputStream.close();
					outputStream.close();
				}
				logger.info("------------->文件下载成功！！！");
			} else {
				logger.error("------------->该文件不存在！！！");
			}
		} else {
			logger.error("------------->下载文件时参数错误！！！");
		}
	}
}
