package com.cn.hwyl.module;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.FirstAidInfoView;
import com.cn.hwyl.pojo.FirstAidTime;
import com.cn.hwyl.pojo.FirstaidResults;
import com.cn.hwyl.pojo.body.firstAid.FirstAidTimeEditBody;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFirstAidInfoViewService;
import com.cn.hwyl.service.IFirstAidService;
import com.cn.hwyl.service.IFirstAidTimeService;
import com.cn.hwyl.service.IFirstaidResultsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FirstAidModule {

	private  Logger logger = Logger.getLogger(FirstAidModule.class);
	
	public String firstAidAll(HeadRequest head, BodyRequest body) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IFirstAidService firstAidService = (IFirstAidService) ac.getBean("firstAidService");
		IFirstaidResultsService firstaidResultsService = (IFirstaidResultsService) ac.getBean("firstaidResultsService");
		IFirstAidInfoViewService firstAidInfoViewService = (IFirstAidInfoViewService) ac.getBean("firstAidInfoViewService");
		IFirstAidTimeService firstAidTimeService = (IFirstAidTimeService) ac.getBean("firstAidTimeService");

		Result result = new Result();
		Gson gson = new GsonBuilder().serializeNulls().create();

		// 急救信息编辑
		if ("FirstAid_Edit".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getFirstAidEditBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				result = firstAidService.saveOrUpdateBody(head, body);
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
			}
			// 创建急救成功后
			result.setResultCode("1");
		}
		/**
		 * 急救档案编辑
		 */
		if("FirstAid_Results_Edit".equals(head.getService())){

			// 判断请求对象参数是否为空
			if (body.getFirstAidResultsBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				result = firstaidResultsService.saveOrUpdateResultsBody(body);
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
			}
			// 创建急救成功后
			result.setResultCode("1");
		
		}
		/**
		 * 急救审核状态  查询
		 */
		if ("FirstAid_Results_Select".equals(head.getService())) {

			// 判断请求对象参数是否为空
			if (body.getFirstAidResultsSelectBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			List<FirstaidResults> firstaidResultslists = null;
			int count = 0;
			try {
				logger.info("FirstAid_Results_Select param{} :"
						+ body.getFirstAidResultsSelectBody().getFirstaidResults().toString());
				firstaidResultslists = firstaidResultsService
						.selectByPage(body.getFirstAidResultsSelectBody().getFirstaidResults());
				count = firstaidResultsService
						.selectByPageCount(body.getFirstAidResultsSelectBody().getFirstaidResults());

			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
			}
			if (firstaidResultslists != null && count > 0) {
				result.setResultCode("1");
				result.setObj(firstaidResultslists);
				result.setRecordNum(count);
				result.setPageNum((int) Math.ceil(
						(double) count / body.getFirstAidResultsSelectBody().getFirstaidResults().getRecordNumPer()));
			}

		}
		/**
		 * 急救时间编辑firstAidTime
		 */
		if("FirstAid_FirstAidTime_Edit".equals(head.getService())){
			
			// 判断请求对象参数是否为空
			if (body.getFirstAidTimeEditBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				result = firstAidTimeService.insertBatchAndDelete(body.getFirstAidTimeEditBody().getFirstAidTimeLists());
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
			}
			// 创建急救成功后
			result.setResultCode("1");
			
		}
		//急救时间查询
		if ("FirstAid_FirstAidTime_Select".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getFirstAidTimeSelectBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			List<FirstAidTime> firstAidTimeLists = null;
			try {
				logger.info("FirstAid_FirstAidTime_Edit param is         " +body.getFirstAidTimeSelectBody().getFirstAidTime().toString());
				firstAidTimeLists = firstAidTimeService
						.selectByPrimaryByFirstAidTime(body.getFirstAidTimeSelectBody().getFirstAidTime());
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
			}
			result.setObj(firstAidTimeLists);
			result.setResultCode("1");
		}

		//急救信息查询  急救档案查询
		if (head.getService().contains("FirstAid_Select_")) {
			if (body.getFirstAidSelectBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			List<FirstAidInfoView> firstAidInfoViewlists = null;
			int count = 0;
			try {
				//急救信息查询
				if("FirstAid_Select_info".equals(head.getService())){
					logger.info("FirstAid_Select_info param{} :" + body.getFirstAidSelectBody().getFirstAidInfoView().toString());
					firstAidInfoViewlists = firstAidInfoViewService.selectFirstAidInfoViewByFirstAidID(body.getFirstAidSelectBody().getFirstAidInfoView());
					count = firstAidInfoViewService.selectFirstAidInfoViewByCount(body.getFirstAidSelectBody().getFirstAidInfoView());
				}
				//急救档案查询
				if("FirstAid_Select_history".equals(head.getService())){
					logger.info("FirstAid_Select_history param{} :" + body.getFirstAidSelectBody().getFirstAidInfoView().toString());
					firstAidInfoViewlists = firstAidInfoViewService.selectFirstAidHistoryView(body.getFirstAidSelectBody().getFirstAidInfoView());
					count = firstAidInfoViewService.selectFirstAidHistoryViewCount(body.getFirstAidSelectBody().getFirstAidInfoView());
				}
				
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
			}
			if (firstAidInfoViewlists !=null && count > 0) {
				result.setResultCode("1");
				result.setObj(firstAidInfoViewlists);
				result.setRecordNum(count);
				result.setPageNum((int) Math
						.ceil((double) count / body.getFirstAidSelectBody().getFirstAidInfoView().getRecordNumPer()));
			}
			
		}

		return gson.toJson(result);
	}
	
	public static void main(String[] args) {
		BodyRequest body = new BodyRequest();
//		FirstAidAddBody firstAidAddBody =new FirstAidAddBody();
//		FirstAid firstAid = new FirstAid();
//		firstAid.setcFirstaidid("firstAid11111111");
//		
//		FirstAidInfo firstAidInfo= new FirstAidInfo();
////		firstAidInfo.setcFirstaidinfoid("cFirstaidinfoid1111111111111111");
////		firstAidInfo.setcFirstaidid("firstAid11111111");
//		
//		Patients patients  = new Patients();
//		patients.setcPatientsid("cPatientsid1111111111");
//		firstAidAddBody.setFirstAid(firstAid);
//		firstAidAddBody.setFirstAidInfo(firstAidInfo);
//		firstAidAddBody.setPatients(patients);
//		body.setFirstAidAddBody(firstAidAddBody);
		FirstAidTimeEditBody firstAidTimeEditBody = new FirstAidTimeEditBody();
		List<FirstAidTime> firstAidTimeLists = new ArrayList<FirstAidTime> ();
		for (int i = 0; i <3; i++) {
			FirstAidTime firstAidTime = new FirstAidTime();
			firstAidTime.setcFirstaidid("cFirstaidid"+i);
			firstAidTime.setcTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			firstAidTime.setcTimetype(String.valueOf(i));
			firstAidTimeLists.add(firstAidTime);
		}
		firstAidTimeEditBody.setFirstAidTimeLists(firstAidTimeLists);
		body.setFirstAidTimeEditBody(firstAidTimeEditBody);
		System.out.println(new Gson().toJson(body));
	}

}