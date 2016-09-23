package com.cn.hwyl.service;

import com.cn.hwyl.pojo.FirstAidInfo;


public interface IFirstAidInfoService {
	int deleteByPrimaryKey(String cFirstaidinfoid);

	int insert(FirstAidInfo record);

	FirstAidInfo selectByPrimaryKey(String cFirstaidinfoid);

	int updateByPrimaryKey(FirstAidInfo record);

	int saveOrUpdate(FirstAidInfo record);

}
