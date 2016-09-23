package com.cn.hwyl.module;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.Organization;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IOrganizationService;
import com.cn.hwyl.service.IRoleService;
import com.google.gson.Gson;

public class OrganizeModule {

	private Logger logger = Logger.getLogger(OrganizeModule.class);

	public String organizeAll(HeadRequest head, BodyRequest body) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IOrganizationService organizationService = (IOrganizationService) ac.getBean("organizationService");

		IRoleService roleService = (IRoleService) ac.getBean("roleService");

		Result result = new Result();
		Gson gson = new Gson();
		// 机构添加
		if ("Organize_Add".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getOrganizeAddBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			int organizeAdd = 0;
			int roleAdd = 0;
			try {
				// 判断机构信息是否为空
				if (body.getOrganizeAddBody().getOrganization() != null) {
					logger.info("Organize_Add-- Organization param{} :"
							+ body.getOrganizeAddBody().getOrganization().toString());
					organizeAdd = organizationService.insert(body.getOrganizeAddBody().getOrganization());
				}

				if (body.getOrganizeAddBody().getRole() != null) {
					logger.info("Organize_Add-- Role param{} :" + body.getOrganizeAddBody().getRole().toString());
					roleAdd = roleService.insert(body.getOrganizeAddBody().getRole());
				}
				if (organizeAdd > 0 && roleAdd > 0) {
					result.setResultCode("1");
					result.setErrorInfo("操作成功");
				}
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setIsLogin(false);
				result.setErrorInfo("程序异常,请联系管理员！！");
			}

		}
		// 机构信息更新
		if ("Organize_Update".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getOrganizeUpdateBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				if (body.getOrganizeUpdateBody().getOrganization() != null) {
					logger.info("Organize_Update-- Organization param{} :"
							+ body.getOrganizeUpdateBody().getOrganization().toString());
					organizationService.updateByPrimaryKey(body.getOrganizeUpdateBody().getOrganization());
				}
				result.setResultCode("1");
				result.setErrorInfo("操作成功");
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setIsLogin(false);
				result.setErrorInfo("程序异常,请联系管理员！！");
			}

		}
		// 机构查询
		if ("Organize_Select".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getOrganizeSelectBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			if (body.getOrganizeSelectBody().getOrganization() != null) {
				logger.info("Organize_Select-- Organization param{} :"
						+ body.getOrganizeSelectBody().getOrganization().toString());
				List<Organization> orgaLists = null;
				int count = 0;
				try {
					orgaLists = organizationService.selectByPage(body.getOrganizeSelectBody().getOrganization());
					count = organizationService.selectByCount(body.getOrganizeSelectBody().getOrganization());
				} catch (Exception e) {
					logger.error("程序异常:" + e);
					result.setResultCode("0");
					result.setErrorInfo("程序异常,请联系管理员！！");
				}

				if (orgaLists.size() > 0 && count > 0) {
					result.setResultCode("1");
					result.setObj(orgaLists);
					result.setRecordNum(count);
					result.setPageNum((int) Math
							.ceil((double) count / body.getOrganizeSelectBody().getOrganization().getRecordNumPer()));
				}
			}

		}

		if ("Organize_Delete".equals(head.getService())) {
			if (body.getOrganizeDeleteBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return result.toString();
			}
			try {
				logger.info("Organize_Delete param{} :" + body.getOrganizeDeleteBody().getOrgId().toString());
				organizationService.deleteByPrimaryKey(body.getOrganizeDeleteBody().getOrgId().toString());
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！" + e.getMessage());
			}
			result.setResultCode("1");
			result.setErrorInfo("操作成功");
			return gson.toJson(result);
		}

		return gson.toJson(result);
	}

}
