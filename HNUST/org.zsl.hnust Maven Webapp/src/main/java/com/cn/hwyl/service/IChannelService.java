package com.cn.hwyl.service;

import com.cn.hwyl.pojo.Channel;

public interface IChannelService {
    int deleteByPrimaryKey(String cChannelcode);

    int insert(Channel record);

    Channel selectByPrimaryKey(String cChannelcode);

    int updateByPrimaryKey(Channel record);
    
    int saveOrUpdate(Channel record);
}