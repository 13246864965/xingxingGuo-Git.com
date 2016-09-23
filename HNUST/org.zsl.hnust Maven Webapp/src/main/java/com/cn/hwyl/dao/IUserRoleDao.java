package com.cn.hwyl.dao;

import com.cn.hwyl.pojo.UserRole;

public interface IUserRoleDao {
    int deleteByPrimaryKey(String cUserroleid);

    int insert(UserRole record);

    UserRole selectByPrimaryKey(String cUserroleid);

    int updateByPrimaryKey(UserRole record);
}