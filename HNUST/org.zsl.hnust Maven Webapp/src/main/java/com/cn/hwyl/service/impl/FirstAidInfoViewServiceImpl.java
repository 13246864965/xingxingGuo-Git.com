package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hwyl.dao.IFirstAidDao;
import com.cn.hwyl.dao.IFirstAidInfoViewDao;
import com.cn.hwyl.pojo.FirstAid;
import com.cn.hwyl.pojo.FirstAidInfo;
import com.cn.hwyl.pojo.FirstAidInfoView;
import com.cn.hwyl.service.IFirstAidInfoService;
import com.cn.hwyl.service.IFirstAidInfoViewService;
import com.cn.hwyl.service.IFirstAidService;


@Service("firstAidInfoViewService")
public class FirstAidInfoViewServiceImpl implements IFirstAidInfoViewService{

	@Resource
	private IFirstAidInfoViewDao firstAidInfoViewDao;

	@Override
	public List<FirstAidInfoView> selectFirstAidInfoViewByFirstAidID(FirstAidInfoView record) {
		return firstAidInfoViewDao.selectFirstAidInfoViewByFirstAidID(record);
	}

	@Override
	public int selectFirstAidInfoViewByCount(FirstAidInfoView record) {
		return firstAidInfoViewDao.selectFirstAidInfoViewByCount(record);
	}

	@Override
	public List<FirstAidInfoView> selectFirstAidHistoryView(FirstAidInfoView record) {
		return firstAidInfoViewDao.selectFirstAidHistoryView(record);
	}

	@Override
	public int selectFirstAidHistoryViewCount(FirstAidInfoView record) {
		return firstAidInfoViewDao.selectFirstAidHistoryViewCount(record);
	}
	

}
