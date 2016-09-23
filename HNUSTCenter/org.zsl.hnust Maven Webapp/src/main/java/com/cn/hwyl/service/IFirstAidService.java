package com.cn.hwyl.service;

import com.cn.hwyl.pojo.FirstAid;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;

public interface IFirstAidService {
	int deleteByPrimaryKey(String cFirstaidid);

	int insert(FirstAid record);

	int insertSelective(FirstAid record);

	FirstAid selectByPrimaryKey(String cFirstaidid);

	int updateByPrimaryKeySelective(FirstAid record);

	int updateByPrimaryKey(FirstAid record);
	//根据orgID，设备号查询合同号
	FirstAid selectFirstAidIdByCondition(FirstAid record);
	int saveOrUpdate(FirstAid record);
	Result saveOrUpdateBody(HeadRequest head,BodyRequest body);
}
