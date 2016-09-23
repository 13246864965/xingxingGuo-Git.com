package com.cn.hwyl.dao;

import com.cn.hwyl.pojo.UserRole;

public interface IUserRoleDao {
    int deleteByPrimaryKey(String cUserroleid);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String cUserroleid);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}