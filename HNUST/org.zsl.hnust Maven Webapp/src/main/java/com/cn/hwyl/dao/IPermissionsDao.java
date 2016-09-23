package com.cn.hwyl.dao;

import java.util.List;

import com.cn.hwyl.pojo.Permissions;

public interface IPermissionsDao {
    int deleteByPrimaryKey(String cPrivilegeid);

    int insert(Permissions record);

    Permissions selectByPrimaryKey(String cPrivilegeid);

    int updateByPrimaryKey(Permissions record);
    
    List<Permissions> selectByPage(Permissions record);
    
    int selectByCount(Permissions record);
}