package com.cn.hwyl.dao;

import com.cn.hwyl.pojo.OrgConfiguration;

public interface IOrgConfigurationDao {
    int deleteByPrimaryKey(String cConfigid);

    int insert(OrgConfiguration record);

    int insertSelective(OrgConfiguration record);

    OrgConfiguration selectByPrimaryKey(String cConfigid);

    int updateByPrimaryKeySelective(OrgConfiguration record);

    int updateByPrimaryKey(OrgConfiguration record);
}