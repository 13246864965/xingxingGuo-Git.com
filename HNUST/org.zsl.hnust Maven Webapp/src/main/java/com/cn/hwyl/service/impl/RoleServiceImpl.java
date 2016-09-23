package com.cn.hwyl.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hwyl.dao.IChannelDao;
import com.cn.hwyl.dao.IHospitalServiceCenterDao;
import com.cn.hwyl.dao.IOrganizationDao;
import com.cn.hwyl.dao.IRoleDao;
import com.cn.hwyl.pojo.Channel;
import com.cn.hwyl.pojo.HospitalServiceCenter;
import com.cn.hwyl.pojo.Organization;
import com.cn.hwyl.pojo.Role;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IRoleService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Transactional(rollbackFor = {RuntimeException.class})
@Service("roleService")
public class RoleServiceImpl implements IRoleService{

	private  Logger logger = Logger.getLogger(RoleServiceImpl.class);
	@Resource
	private IHospitalServiceCenterDao hospitalServiceCenterDao;
	
	@Resource
	private IChannelDao channelDao;
	
	@Resource
	private IOrganizationDao organizationDao;
	
	@Resource
	private IRoleDao roleDao;
	
	@Override
	public int deleteByPrimaryKey(String cRoleid) {
		return roleDao.deleteByPrimaryKey(cRoleid);
	}

	@Override
	public int insert(Role record) {
		return roleDao.insert(record);
	}

	@Override
	public Role selectByPrimaryKey(String cRoleid) {
		return roleDao.selectByPrimaryKey(cRoleid);
	}


	@Override
	public int updateByPrimaryKey(Role record) {
		return roleDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Role> selectByPage(Role record) {
		return roleDao.selectByPage(record);
	}

	@Override
	public int selectByCount(Role record) {
		return roleDao.selectByCount(record);
	}

//	@Override
//	public Result inserRoleAndOrganize(HospitalServiceCenter record) {
//		Result result = new Result();
//		Role role = new Role();
//		role.setcRoleid(record.getRoleId());
//		role.setcRolename("机构管理员");
//		role.setcRolecode("jggly");
//		role.setcRoletype(1);// 0：普通角色；1：管理员角色
//		role.setcSuatus("0");
//		role.setcOrgid(record.getOrgId());
//		role.setcOrgcode(record.getOrgCode());
//		role.setcUpdatedate(record.getUpdateTime());
//		role.setcUpdateuserid(record.getUpdateUserId());
//
//		Organization organization = (Organization) record;
//		Channel channel = (Channel) record;
//		try {
//
//			roleDao.insert(role);
//			hospitalServiceCenterDao.saveOrUpdate(record);
//			channelDao.saveOrUpdate(channel);
//			organizationDao.saveOrUpdate(organization);
//			result.setResultCode("1");
//			result.setErrorInfo("操作成功");
//			return result;
//		} catch (Exception e) {
//			result.setErrorCode("0");
//			result.setErrorInfo("保存组织信息到中心端失败");
//			throw new RuntimeException(e);
//
//		}
//	}

	@Override
	public Result inserRoleAndOrganize(Map<String, Object> record) {
		Gson gson = new Gson();

		Channel channel = gson.fromJson(gson.toJson(record.get("channel")), new TypeToken<Channel>() {
		}.getType());
		Organization organization = gson.fromJson(gson.toJson(record.get("organization")),
				new TypeToken<Organization>() {
				}.getType());
		HospitalServiceCenter hospitalServiceCenter = gson.fromJson(gson.toJson(record.get("hospitalServiceCenter")),
				new TypeToken<HospitalServiceCenter>() {
				}.getType());

		Result result = new Result();
		Role role = new Role();
		role.setcRoleid(hospitalServiceCenter.getRoleId());
		role.setcRolename("机构管理员");
		role.setcRolecode("jggly");
		role.setcRoletype(1);// 0：普通角色；1：管理员角色
		role.setcSuatus("0");
		role.setcOrgid(organization.getOrgId());
		role.setcOrgcode(organization.getOrgCode());
		role.setcUpdatedate(organization.getUpdateTime());
		role.setcUpdateuserid(organization.getUpdateUserId());
		try {

			roleDao.insert(role);
			logger.info("中心端同步组织："+organization.getOrgId()+"创建管理员角色 successful！！");
			hospitalServiceCenterDao.saveOrUpdate(hospitalServiceCenter);
			logger.info("中心端同步组织："+organization.getOrgId()+"创建hospitalServiceCenter  successful！！");
			channelDao.saveOrUpdate(channel);
			logger.info("中心端同步组织："+organization.getOrgId()+"创建channel  successful！！");
			organizationDao.saveOrUpdate(organization);
			logger.info("中心端同步组织："+organization.getOrgId()+"创建organization  successful！！");
			result.setResultCode("1");
			result.setErrorInfo("操作成功");
			return result;
		} catch (Exception e) {
			result.setErrorCode("0");
			result.setErrorInfo("保存组织信息到中心端失败");
			logger.info("中心端同步组织："+hospitalServiceCenter.getOrgId()+"  error！！");
			throw new RuntimeException(e);

		}
	}

}
