package com.cn.hwyl.service;
import java.util.List;

import com.cn.hwyl.pojo.FirstaidResults;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.response.Result;

public interface IFirstaidResultsService {
	int deleteByPrimaryKey(String cResultsid);

	int insert(FirstaidResults record);

	FirstaidResults selectByPrimaryKey(String cResultsid);

	int updateByPrimaryKey(FirstaidResults record);
	
	List<FirstaidResults> selectByPage(FirstaidResults record);

	int selectByPageCount(FirstaidResults record);

	Result saveOrUpdateResultsBody(BodyRequest head);

}