package com.cn.hwyl.service;

import com.cn.hwyl.pojo.Channel;

public interface IChannelService {
    int deleteByPrimaryKey(String cChannelcode);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(String cChannelcode);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
    
    int saveOrUpdate(Channel record);
}