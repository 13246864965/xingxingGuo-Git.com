package com.cn.hwyl.dao;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.Patients;
@Repository
public interface IPatientsDao {
    int deleteByPrimaryKey(String cPatientsid);

    int insert(Patients record);

    Patients selectByPrimaryKey(String cPatientsid);

    int updateByPrimaryKey(Patients record);
    
    int saveOrUpdate(Patients record);
}