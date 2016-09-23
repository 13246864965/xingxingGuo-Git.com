package com.cn.hwyl.module;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.Role;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IRoleService;
//import com.cn.hwyl.service.IroleService;
import com.google.gson.Gson;

public class RoleModule {

	private Logger logger = Logger.getLogger(RoleModule.class);

	public String roleAll(HeadRequest head, BodyRequest body) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IRoleService roleService = (IRoleService) ac.getBean("roleService");
		Gson gson = new Gson();
		Result result = new Result();
		// 角色添加
		if ("Role_Add".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getRoleAddBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				logger.info("Role_Add param{} :" + body.getRoleAddBody().getRole().toString());
				roleService.insert(body.getRoleAddBody().getRole());
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
		// 用户更新
		if ("Role_Update".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getRoleUpdateBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return result.toString();
			}
			try {
				logger.info("Role_Update param{} :" + body.getRoleUpdateBody().getRole().toString());
				roleService.updateByPrimaryKey(body.getRoleUpdateBody().getRole());
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
			}
			result.setResultCode("1");
			result.setErrorInfo("操作成功");
			return gson.toJson(result);

		}

		// 角色查询
		if ("Role_Select".equals(head.getService())) {
			if (body.getRoleSelectBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return result.toString();
			}
			if (body.getRoleSelectBody().getRole() != null) {
				logger.info("Role_Select param{} :" + body.getRoleSelectBody().getRole().toString());
				List<Role> roleLists = null;
				int count = 0;
				try {
					roleLists = roleService.selectByPage(body.getRoleSelectBody().getRole());
					count = roleService.selectByCount(body.getRoleSelectBody().getRole());
				} catch (Exception e) {
					logger.error("程序异常:" + e);
					result.setResultCode("0");
					result.setIsLogin(false);
					result.setErrorInfo("程序异常,请联系管理员！！");
				}

				if (roleLists.size() > 0 && count > 0) {
					result.setResultCode("1");
					result.setObj(roleLists);
					result.setRecordNum(count);
					result.setPageNum(
							(int) Math.ceil((double) count / body.getRoleSelectBody().getRole().getRecordNumPer()));
				}
			}

		}
		
		if ("Role_Delete".equals(head.getService())) {
			if (body.getRoleDeleteBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return result.toString();
			}
			try {
				logger.info("Role_Delete param{} :" + body.getRoleDeleteBody().getcRoleid().toString());
				roleService.deleteByPrimaryKey(body.getRoleDeleteBody().getcRoleid().toString());
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
