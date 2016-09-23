package com.cn.hwyl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.Organization;

@Repository
public interface IOrganizationDao {
    int deleteByPrimaryKey(String cOrgid);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(String cOrgid);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
    
    List<Organization> selectByPage(Organization record);
    
    int selectByCount(Organization record);
    int saveOrUpdate(Organization record);
    
}