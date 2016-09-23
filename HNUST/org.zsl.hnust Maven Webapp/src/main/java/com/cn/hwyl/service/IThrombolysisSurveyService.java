package com.cn.hwyl.service;

import java.util.List;

import com.cn.hwyl.pojo.ThrombolysisSurvey;

public interface IThrombolysisSurveyService {
    int deleteByPrimaryKey(String cSurveyid);

    int insert(ThrombolysisSurvey record);

    int insertSelective(ThrombolysisSurvey record);

    ThrombolysisSurvey selectByPrimaryKey(String cSurveyid);
    List<ThrombolysisSurvey> selectByPrimaryFirstAidID(String firstAidID);

    int updateByPrimaryKeySelective(ThrombolysisSurvey record);

    int updateByPrimaryKey(ThrombolysisSurvey record);
    
    int insertBatch(List<ThrombolysisSurvey> record);

}
