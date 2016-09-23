package com.cn.hwyl.dao;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.Channel;

@Repository
public interface IChannelDao {
    int deleteByPrimaryKey(String cChannelcode);

    int insert(Channel record);

    Channel selectByPrimaryKey(String cChannelcode);

    int updateByPrimaryKey(Channel record);
    
    int saveOrUpdate(Channel record);
}