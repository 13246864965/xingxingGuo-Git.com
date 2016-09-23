package com.cn.hwyl.module;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFrontConfigurationService;
import com.google.gson.Gson;

public class ConfigurationCenterModule {
	
	private static Logger logger = Logger.getLogger(ConfigurationCenterModule.class);
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

	public static String configurationAll(HeadRequest head, BodyRequest body) {
		
		IFrontConfigurationService frontConfigurationService = (IFrontConfigurationService) ac.getBean("frontConfigurationService");
		
		Result result = new Result();
		Gson gson = new Gson();

		// 配置信息新增或者更改
		if ("Configuration".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getConfigurationEditBody() == null || "".equals(body.getConfigurationEditBody())) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				logger.info("Configuration_Edit param{} :"
						+ body.getConfigurationEditBody().getFrontConfiguration().toString());
				/**
				 * 1,在中心端添加对应组织服务器配置信息
				 * 2,创建管理员角色，同步到前置端
				 */
				logger.info("组织分配服务器信息 beginl！！"+body.getConfigurationEditBody().getFrontConfiguration().getcOrgid());
				result = frontConfigurationService.insertOrgAndsyncFranc(body.getConfigurationEditBody().getFrontConfiguration());
				logger.info("组织分配服务器信息 successful！！"+body.getConfigurationEditBody().getFrontConfiguration().getcOrgid());
				
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
				return gson.toJson(result);
			}
			result.setResultCode("1");
			result.setErrorInfo("操作成功");
			return gson.toJson(result);
		}

		return gson.toJson(result);

	}

}
