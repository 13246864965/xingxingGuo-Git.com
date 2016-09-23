package com.cn.hwyl.dao;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.FirstAid;

@Repository
public interface IFirstAidDao {
    int deleteByPrimaryKey(String cFirstaidid);

    int insert(FirstAid record);

    FirstAid selectByPrimaryKey(String cFirstaidid);

    int updateByPrimaryKey(FirstAid record);
    FirstAid selectFirstAidIdByCondition(FirstAid record);
    
    int saveOrUpdate(FirstAid record);
    
    String selectFirstAidIDBycCardNumber(String cCardNumber);
}