package com.cn.hwyl.service;

import com.cn.hwyl.pojo.Patients;

public interface IPatientsService {
	  int deleteByPrimaryKey(String cPatientsid);

	    int insert(Patients record);

	    int insertSelective(Patients record);

	    Patients selectByPrimaryKey(String cPatientsid);

	    int updateByPrimaryKeySelective(Patients record);

	    int updateByPrimaryKey(Patients record);
	    int saveOrUpdate(Patients record);
}
