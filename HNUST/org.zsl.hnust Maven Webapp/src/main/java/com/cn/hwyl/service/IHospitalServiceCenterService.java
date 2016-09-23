package com.cn.hwyl.service;

import com.cn.hwyl.pojo.HospitalServiceCenter;

public interface IHospitalServiceCenterService {
    int deleteByPrimaryKey(String cServicecentercode);

    int insert(HospitalServiceCenter record);

    HospitalServiceCenter selectByPrimaryKey(String cServicecentercode);

    int updateByPrimaryKey(HospitalServiceCenter record);
    
    int saveOrUpdate(HospitalServiceCenter record);
}