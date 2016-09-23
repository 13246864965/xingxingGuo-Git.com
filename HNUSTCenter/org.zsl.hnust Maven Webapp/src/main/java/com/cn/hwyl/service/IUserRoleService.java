package com.cn.hwyl.service;

import com.cn.hwyl.pojo.UserRole;

public interface IUserRoleService {
    int deleteByPrimaryKey(String cUserroleid);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String cUserroleid);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}
