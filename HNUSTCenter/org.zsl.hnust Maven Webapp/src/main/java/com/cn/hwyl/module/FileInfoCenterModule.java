package com.cn.hwyl.module;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.FileInfo;
import com.cn.hwyl.pojo.FrontConfiguration;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFileService;
import com.cn.hwyl.service.IFrontConfigurationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileInfoCenterModule {
	private static Logger logger = Logger.getLogger(FileInfoCenterModule.class);

	public static String fileInfoAll(HeadRequest head, BodyRequest body) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IFileService fileService = (IFileService) ac.getBean("fileService");
		
		IFrontConfigurationService frontConfigurationService = (IFrontConfigurationService) ac.getBean("frontConfigurationService");
		Result result = new Result();

		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		// file查询
		if (head.getService().contains("FileInfo_Select")) {
			if (body.getFileInfoSelectBody() == null || "".equals(body.getFileInfoSelectBody())) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			FileInfo fileInfo = null;
			try {
				fileInfo = fileService.selectByFile(body.getFileInfoSelectBody().getFileInfo());
				if (fileInfo == null) {
					result.setErrorCode("0");
					result.setResultCode("1");
					result.setErrorInfo("文件不存在！！");
					return gson.toJson(result);
				}

				// 根据该用户所在组织ID查询服务器地址
				FrontConfiguration frontConfiguration = frontConfigurationService
						.selectByPrimaryKey(body.getFileInfoSelectBody().getFileInfo().getcOrgId());
				String serviceAdd = "localhost:8080";

				if (frontConfiguration != null) {
					serviceAdd = frontConfiguration.getcServeraddress();
				}
				// 地址动态改变，后期需优化。

				result.setResultCode("1");
				result.setObj("http://" + serviceAdd + "/HWYL/downloadFile/download?filePath=" + fileInfo.getcFilepath()
						+ "&fileName=" + fileInfo.getcFilename());
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
			}
		}

		return gson.toJson(result);
	}
	
}
