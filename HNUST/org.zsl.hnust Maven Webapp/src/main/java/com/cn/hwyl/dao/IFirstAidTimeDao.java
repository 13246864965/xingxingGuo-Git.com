package com.cn.hwyl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.FirstAidTime;
@Repository
public interface IFirstAidTimeDao {
    int deleteByPrimaryKey(String cTimeid);

    int insert(FirstAidTime record);
    int saveOrUpdate(FirstAidTime record);

    FirstAidTime selectByPrimaryKey(String cTimeid);
    List<FirstAidTime> selectByPrimaryByFirstAidTime(FirstAidTime record);

    int updateByPrimaryKeyWithBLOBs(FirstAidTime record);

    int updateByPrimaryKey(FirstAidTime record);
    
    int deleteBatch(List<FirstAidTime> record);
    int insertBatch(List<FirstAidTime> record);
}