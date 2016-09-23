package com.cn.hwyl.service;

import java.util.List;

import com.cn.hwyl.pojo.AmbulanceDevice;

public interface IAmbulanceDeviceService {
    int deleteByPrimaryKey(String cAdid);

    int insert(AmbulanceDevice record);

    int insertSelective(AmbulanceDevice record);

    AmbulanceDevice selectByPrimaryKey(String cAdid);

    int updateByPrimaryKeySelective(AmbulanceDevice record);

    int updateByPrimaryKey(AmbulanceDevice record);
    
    List<AmbulanceDevice> selectByPage(AmbulanceDevice record);
    
    int selectByCount(AmbulanceDevice record);
}