package com.cn.hwyl.module;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.main.HWYLWebService;
import com.cn.hwyl.pojo.FrontConfiguration;
import com.cn.hwyl.pojo.User;
import com.cn.hwyl.pojo.body.user.UserDeleteBody;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFrontConfigurationService;
import com.cn.hwyl.service.IUserRoleService;
import com.cn.hwyl.service.IUserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserCenterModule {

	private static Logger logger = Logger.getLogger(UserCenterModule.class);
	
	@SuppressWarnings("resource")
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	
	public static String userAll(HeadRequest head, BodyRequest body) {
		IUserService userService = (IUserService) ac.getBean("userService");
		IUserRoleService userRoleService = (IUserRoleService) ac.getBean("userRoleService");
		Result result = new Result();
		Gson gson = new Gson();
		int isOk = 0;
		//用户登录
		if ("User_Login".equals(head.getService())) {
			logger.info("User_Login param{} :" + body.getUserLoginBody().toString());
			User user = userService.selectByCusername(body.getUserLoginBody().getcUsername());
			if (user == null || "".equals(user)) {
				result.setResultCode("0");
				result.setIsLogin(false);
				result.setErrorInfo(body.getUserLoginBody().getcUsername() + "用户不存在！！");
				return gson.toJson(result);
			}
			try {// MD5Util.md5Encode(body.getUserLoginBody().getcUserpwd())
				if (!user.getcUserpwd().equals(body.getUserLoginBody().getcUserpwd())) {
					result.setResultCode("0");
					result.setIsLogin(false);
					result.setErrorInfo("用户密码不对,请重新输入！！");
					return gson.toJson(result);
				}
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setIsLogin(false);
				result.setErrorInfo("程序异常,请联系管理员！！");
				return gson.toJson(result);
			}
			result.setResultCode("1");
			result.setObj(user);
			result.setIsLogin(true);
		}

		// 用户新增或者更改
		if ("User_Edit".equals(head.getService())) {
			// 判断请求对象参数是否为空
			if (body.getUserEditBody() == null || "".equals(body.getUserEditBody())) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			try {
				/**
				 * 1,根据组织ID获取服务配置信息 并且同步到对应的前置端库
				 * 2,在中心端创建用户,并赋予角色
				 */
				head.setService("synchronousDataByUserEdit");
				Result centerResult = getFrontAndSynchronization(head, body);
				
				if ("0".equals(centerResult.getResultCode())) {
					return gson.toJson(centerResult);
				}
				
				logger.info("User_Edit param{} :" + body.getUserEditBody().getUser().toString());
				isOk = userService.saveOrUpdate(body.getUserEditBody().getUser());
				if(body.getUserEditBody().getUserRole() !=null && !"".equals(body.getUserEditBody().getUserRole())){
					userRoleService.insert(body.getUserEditBody().getUserRole());
				}
				
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setIsLogin(false);
				result.setErrorInfo("程序异常,请联系管理员！！");
				return gson.toJson(result);
			}
			if (isOk > 0) {
				result.setResultCode("1");
				result.setErrorInfo("操作成功");
				return gson.toJson(result);
			}

		}
		//用户删除
		if ("User_Delete".equals(head.getService())) {
			if (body.getUserDeleteBody() == null || "".equals(body.getUserDeleteBody())) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return result.toString();
			}
			try {
				// 先删除前置端用户
				head.setService("synchronousDataByUserDelete");
				Result centerResult = getFrontAndSynchronization(head, body);
				if ("0".equals(centerResult.getResultCode())) {
					return gson.toJson(centerResult);
				}
				
				logger.info("User_Delete param{} :" + body.getUserDeleteBody().getcUserid().toString());
				isOk = userService.deleteByPrimaryKey(body.getUserDeleteBody().getcUserid());
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setIsLogin(false);
				result.setErrorInfo("程序异常,请联系管理员！！");
			}
			if (isOk > 0) {
				result.setResultCode("1");
				result.setErrorInfo("操作成功");
				return gson.toJson(result);
			}

		}
		//用户查询
		if ("User_Select".equals(head.getService())) {
			if (body.getUserSelectBody() == null || "".equals(body.getUserSelectBody())) {
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
					result.setErrorInfo("程序异常,请联系管理员！！");
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
	private static Result getFrontAndSynchronization(HeadRequest head, BodyRequest body) {
		logger.info("中心端同步数据到前置端：User_Edit getFrontAndSynchronization begin！！");

		Gson gson = new Gson();
		Result result = new Result();
		String resultFront = null;
		FrontConfiguration frontConfiguration  = null;
		IFrontConfigurationService frontConfigurationService = (IFrontConfigurationService) ac
				.getBean("frontConfigurationService");

		if("synchronousDataByUserEdit".equals(head.getService())){
			frontConfiguration = frontConfigurationService
					.selectByPrimaryKey(body.getUserEditBody().getUser().getcOrgid());
		}
		if("synchronousDataByUserDelete".equals(head.getService())){
			frontConfiguration = frontConfigurationService.selectByPrimaryKey(body.getUserDeleteBody().getcOrgid());
		}
		if (frontConfiguration != null) {
			// 2,中心端创建用户后需要同步到对应的前置端
			String wsdlUrl = "http://" + frontConfiguration.getcWsdladdress() + "/api/services/CPManageWebservice";
			String nameSpace = "http://main.hwyl.cn.com/";
			String method = "dataService";
			resultFront = HWYLWebService.getWSDL(wsdlUrl, nameSpace, method, gson.toJson(head), gson.toJson(body));
		}	
		result = gson.fromJson(resultFront, new TypeToken<Result>() {
		}.getType());
		// “0”同步远程失败
		if ("0".equals(result.getResultCode())) {
			logger.error("用户同步前置端异常!!"+result.getErrorInfo());
			result.setResultCode("0");
			result.setErrorInfo("用户同步前置端异常!!");
			return result;
		}
		logger.info("中心端同步数据到前置端：User_Edit getFrontAndSynchronization successful！！");
		return result;
	}

}









