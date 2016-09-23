package com.cn.hwyl.dao;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.DeviceUpdate;

@Repository
public interface IDeviceUpdateDao {
    int deleteByPrimaryKey(String cWardshipid);

    int insert(DeviceUpdate record);

    int insertSelective(DeviceUpdate record);

    DeviceUpdate selectByPrimaryKey(String cWardshipid);

    int updateByPrimaryKeySelective(DeviceUpdate record);

    int updateByPrimaryKey(DeviceUpdate record);
    
    int saveOrUpdate(DeviceUpdate record);
}