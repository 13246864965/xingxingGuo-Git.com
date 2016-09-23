package com.cn.hwyl.service;

import java.util.List;

import com.cn.hwyl.pojo.FirstAidTime;
import com.cn.hwyl.pojo.response.Result;

public interface IFirstAidTimeService {

	int deleteByPrimaryKey(String cTimeid);

	int insert(FirstAidTime record);

	FirstAidTime selectByPrimaryKey(String cTimeid);
	List<FirstAidTime> selectByPrimaryByFirstAidTime(FirstAidTime record);

	int updateByPrimaryKeyWithBLOBs(FirstAidTime record);

	int updateByPrimaryKey(FirstAidTime record);

	int saveOrUpdate(FirstAidTime record);

	Result insertBatchAndDelete(List<FirstAidTime> record);
}
