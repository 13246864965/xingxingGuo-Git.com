package com.cn.hwyl.service;

import java.util.List;

import com.cn.hwyl.pojo.FirstAidInfoView;

public interface IFirstAidInfoViewService {

	List<FirstAidInfoView> selectFirstAidInfoViewByFirstAidID(FirstAidInfoView record);

	int selectFirstAidInfoViewByCount(FirstAidInfoView record);
	
	
	List<FirstAidInfoView> selectFirstAidHistoryView(FirstAidInfoView record);
	
	int selectFirstAidHistoryViewCount(FirstAidInfoView record);
	

}
