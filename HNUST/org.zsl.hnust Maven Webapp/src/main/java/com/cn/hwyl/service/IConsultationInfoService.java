package com.cn.hwyl.service;

import com.cn.hwyl.pojo.ConsultationInfo;

public interface IConsultationInfoService {
    int deleteByPrimaryKey(String cConsultationid);

    int insert(ConsultationInfo record);

    ConsultationInfo selectByPrimaryKey(String cConsultationid);

    int updateByPrimaryKey(ConsultationInfo record);
}