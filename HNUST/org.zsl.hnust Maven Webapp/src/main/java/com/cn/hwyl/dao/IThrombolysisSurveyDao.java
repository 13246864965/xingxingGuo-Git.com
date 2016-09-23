package com.cn.hwyl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.ThrombolysisSurvey;
@Repository
public interface IThrombolysisSurveyDao {
    int deleteByPrimaryKey(String cSurveyid);

    int insert(ThrombolysisSurvey record);

    int insertSelective(ThrombolysisSurvey record);

    ThrombolysisSurvey selectByPrimaryKey(String cSurveyid);
    List<ThrombolysisSurvey> selectByPrimaryFirstAidID(String cSurveyid);

    int updateByPrimaryKeySelective(ThrombolysisSurvey record);

    int updateByPrimaryKey(ThrombolysisSurvey record);
    
    int insertBatch(List<ThrombolysisSurvey> record);

}