package com.cn.hwyl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.FollowUpVisits;
@Repository
public interface IFollowUpVisitsDao {
    int deleteByPrimaryKey(Integer cVisitsid);

    int insert(FollowUpVisits record);

    int insertSelective(FollowUpVisits record);

    FollowUpVisits selectByPrimaryKey(Integer cVisitsid);

    int updateByPrimaryKeySelective(FollowUpVisits record);

    int updateByPrimaryKey(FollowUpVisits record);
    
    int saveOrUpdate(FollowUpVisits record);
    
  List<FollowUpVisits> selectByPage(FollowUpVisits record);
    
    int selectByPageCount(FollowUpVisits record);
}