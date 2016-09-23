package com.cn.hwyl.service;

import com.cn.hwyl.pojo.FrontConfiguration;
import com.cn.hwyl.pojo.response.Result;

public interface IFrontConfigurationService {
	int deleteByPrimaryKey(String cOrgid);

	int insert(FrontConfiguration record);

	FrontConfiguration selectByPrimaryKey(String cOrgid);

	int updateByPrimaryKey(FrontConfiguration record);

	Result insertOrgAndsyncFranc(FrontConfiguration record);
}
