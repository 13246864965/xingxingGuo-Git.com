package com.cn.hwyl.service;

import java.util.List;

import com.cn.hwyl.pojo.FirstaidTask;

public interface IFirstaidTaskService {
    int deleteByPrimaryKey(String cTaskid);

    int insert(FirstaidTask record);

    int insertSelective(FirstaidTask record);

    FirstaidTask selectByPrimaryKey(String cTaskid);

    int updateByPrimaryKeySelective(FirstaidTask record);

    int updateByPrimaryKey(FirstaidTask record);
    
List<FirstaidTask> selectByPage(FirstaidTask record);
    
    int selectByPageCount(FirstaidTask record);
    int saveOrUpdate(FirstaidTask record);
}
