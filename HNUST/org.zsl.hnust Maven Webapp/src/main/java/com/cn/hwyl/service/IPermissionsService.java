package com.cn.hwyl.service;

import java.util.List;

import com.cn.hwyl.pojo.Permissions;

public interface IPermissionsService {

    int deleteByPrimaryKey(String cPrivilegeid);

    int insert(Permissions record);

    Permissions selectByPrimaryKey(String cPrivilegeid);

    int updateByPrimaryKey(Permissions record);

    List<Permissions> selectByPage(Permissions record);
    
    int selectByCount(Permissions record);
}
