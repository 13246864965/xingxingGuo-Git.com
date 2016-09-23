package com.cn.hwyl.service;

import com.cn.hwyl.pojo.FirstaidHistory;

public interface IFirstaidHistoryService {
    int deleteByPrimaryKey(String cFirstaidid);

    int insert(FirstaidHistory record);

    FirstaidHistory selectByPrimaryKey(String cFirstaidid);

    int updateByPrimaryKey(FirstaidHistory record);
}