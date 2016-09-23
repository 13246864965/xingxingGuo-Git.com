package com.cn.hwyl.module;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.main.HWYLWebService;
import com.cn.hwyl.main.WSDLProperties;
import com.cn.hwyl.pojo.User;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IUserRoleService;
import com.cn.hwyl.service.IUserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserModule {

	private  Logger logger = Logger.getLogger(UserModule.class);

	public  String userAll(HeadRequest head, BodyRequest body) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IUserService userService = (IUserService) ac.getBean("userService");
		IUserRoleService userRoleService = (IUserRoleService) ac.getBean("userRoleService");
		Gson gson = new Gson();

		Result result = new Result();
		String password = body.getUserLoginBody().getcUserpwd();
		// 用户登录
		if ("User_Login".equals(head.getService())) {
			logger.info("User_Login param{} :" + body.getUserLoginBody().toString());
			User user = userService.selectByCusername(body.getUserLoginBody().getcUsername());
			if (user == null) {
				result.setResultCode("0");
				result.setErrorInfo(body.getUserLoginBody().getcUsername() + "用户不存在！！");
				return gson.toJson(result);
			}
			try {
				if (!user.getcUserpwd().equals(password)) {
					result.setResultCode("0");
					result.setIsLogin(false);
					result.setErrorInfo("用户密码不对,请重新输入！！");
					return gson.toJson(result);
				}
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！" + e.getMessage());
				return gson.toJson(result);
			}
			result.setResultCode("1");
			result.setObj(user);
			result.setIsLogin(true);
		}

		// 用户添加/更新
		if ("User_Edit".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getUserEditBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				// 创建用户同步到中心端
				head.setService("synchronousDataByUserEdit");
				Result centerResult = getCnterSynchronization(head, body);
				if ("0".equals(centerResult.getResultCode())) {
					return gson.toJson(centerResult);
				}
				logger.info("User_Edit param{} :" + body.getUserEditBody().getUser().toString());
				userService.saveOrUpdate(body.getUserEditBody().getUser());
				if (body.getUserEditBody().getUserRole() != null) {
					userRoleService.insert(body.getUserEditBody().getUserRole());
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
		// 用户删除
		if ("User_Delete".equals(head.getService())) {
			if (body.getUserDeleteBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return result.toString();
			}
			try {
//				// 先删除中心端用户
				head.setService("synchronousDataByUserDelete");
				Result centerResult = getCnterSynchronization(head, body);
				if ("0".equals(centerResult.getResultCode())) {
					return gson.toJson(centerResult);
				}

				logger.info("User_Delete param{} :" + body.getUserDeleteBody().getcUserid().toString());
				userService.deleteByPrimaryKey(body.getUserDeleteBody().getcUserid().toString());
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！" + e.getMessage());
			}
				result.setResultCode("1");
				result.setErrorInfo("操作成功");
				return gson.toJson(result);

		}
		// 用户查询
		if ("User_Select".equals(head.getService())) {
			if (body.getUserSelectBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return result.toString();
			}
			if (body.getUserSelectBody().getUser() != null) {
				logger.info("User_Select param{} :" + body.getUserSelectBody().getUser().toString());
				List<User> userLists = null;
				int count = 0;
				try {
					userLists = userService.selectByPage(body.getUserSelectBody().getUser());
					count = userService.selectByPageCount(body.getUserSelectBody().getUser());
				} catch (Exception e) {
					logger.error("程序异常:" + e);
					result.setResultCode("0");
					result.setIsLogin(false);
					result.setErrorInfo("程序异常,请联系管理员！！" + e.getMessage());
				}

				if (userLists.size() > 0 && count > 0) {
					result.setResultCode("1");
					result.setObj(userLists);
					result.setRecordNum(count);
					result.setPageNum(
							(int) Math.ceil((double) count / body.getUserSelectBody().getUser().getRecordNumPer()));
				}
			}

		}
		return gson.toJson(result);
	}

	/**
	 * 根据组织ID获取服务配置信息 并且同步到对应的前置端库
	 * @return
	 */
	private  Result getCnterSynchronization(HeadRequest head, BodyRequest body) {
		logger.info("前置端同步数据到中心端：getCnterSynchronization begin！！");

		Result result = new Result();
		Gson gson = new Gson();

		// 2,前置端创建用户后需要同步到中心端
		String wsdlUrl = WSDLProperties.getCenterWsdl();
		String nameSpace = WSDLProperties.getCenterNameSpace();
		String method = "dataService";
		String resultFront = HWYLWebService.getWSDL(wsdlUrl, nameSpace, method, gson.toJson(head), gson.toJson(body));
		result = gson.fromJson(resultFront, new TypeToken<Result>() {
		}.getType());
		// "0"表示同步远程失败
		if ("0".equals(result.getResultCode())) {
			logger.error("前置端用户同步中心端异常!!" + result.getErrorInfo());
			result.setResultCode("0");
			result.setErrorInfo("前置端用户同步中心端异常!!");
			return result;
		}
		logger.info(
				"前置端同步数据到中心端： getCnterSynchronization successful！！");
		return result;
	}
	


}
