package com.cn.hwyl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.AmbulanceDevice;

@Repository
public interface IAmbulanceDeviceDao {
    int deleteByPrimaryKey(String cAdid);

    int insert(AmbulanceDevice record);

    int insertSelective(AmbulanceDevice record);

    AmbulanceDevice selectByPrimaryKey(String cAdid);

    int updateByPrimaryKeySelective(AmbulanceDevice record);

    int updateByPrimaryKey(AmbulanceDevice record);
    
  List<AmbulanceDevice> selectByPage(AmbulanceDevice record);
    
    int selectByCount(AmbulanceDevice record);
}