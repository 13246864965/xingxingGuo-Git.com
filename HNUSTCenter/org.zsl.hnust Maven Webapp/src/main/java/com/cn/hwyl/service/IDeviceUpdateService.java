package com.cn.hwyl.service;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.DeviceUpdate;


public interface IDeviceUpdateService {
    int deleteByPrimaryKey(String cWardshipid);

    int insert(DeviceUpdate record);

    int insertSelective(DeviceUpdate record);

    DeviceUpdate selectByPrimaryKey(String cWardshipid);

    int updateByPrimaryKeySelective(DeviceUpdate record);

    int updateByPrimaryKey(DeviceUpdate record);
    
    int saveOrUpdate(DeviceUpdate record);
}