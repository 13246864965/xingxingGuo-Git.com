package com.cn.hwyl.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hwyl.dao.IChannelDao;
import com.cn.hwyl.dao.IFrontConfigurationDao;
import com.cn.hwyl.dao.IHospitalServiceCenterDao;
import com.cn.hwyl.dao.IOrganizationDao;
import com.cn.hwyl.dao.IRoleDao;
import com.cn.hwyl.main.HWYLWebService;
import com.cn.hwyl.pojo.Channel;
import com.cn.hwyl.pojo.FrontConfiguration;
import com.cn.hwyl.pojo.HospitalServiceCenter;
import com.cn.hwyl.pojo.Organization;
import com.cn.hwyl.pojo.Role;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFrontConfigurationService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
@Transactional(rollbackFor = {RuntimeException.class})
@Service("frontConfigurationService")
public class FrontConfigurationServiceImpl implements IFrontConfigurationService {

	private static Logger logger = Logger.getLogger(FrontConfigurationServiceImpl.class);
	@Resource 
	private IFrontConfigurationDao frontConfigurationDao;
	
	@Resource
	private IHospitalServiceCenterDao hospitalServiceCenterDao;
	
	@Resource
	private IChannelDao channelDao;
	
	@Resource
	private IOrganizationDao organizationDao;
	
	@Resource
	private IRoleDao roleDao;
	
	
	@Override
	public int deleteByPrimaryKey(String cOrgid) {
		return frontConfigurationDao.deleteByPrimaryKey(cOrgid);
	}

	@Override
	public int insert(FrontConfiguration record) {
		return frontConfigurationDao.insert(record);
	}


	@Override
	public FrontConfiguration selectByPrimaryKey(String cOrgid) {
		return frontConfigurationDao.selectByPrimaryKey(cOrgid);
	}

	@Override
	public int updateByPrimaryKey(FrontConfiguration record) {
		return frontConfigurationDao.updateByPrimaryKey(record);
	}

	@Override
	public Result insertOrgAndsyncFranc(FrontConfiguration record) {
		Result result = new Result();
		try {
			// 中心端插入服务器配置
			frontConfigurationDao.insert(record);
			FrontConfiguration frontConfiguration = frontConfigurationDao.selectByPrimaryKey(record.getcOrgid());

			// 查询Organization
			Organization organization = organizationDao.selectByPrimaryKey(record.getcOrgid());
			// 查询HospitalServiceCenter
			HospitalServiceCenter hospitalServiceCenter = hospitalServiceCenterDao
					.selectByPrimaryKey(record.getcOrgid());
			// 查询chanel
			Channel channel = channelDao.selectByPrimaryKey(record.getcOrgid());
			
			this.createAdminRoleAndSynchronousFront(frontConfiguration, organization, hospitalServiceCenter,
					channel);
			
			result.setErrorInfo("操作成功！");
		} catch (Exception e) {
			result.setErrorCode("0");
			result.setErrorInfo("保存组织信息到中心端失败");
			throw new RuntimeException(e);
		}

		return result;

	}
	
	/**
	 * 配置机构服务信息时1,添加一个管理员角色;2同步到对应的前置端
	 */
	private Result createAdminRoleAndSynchronousFront(FrontConfiguration frontConfiguration,Organization organization,HospitalServiceCenter hospitalServiceCenter,Channel channel) {

		Gson gson = new Gson();
		Result result = new Result();
		String resultFront = null;

		Role role = new Role();
		String roleId = UUID.randomUUID().toString();
		role.setcRoleid(roleId);
		role.setcRolename("机构管理员");
		role.setcRolecode("jggly");
		role.setcRoletype(1);// 0：普通角色；1：管理员角色
		role.setcSuatus("0");
		role.setcOrgid(organization.getOrgId());
		role.setcOrgcode(organization.getOrgCode());
		role.setcUpdatedate(organization.getUpdateTime());
		role.setcUpdateuserid(organization.getUpdateUserId());

		// 1,同步到前置端
		if (frontConfiguration != null) {
			// 2,中心端同步到对应的前置端
			String wsdlUrl = "http://" + frontConfiguration.getcWsdladdress() + "/api/services/CPManageWebservice";
			String nameSpace = "http://main.hwyl.cn.com/";
			String method = "dataService";
			HeadRequest head = new HeadRequest();
			head.setService("createAdminRoleAndSynchronousFront");
			hospitalServiceCenter.setRoleId(roleId);
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("organization", organization);
			map.put("hospitalServiceCenter", hospitalServiceCenter);
			map.put("channel", channel);
			resultFront = HWYLWebService.getWSDL(wsdlUrl, nameSpace, method, gson.toJson(head), gson.toJson(map));
		}

		result = gson.fromJson(resultFront, new TypeToken<Result>() {
		}.getType());

		// "0"同步远程失败
		if ("0".equals(result.getResultCode())) {
			logger.error("管理员角色同步前置端异常!!" + result.getErrorInfo());
			result.setResultCode("0");
			result.setErrorInfo("云端同步组织创建前置端管理员角色失败!!");
			throw new RuntimeException();
			}
		// 2,在中心端创建
		int roleResult = roleDao.insert(role);
		if (roleResult > 0) {
			result.setResultCode("1");
			result.setErrorInfo("云端同步组织创建前置端管理员角色成功!!");
		}
		result.setResultCode("1");
		logger.info("中心端同步数据到前置端：synchronousDataByOrganize createAdminRoleAndSynchronousFront successful！！");

		return result;
	}
	
	private void fatherToChild(Object father, Object child) throws Exception {
		if (!(child.getClass().getSuperclass() == father.getClass())) {
			throw new Exception("child不是father的子类");
		}
		Class fatherClass = father.getClass();
		Field ff[] = fatherClass.getDeclaredFields();
		for (int i = 0; i < ff.length; i++) {
			Field f = ff[i];// 取出每一个属性，如deleteDate
			Class type = f.getType();
			f.setAccessible(true);// 私有属性也复制
			Method m = fatherClass.getMethod("get" + upperHeadChar(f.getName()));// 方法getDeleteDate
			Object obj = m.invoke(father);// 取出属性值
			f.set(child, obj);
		}
	}  

	private String upperHeadChar(String in) {
		String head = in.substring(0, 1);
		String out = head.toUpperCase() + in.substring(1, in.length());
		return out;
	}  
	
}
