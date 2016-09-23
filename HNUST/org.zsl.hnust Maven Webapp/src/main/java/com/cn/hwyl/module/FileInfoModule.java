package com.cn.hwyl.module;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.main.HWYLWebService;
import com.cn.hwyl.main.WSDLProperties;
import com.cn.hwyl.pojo.FileInfo;
import com.cn.hwyl.pojo.FrontConfiguration;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFileService;
import com.cn.hwyl.service.IFrontConfigurationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FileInfoModule {
	private  Logger logger = Logger.getLogger(FileInfoModule.class);

	public String fileInfoAll(HeadRequest head, BodyRequest body) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IFileService fileService = (IFileService) ac.getBean("fileService");
		
		IFrontConfigurationService frontConfigurationService = (IFrontConfigurationService) ac.getBean("frontConfigurationService");
		Result result = new Result();

		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		// file查询
		if (head.getService().contains("FileInfo_Select")) {
			if (body.getFileInfoSelectBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			List<FileInfo> fileInfoList = null;
			String paramCorgid = body.getFileInfoSelectBody().getFileInfo().getcOrgId();
			try {
				FileInfo fileInfo = body.getFileInfoSelectBody().getFileInfo();
				fileInfo.setcOrgId(body.getFileInfoSelectBody().getFileInfo().getcOrgId().split(",")[0]);
				fileInfoList = fileService.selectByFile(fileInfo);
				if (fileInfoList == null || fileInfoList.size() == 0) {
					result.setErrorCode("0");
					result.setResultCode("1");
					result.setErrorInfo("文件不存在！！");
					return gson.toJson(result);
				}
				logger.info("download orgid ="+paramCorgid);
				paramCorgid ="\""+paramCorgid+"\"";
				// 调用远程端 根据该用户所在组织ID查询服务器地址
				String  resultCenter = HWYLWebService.getWSDL(WSDLProperties.getCenterWsdl(), WSDLProperties.getCenterNameSpace(),
						"provideFrontService", gson.toJson(head), "{\"cOrgId\":"+paramCorgid+"}");
				
				Result frontConfiguration = gson.fromJson(resultCenter, new TypeToken<Result>() {
				}.getType());
				String serviceAdd = "http://localhost:8080/";
				if (frontConfiguration != null) {
					serviceAdd = (String) frontConfiguration.getObj();
					serviceAdd = serviceAdd.substring(0, serviceAdd.indexOf("HWYL/"));
				}
				// 拼接downLoadUrl
				for (int i = 0; i < fileInfoList.size(); i++) {
					serviceAdd += "HWYL/downloadFile/download?filePath=" + fileInfoList.get(i).getcFilepath()
							+ "&fileName=" + fileInfoList.get(i).getcFilename() + ",";
				}
				serviceAdd = serviceAdd.substring(0,serviceAdd.length() - 1);
				//存放
				result.setResultCode("1");
				result.setObj(serviceAdd);
				
//				result.setObj(serviceAdd+"/HWYL/downloadFile/download?filePath=" + fileInfo.getcFilepath()
//				+ "&fileName=" + fileInfo.getcFilename());
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
			}
		}

		return gson.toJson(result);
	}
	public static void main(String[] args) {
		Result result = new Result();
		Gson gson = new Gson();
		List<FileInfo> fileInfoList = new ArrayList<FileInfo>();
		for (int i = 0; i < 3; i++) {
			FileInfo fileInfo =new FileInfo();
			fileInfo.setcFileforeign("----------------"+i);
			fileInfoList.add(fileInfo);
		}
		
		result.setObj(fileInfoList);
		System.out.println(gson.toJson(result));
	}
	
}
