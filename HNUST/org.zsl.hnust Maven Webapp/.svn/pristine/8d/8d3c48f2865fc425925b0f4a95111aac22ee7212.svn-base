package com.cn.hwyl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.Role;

@Repository
public interface IRoleDao {
    int deleteByPrimaryKey(String cRoleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String cRoleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectByPage(Role record);
    
    int selectByCount(Role record);
}