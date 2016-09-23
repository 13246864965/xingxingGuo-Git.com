package com.cn.hwyl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hwyl.pojo.FirstAidInfoView;
@Repository
public interface IFirstAidInfoViewDao {
	
	List<FirstAidInfoView> selectFirstAidInfoViewByFirstAidID(FirstAidInfoView record);

	int selectFirstAidInfoViewByCount(FirstAidInfoView record);
	List<FirstAidInfoView> selectFirstAidHistoryView(FirstAidInfoView record);
	
	int selectFirstAidHistoryViewCount(FirstAidInfoView record);
	
	
}