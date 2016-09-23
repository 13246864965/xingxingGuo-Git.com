package com.cn.hwyl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.FirstaidTask;
@Repository
public interface IFirstaidTaskDao {
    int deleteByPrimaryKey(String cTaskid);

    int insert(FirstaidTask record);
    int saveOrUpdate(FirstaidTask record);

    int insertSelective(FirstaidTask record);

    FirstaidTask selectByPrimaryKey(String cTaskid);

    int updateByPrimaryKeySelective(FirstaidTask record);

    int updateByPrimaryKey(FirstaidTask record);
List<FirstaidTask> selectByPage(FirstaidTask record);
    
    int selectByPageCount(FirstaidTask record);
    
    
}