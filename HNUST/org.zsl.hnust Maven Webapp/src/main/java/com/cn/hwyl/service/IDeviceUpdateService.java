package com.cn.hwyl.service;

import com.cn.hwyl.pojo.DeviceUpdate;


public interface IDeviceUpdateService {
    int deleteByPrimaryKey(String cWardshipid);

    int insert(DeviceUpdate record);

    DeviceUpdate selectByPrimaryKey(String cWardshipid);

    int updateByPrimaryKey(DeviceUpdate record);
    
    int saveOrUpdate(DeviceUpdate record);
}