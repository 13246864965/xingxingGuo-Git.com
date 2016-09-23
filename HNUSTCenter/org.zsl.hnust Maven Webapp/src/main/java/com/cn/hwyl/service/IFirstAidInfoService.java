package com.cn.hwyl.service;

import com.cn.hwyl.pojo.FirstAidInfo;

public interface IFirstAidInfoService {
	int deleteByPrimaryKey(String cFirstaidinfoid);

    int insert(FirstAidInfo record);

    int insertSelective(FirstAidInfo record);

    FirstAidInfo selectByPrimaryKey(String cFirstaidinfoid);

    int updateByPrimaryKeySelective(FirstAidInfo record);

    int updateByPrimaryKey(FirstAidInfo record);
    int saveOrUpdate(FirstAidInfo record);

}
