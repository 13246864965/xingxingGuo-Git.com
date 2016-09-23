package com.cn.hwyl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.FirstaidResults;
@Repository
public interface IFirstaidResultsDao {
    int deleteByPrimaryKey(String cResultsid);

    int insert(FirstaidResults record);

    FirstaidResults selectByPrimaryKey(String cResultsid);

    List<FirstaidResults> selectByPage(FirstaidResults record);

	int selectByPageCount(FirstaidResults record);
    int updateByPrimaryKey(FirstaidResults record);

}