package com.cn.hwyl.service;

import java.util.List;

import com.cn.hwyl.pojo.FollowUpVisits;

public interface IFollowUpVisitsService {
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
