package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IOrganizationDao;
import com.cn.hwyl.pojo.Organization;
import com.cn.hwyl.service.IOrganizationService;


@Service("organizationService")
public class OrganizationServiceImpl implements IOrganizationService{
	
	@Resource
	private IOrganizationDao organizationDao;

	@Override
	public int deleteByPrimaryKey(String cOrgid) {
		return organizationDao.deleteByPrimaryKey(cOrgid);
	}

	@Override
	public int insert(Organization record) {
		return organizationDao.insert(record);
	}


	@Override
	public Organization selectByPrimaryKey(String cOrgid) {
		return organizationDao.selectByPrimaryKey(cOrgid);
	}

	@Override
	public int updateByPrimaryKey(Organization record) {
		return organizationDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Organization> selectByPage(Organization record) {
		return organizationDao.selectByPage(record);
	}

	@Override
	public int selectByCount(Organization record) {
		return organizationDao.selectByCount(record);
	}

	@Override
	public int saveOrUpdate(Organization record) {
		return organizationDao.saveOrUpdate(record);
	}

	@Override
	public int deleteBatch(List<Organization> record) {
		return organizationDao.deleteBatch(record);
	}

	@Override
	public int insertBatch(List<Organization> record) {
		return organizationDao.insertBatch(record) ;
	}
	

}
