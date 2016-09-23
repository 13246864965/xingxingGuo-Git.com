package com.cn.hwyl.dao;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.HospitalServiceCenter;

@Repository
public interface IHospitalServiceCenterDao {
    int deleteByPrimaryKey(String cServicecentercode);

    int insert(HospitalServiceCenter record);

    HospitalServiceCenter selectByPrimaryKey(String cServicecentercode);

    int updateByPrimaryKey(HospitalServiceCenter record);
    
    int saveOrUpdate(HospitalServiceCenter record);
}