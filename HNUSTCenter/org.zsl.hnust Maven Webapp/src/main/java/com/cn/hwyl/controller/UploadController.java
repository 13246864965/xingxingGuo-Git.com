package com.cn.hwyl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

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

//	// @RequestMapping("/upload")
//	public String addUser(@RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request) {
//
//		for (int i = 0; i < files.length; i++) {
//			System.out.println("fileName---------->" + files[i].getOriginalFilename());
//
//			if (!files[i].isEmpty()) {
//				int pre = (int) System.currentTimeMillis();
//				try {
//					// 拿到输出流，同时重命名上传的文件
//					FileOutputStream os = new FileOutputStream(
//							"C:\\Users\\hw01\\Desktop\\" + new Date().getTime() + files[i].getOriginalFilename());
//					// 拿到上传文件的输入流
//					// FileInputStream in =
//					// (FileInputStream)files[i].getInputStream();
//
//					MultipartFile file = files[i];
//					CommonsMultipartFile cf = (CommonsMultipartFile) file;
//					DiskFileItem fi = (DiskFileItem) cf.getFileItem();
//					File f = fi.getStoreLocation();
//					FileInputStream in = new FileInputStream(f);
//					// 以写字节的方式写文件
//					int b = 0;
//					while ((b = in.read()) != -1) {
//						os.write(b);
//					}
//					os.flush();
//					os.close();
//					in.close();
//					int finaltime = (int) System.currentTimeMillis();
//					System.out.println(finaltime - pre);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//					System.out.println("上传出错");
//				}
//			}
//		}
//		return "/success";
//	}
//
//	@RequestMapping("/upload2")
//	public String upload2(HttpServletRequest request, HttpServletResponse response)
//			throws IllegalStateException, IOException {
//
//		@SuppressWarnings("resource")
//		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
//
//		IFileService fileService = (IFileService) ac.getBean("fileService");
//		FileInfo fileinfo = new FileInfo();
//		Result result = new Result();
//		Gson gson = new Gson();
//
//		String cFileforeign = request.getParameter("cFileforeign");
//		// 创建一个通用的多部分解析器
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
//				request.getSession().getServletContext());
//		// 判断 request 是否有文件上传,即多部分请求
//		if (multipartResolver.isMultipart(request)) {
//			// 转换成多部分request
//			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//			// 取得request中的所有文件名
//			Iterator<String> iter = multiRequest.getFileNames();
//			try {
//				while (iter.hasNext()) {
//					// 取得上传文件
//					MultipartFile file = multiRequest.getFile(iter.next());
//					if (file != null) {
//						// 取得当前上传文件的文件名称
//						String myFileName = file.getOriginalFilename();
//						// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
//						if (myFileName.trim() != "") {
//							// 重命名上传后的文件名
//							String fileName = new Date().getTime() + file.getOriginalFilename();
//							// 定义上传路径
//							String filePath = "C:\\Users\\hw01\\Desktop\\" + new Date().getTime() + fileName;
//							File localFile = new File(filePath);
//							file.transferTo(localFile);
//
//							// 上传成功后，保存记录到数据库
//							fileinfo.setcFileid(UUID.randomUUID().toString());
//							fileinfo.setcFilename(myFileName);
//							fileinfo.setcFilepath(filePath);
//							fileinfo.setcFilesize(Long.toString(file.getSize()));
//							fileinfo.setcFiletype(file.getContentType());
//							fileinfo.setcFileforeign(cFileforeign);
//							fileService.insert(fileinfo);
//
//						}
//					}
//				}
//			} catch (Exception e) {
//				logger.error("上传文件失败！！" + e.getMessage());
//				result.setResultCode("0");
//				result.setErrorInfo("上传文件失败！！");
//				return gson.toJson(result);
//			}
//
//		}
//		return "/success";
//	}
//
//	@RequestMapping("/toUpload")
//	public String toUpload() {
//
//		return "/upload";
//	}
//	
//	
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

		fileinfo.setcFileid(UUID.randomUUID().toString());
		fileinfo.setcFilename(fileName);
		fileinfo.setcFilepath(filePath);
		fileinfo.setcFilesize(fileSize);
		fileinfo.setcFiletype(fileType);
		fileinfo.setcFileforeign(fileforeign);
		try {
			fileService.saveOrUpdate(fileinfo);
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
			String range = request.getHeader("Range").replace("bytes=", "");// 上传范围格式
			String[] arr = range.split("\\-");
			int s1 = Integer.parseInt(arr[0]);
			InputStream in = request.getInputStream();
//			String fileName = request.getHeader("fileforeign") + request.getHeader("fileName");
			String fileName = new Date().getTime() + request.getHeader("fileName");
			String filePath = "C:\\Users\\hw01\\Desktop\\" + fileName;
			RandomAccessFile fout = new RandomAccessFile(filePath, "rws");
			fout.seek(s1);
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
		} catch (Exception e) {
			logger.error("上传出错！！" + e.getMessage());
		}
		response.addHeader("resultCode", result);
		response.addHeader("ErrorCode", "0");
		response.addHeader("ErrorMessage", "上传成功！！");
		logger.info(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "upload successful!!!");

	}

}
