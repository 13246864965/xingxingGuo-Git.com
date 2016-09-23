package com.cn.hwyl.dao;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.FirstaidCollection;
@Repository
public interface IFirstaidCollectionDao {
    int deleteByPrimaryKey(String cCollectionid);

    int insert(FirstaidCollection record);

    int insertSelective(FirstaidCollection record);

    FirstaidCollection selectByPrimaryKey(String cCollectionid);

    int updateByPrimaryKeySelective(FirstaidCollection record);

    int updateByPrimaryKey(FirstaidCollection record);
}