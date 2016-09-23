package com.cn.hwyl.dao;

import java.util.List;

import com.cn.hwyl.pojo.FirstAidInfoView;

public interface IFirstAidInfoViewDao {
	
	List<FirstAidInfoView> selectFirstAidInfoViewByFirstAidID(FirstAidInfoView record);

	int selectFirstAidInfoViewByCount(FirstAidInfoView record);
}