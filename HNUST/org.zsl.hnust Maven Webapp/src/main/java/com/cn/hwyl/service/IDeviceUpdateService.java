package com.cn.hwyl.service;

import com.cn.hwyl.pojo.DeviceUpdate;


public interface IDeviceUpdateService {
    int deleteByPrimaryKey(String cWardshipid);

    int insert(DeviceUpdate record);

    DeviceUpdate selectByPrimaryKey(String cWardshipid);

    int updateByPrimaryKey(DeviceUpdate record);
    
    int saveOrUpdate(DeviceUpdate record);
  //根据急救编号查询第一条设备合同信息
    DeviceUpdate selectDeviceUpdateByFirst(String cFirstaidid);
    //根据急救编号查询最近添加的一条设备合同信息
    DeviceUpdate selectDeviceUpdateByLast(String cFirstaidid);
    
}