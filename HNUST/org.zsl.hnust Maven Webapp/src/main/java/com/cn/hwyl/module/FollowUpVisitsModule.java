package com.cn.hwyl.module;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.FollowUpVisits;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFollowUpVisitsService;
import com.google.gson.Gson;
/**
 * 患者随访
 * @author hw01
 *
 */
public class FollowUpVisitsModule {

	private Logger logger = Logger.getLogger(FollowUpVisitsModule.class);

	public String followUpVisitsAll(HeadRequest head, BodyRequest body) {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IFollowUpVisitsService followUpVisitsService = (IFollowUpVisitsService) ac.getBean("followUpVisitsService");
		Gson gson = new Gson();
		Result result = new Result();
		if ("FollowUpVisits_Edit".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getFollowUpVisitsEditBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				logger.info("FollowUpVisits_Edit param{} :"
						+ body.getFollowUpVisitsEditBody().getFollowUpVisits().toString());
				if (body.getFollowUpVisitsEditBody().getFollowUpVisits() != null) {
					followUpVisitsService.saveOrUpdate(body.getFollowUpVisitsEditBody().getFollowUpVisits());
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
		if ("FollowUpVisits_Delete".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getFollowUpVisitsDeleteBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				logger.info("FollowUpVisits_Delete param{} :"
						+ body.getFollowUpVisitsDeleteBody().getcVisitsid().toString());
				//删除之前应在备份表里备份
				followUpVisitsService.deleteByPrimaryKey(body.getFollowUpVisitsDeleteBody().getcVisitsid());
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！" + e.getMessage());
				return gson.toJson(result);
			}

		}
		
		if ("FollowUpVisits_Select".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getFollowUpVisitsSelectBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			List<FollowUpVisits> followUpVisitsLists = null;
			int count = 0;
			try {
				followUpVisitsLists = followUpVisitsService
						.selectByPage(body.getFollowUpVisitsSelectBody().getFollowUpVisits());
				count = followUpVisitsService.selectByPageCount(body.getFollowUpVisitsSelectBody().getFollowUpVisits());
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！" + e.getMessage());
				return gson.toJson(result);

			}
			if (followUpVisitsLists.size() > 0 && count > 0) {
				result.setResultCode("1");
				result.setObj(followUpVisitsLists);
				result.setRecordNum(count);
				result.setPageNum((int) Math.ceil(
						(double) count / body.getFollowUpVisitsSelectBody().getFollowUpVisits().getRecordNumPer()));
			}
		}
		return gson.toJson(result);
	}
	
}
