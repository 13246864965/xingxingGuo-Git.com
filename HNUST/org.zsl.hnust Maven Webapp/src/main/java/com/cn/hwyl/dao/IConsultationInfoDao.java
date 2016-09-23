package com.cn.hwyl.dao;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.ConsultationInfo;

@Repository
public interface IConsultationInfoDao {
    int deleteByPrimaryKey(String cConsultationid);

    int insert(ConsultationInfo record);

    ConsultationInfo selectByPrimaryKey(String cConsultationid);

    int updateByPrimaryKey(ConsultationInfo record);
}