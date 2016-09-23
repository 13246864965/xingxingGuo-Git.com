package com.cn.hwyl.service;

import com.cn.hwyl.pojo.FirstAid;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;

public interface IFirstAidService {
	int deleteByPrimaryKey(String cFirstaidid);

	int insert(FirstAid record);

	FirstAid selectByPrimaryKey(String cFirstaidid);

	int updateByPrimaryKey(FirstAid record);

	// 根据orgID，设备号查询合同号
	FirstAid selectFirstAidIdByCondition(FirstAid record);

	int saveOrUpdate(FirstAid record) throws Exception;

	String selectFirstAidIDBycCardNumber(String cCardNumber);

	Result saveOrUpdateBody(HeadRequest head,BodyRequest record);
}
