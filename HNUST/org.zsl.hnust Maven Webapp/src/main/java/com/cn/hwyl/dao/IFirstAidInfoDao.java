package com.cn.hwyl.dao;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.FirstAidInfo;

@Repository
public interface IFirstAidInfoDao{
    int deleteByPrimaryKey(String cFirstaidinfoid);

    int insert(FirstAidInfo record);
    int insertByFirstAidID(String cFirstaidid);
    FirstAidInfo selectByPrimaryKey(String cFirstaidinfoid);

    int updateByPrimaryKey(FirstAidInfo record);

    int saveOrUpdate(FirstAidInfo record);
}