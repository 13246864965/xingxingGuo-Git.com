package com.cn.hwyl.dao;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.FrontConfiguration;

@Repository
public interface IFrontConfigurationDao {
    int deleteByPrimaryKey(String cOrgid);

    int insert(FrontConfiguration record);

    int insertSelective(FrontConfiguration record);

    FrontConfiguration selectByPrimaryKey(String cOrgid);

    int updateByPrimaryKeySelective(FrontConfiguration record);

    int updateByPrimaryKey(FrontConfiguration record);
}