package com.cn.hwyl.module;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.FirstaidTask;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFirstaidTaskService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 急救任务
 * @author hw01
 *
 */
public class FirstAidTaskModule {

	private  Logger logger = Logger.getLogger(FirstAidTaskModule.class);
	
	public String firstAidTaskAll(HeadRequest head, BodyRequest body) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IFirstaidTaskService firstaidTaskService = (IFirstaidTaskService) ac.getBean("firstaidTaskService");

		Result result = new Result();
		Gson gson = new GsonBuilder().serializeNulls().create();
		
		if ("FirstaidTask_Edit".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getFirstAidTaskEditBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				logger.info("FirstaidTask_Edit param{} :"
						+ body.getFirstAidTaskEditBody().getFirstaidTask().toString());
				if (body.getFirstAidTaskEditBody().getFirstaidTask() != null) {
					firstaidTaskService.insert(body.getFirstAidTaskEditBody().getFirstaidTask());
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
		if ("FirstaidTask_Delete".equals(head.getService())) {
			if (body.getFirstAidTaskDeleteBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				logger.info("FirstaidTask_Delete param{} :" + body.getFirstAidTaskDeleteBody().getcTaskid().toString());
				if (body.getFirstAidTaskDeleteBody().getcTaskid() != null
						&& !"".equals(body.getFirstAidTaskDeleteBody().getcTaskid())) {
					firstaidTaskService.deleteByPrimaryKey(body.getFirstAidTaskDeleteBody().getcTaskid());
				}
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！" + e.getMessage());
				return gson.toJson(result);
			}
		}
		if ("FirstaidTask_Select".equals(head.getService())) {
			if (body.getFirstAidTaskSelectBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			List<FirstaidTask> firstaidTaskLists = null;
			int count = 0;
			try {
				// 分页查询
				firstaidTaskLists = firstaidTaskService
						.selectByPage(body.getFirstAidTaskSelectBody().getFirstaidTask());
				count = firstaidTaskService.selectByPageCount(body.getFirstAidTaskSelectBody().getFirstaidTask());
			} catch (Exception e) {

				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！" + e.getMessage());
				return gson.toJson(result);

			}
			if (firstaidTaskLists.size() > 0 && count > 0) {
				result.setResultCode("1");
				result.setObj(firstaidTaskLists);
				result.setRecordNum(count);
				result.setPageNum((int) Math
						.ceil((double) count / body.getFirstAidTaskSelectBody().getFirstaidTask().getRecordNumPer()));
			}
		}
		
		return gson.toJson(result);
	}
}