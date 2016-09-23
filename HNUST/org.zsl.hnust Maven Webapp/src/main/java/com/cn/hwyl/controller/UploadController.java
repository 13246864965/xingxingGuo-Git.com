package com.cn.hwyl.controller;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hwyl.pojo.FileInfo;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFileService;
import com.google.gson.Gson;

/**
 * 上传影像文件接口
 * 
 * @author hw01
 *
 */
@Controller
@RequestMapping("/file")
public class UploadController {

	private static Logger logger = Logger.getLogger(UploadController.class);
	@SuppressWarnings("unused")
	private String saveFileInfo(HttpServletRequest request, HttpServletResponse response,String filePath,String fileName) {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IFileService fileService = (IFileService) ac.getBean("fileService");
		FileInfo fileinfo = new FileInfo();
		Result result = new Result();
		Gson gson = new Gson();

		String fileSize = request.getHeader("fileSize");
		String fileType = request.getHeader("fileType");
		String fileforeign = request.getHeader("fileforeign");
		String type = request.getHeader("type");
		String fileImg = request.getHeader("fileImg");
		String imageType = request.getHeader("imageType");

		fileinfo.setcFileid(UUID.randomUUID().toString());
		fileinfo.setcFilename(fileName);
		fileinfo.setcFilepath(filePath);
		fileinfo.setcFilesize(fileSize);
		fileinfo.setcFiletype(fileType);
		fileinfo.setcFileforeign(fileforeign);
		fileinfo.setcFileImg(fileImg);
		fileinfo.setcImageType(imageType);
		fileinfo.setcType(type);
		fileinfo.setcUpdateTime(new Date());
		logger.info("fileinfo-------------"+fileinfo);
		try {
			//保存心电图
			if("0".equals(type)){
				fileService.saveOrUpdate(fileinfo);
			}
			//保存映像
			if("1".equals(type)){
				fileService.insert(fileinfo);
			}
			result.setResultCode("1");
			result.setErrorInfo("上传成功！！");
		} catch (Exception e) {
			result.setResultCode("0");
			result.setErrorInfo("保存文件出错！！");
			logger.error("保存文件出错！！" + e.getMessage());
		}

		return gson.toJson(result);
	}

	@RequestMapping("/upload")
	public void upload(HttpServletRequest request, HttpServletResponse response) {
		logger.info(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "upload");
		String result = "";
		try {
//			String range = request.getHeader("Range").replace("bytes=", "");// 上传范围格式
//			String[] arr = range.split("\\-");
//			int s1 = Integer.parseInt(arr[0]);
			InputStream in = request.getInputStream();
			String fileName = new Date().getTime() + request.getHeader("fileName");
			
			String filePath = "/root/hwyl/file/ECG/"+fileName;
			if("0".equals(request.getHeader("type"))){
				filePath = "/root/hwyl/file/ECG/"+fileName;
			}
			if("1".equals(request.getHeader("type"))){
				filePath = "/root/hwyl/file/IMAGE/"+fileName;
			}
			
			if(System.getProperty("os.name").toLowerCase().startsWith("win")){  
			  filePath = "C:\\Users\\hw01\\Desktop\\" + fileName;
			} 
			
			RandomAccessFile fout = new RandomAccessFile(filePath, "rws");
//			fout.seek(s1);
			byte[] bytes = new byte[128 * 1024];
			int length = in.read(bytes);
			while (length != -1) {
				fout.write(bytes, 0, length);
				length = in.read(bytes);
			}
			in.close();
			fout.close();

			// 保存本地之后入库
			result = saveFileInfo(request, response, filePath,fileName);
			logger.info(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "upload successful!!!");
		} catch (Exception e) {
			logger.error("上传出错！！" + e.getMessage());
		}
		response.addHeader("resultCode", result);
		response.addHeader("ErrorCode", "0");
		response.addHeader("ErrorMessage", "上传成功！！");

	}

}
