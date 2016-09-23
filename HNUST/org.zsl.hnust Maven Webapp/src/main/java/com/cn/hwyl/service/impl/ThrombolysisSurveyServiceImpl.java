package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IThrombolysisSurveyDao;
import com.cn.hwyl.pojo.ThrombolysisSurvey;
import com.cn.hwyl.service.IThrombolysisSurveyService;
@Service("thrombolysisSurveyService")
public class ThrombolysisSurveyServiceImpl implements IThrombolysisSurveyService{
	@Resource
	private IThrombolysisSurveyDao thrombolysisSurveyDao;

	@Override
	public int deleteByPrimaryKey(String cSurveyid) {
		return thrombolysisSurveyDao.deleteByPrimaryKey(cSurveyid);
	}

	@Override
	public int insert(ThrombolysisSurvey record) {
		return thrombolysisSurveyDao.insert(record);
	}

	@Override
	public int insertSelective(ThrombolysisSurvey record) {
		return thrombolysisSurveyDao.insertSelective(record);
	}

	@Override
	public ThrombolysisSurvey selectByPrimaryKey(String cSurveyid) {
		return thrombolysisSurveyDao.selectByPrimaryKey(cSurveyid);
	}

	@Override
	public int updateByPrimaryKeySelective(ThrombolysisSurvey record) {
		return thrombolysisSurveyDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ThrombolysisSurvey record) {
		return thrombolysisSurveyDao.updateByPrimaryKey(record);
	}

	@Override
	public int insertBatch(List<ThrombolysisSurvey> record) {
		return thrombolysisSurveyDao.insertBatch(record);
	}

	@Override
	public List<ThrombolysisSurvey> selectByPrimaryFirstAidID(String firstAidID) {
		return thrombolysisSurveyDao.selectByPrimaryFirstAidID(firstAidID);
	}

}
