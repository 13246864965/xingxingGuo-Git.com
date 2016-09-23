package com.cn.hwyl.service;

import java.util.List;

import com.cn.hwyl.pojo.Role;

public interface IRoleService {

    int deleteByPrimaryKey(String cRoleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String cRoleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectByPage(Role record);
    
    int selectByCount(Role record);

}
