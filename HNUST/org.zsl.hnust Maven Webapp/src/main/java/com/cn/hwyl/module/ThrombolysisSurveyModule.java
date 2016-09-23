package com.cn.hwyl.module;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.ThrombolysisSurvey;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IThrombolysisSurveyService;
import com.google.gson.Gson;

/**
 * 溶栓模块
 * @author hw01
 *
 */
public class ThrombolysisSurveyModule {

	private Logger logger = Logger.getLogger(ThrombolysisSurveyModule.class);

	public String thrombolysisSurveyAll(HeadRequest head, BodyRequest body) {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IThrombolysisSurveyService thrombolysisSurveyService = (IThrombolysisSurveyService) ac
				.getBean("thrombolysisSurveyService");
		Gson gson = new Gson();
		Result result = new Result();
		// 溶栓添加
		if ("ThrombolysisSurvey_Add".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getThrombolysisSurveyBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				for (int i = 0; i < body.getThrombolysisSurveyBody().getThrombolysisSurveyLists().size(); i++) {
					logger.info("ThrombolysisSurvey_Edit param{} :"
							+ body.getThrombolysisSurveyBody().getThrombolysisSurveyLists().get(i).toString());
				}

				if (body.getThrombolysisSurveyBody().getThrombolysisSurveyLists() != null) {
					thrombolysisSurveyService
							.insertBatch(body.getThrombolysisSurveyBody().getThrombolysisSurveyLists());
				}
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！" + e.getMessage());
				return gson.toJson(result);
			}
			result.setResultCode("1");
			result.setErrorInfo("操作成功");
			return gson.toJson(result);

		}

		if("ThrombolysisSurvey_Select".equals(head.getService())){
			// 判断请求对象参数是否为空
			if (body.getThrombolysisSurveyBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			List<ThrombolysisSurvey> thrombolysisSurveyLists =null;
			try {
				logger.info("ThrombolysisSurvey_Select param{} :"
						+ body.getThrombolysisSurveyBody().getcFirstaidid().toString());
				if (body.getThrombolysisSurveyBody().getcFirstaidid() != null
						&& !"".equals(body.getThrombolysisSurveyBody().getcFirstaidid())) {
					thrombolysisSurveyLists = thrombolysisSurveyService.selectByPrimaryFirstAidID(body.getThrombolysisSurveyBody().getcFirstaidid());
				}
				result.setObj(thrombolysisSurveyLists);
				result.setResultCode("1");
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！" + e.getMessage());
			}
		
		}
		return gson.toJson(result);
	}

}
