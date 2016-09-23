package com.cn.hwyl.service;

import com.cn.hwyl.pojo.HospitalServiceCenter;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;

public interface IHospitalServiceCenterService {
    int deleteByPrimaryKey(String cServicecentercode);

    int insert(HospitalServiceCenter record);

    int insertSelective(HospitalServiceCenter record);

    HospitalServiceCenter selectByPrimaryKey(String cServicecentercode);

    int updateByPrimaryKeySelective(HospitalServiceCenter record);

    int updateByPrimaryKey(HospitalServiceCenter record);
    
    int saveOrUpdate(HospitalServiceCenter record);
    
    Result saveOrUpdateBody(HeadRequest head,HospitalServiceCenter hospitalServiceCenter);
}