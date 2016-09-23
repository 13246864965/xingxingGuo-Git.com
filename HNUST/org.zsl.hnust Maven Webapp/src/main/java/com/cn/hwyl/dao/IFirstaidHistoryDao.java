package com.cn.hwyl.dao;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.FirstaidHistory;
@Repository
public interface IFirstaidHistoryDao {
    int deleteByPrimaryKey(String cFirstaidid);

    int insert(FirstaidHistory record);

    FirstaidHistory selectByPrimaryKey(String cFirstaidid);

    int updateByPrimaryKey(FirstaidHistory record);
}