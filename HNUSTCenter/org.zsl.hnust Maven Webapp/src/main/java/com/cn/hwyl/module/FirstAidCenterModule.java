package com.cn.hwyl.module;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.FirstAid;
import com.cn.hwyl.pojo.FirstAidInfo;
import com.cn.hwyl.pojo.FirstAidInfoView;
import com.cn.hwyl.pojo.Patients;
import com.cn.hwyl.pojo.body.firstAid.FirstAidAddBody;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFirstAidInfoViewService;
import com.cn.hwyl.service.IFirstAidService;
import com.google.gson.Gson;

public class FirstAidCenterModule {

	private  Logger logger = Logger.getLogger(FirstAidCenterModule.class);
	
	public String firstAidAll(HeadRequest head, BodyRequest body) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IFirstAidService firstAidService = (IFirstAidService) ac.getBean("firstAidService");
		IFirstAidInfoViewService firstAidInfoViewService = (IFirstAidInfoViewService) ac.getBean("firstAidInfoViewService");

		Result result = new Result();
		Gson gson = new Gson();

		// 急救信息编辑
		if ("FirstAid_Edit".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getFirstAidEditBody() == null || "".equals(body.getFirstAidEditBody())) {
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

		//急救信息查询
		if ("FirstAid_Select".equals(head.getService())) {
			if (body.getFirstAidSelectBody() == null || "".equals(body.getFirstAidSelectBody())) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			List<FirstAidInfoView> firstAidInfoViewlists = null;
			int count = 0;
			try {
				logger.info("FirstAid_Select param{} :" + body.getFirstAidSelectBody().getFirstAidInfoView().toString());
				firstAidInfoViewlists = firstAidInfoViewService.selectFirstAidInfoViewByFirstAidID(body.getFirstAidSelectBody().getFirstAidInfoView());
				count = firstAidInfoViewService.selectFirstAidInfoViewByCount(body.getFirstAidSelectBody().getFirstAidInfoView());
				
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
			}
			if (firstAidInfoViewlists.size() > 0 && count > 0) {
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
		FirstAidAddBody firstAidAddBody =new FirstAidAddBody();
		FirstAid firstAid = new FirstAid();
		firstAid.setcFirstaidid("firstAid11111111");
		
		FirstAidInfo firstAidInfo= new FirstAidInfo();
		firstAidInfo.setcFirstaidinfoid("cFirstaidinfoid1111111111111111");
		firstAidInfo.setcFirstaidid("firstAid11111111");
		
		Patients patients  = new Patients();
		patients.setcPatientsid("cPatientsid1111111111");
		firstAidAddBody.setFirstAid(firstAid);
		firstAidAddBody.setFirstAidInfo(firstAidInfo);
		firstAidAddBody.setPatients(patients);
		body.setFirstAidAddBody(firstAidAddBody);
		System.out.println(new Gson().toJson(body));
	}

}