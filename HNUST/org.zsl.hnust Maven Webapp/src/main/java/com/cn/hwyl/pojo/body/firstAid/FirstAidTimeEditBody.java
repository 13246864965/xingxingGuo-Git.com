package com.cn.hwyl.pojo.body.firstAid;

import java.util.List;

import com.cn.hwyl.pojo.FirstAidTime;

public class FirstAidTimeEditBody {
	private FirstAidTime firstAidTime;
	private List<FirstAidTime> firstAidTimeLists;
	public FirstAidTime getFirstAidTime() {
		return firstAidTime;
	}
	public void setFirstAidTime(FirstAidTime firstAidTime) {
		this.firstAidTime = firstAidTime;
	}
	public List<FirstAidTime> getFirstAidTimeLists() {
		return firstAidTimeLists;
	}
	public void setFirstAidTimeLists(List<FirstAidTime> firstAidTimeLists) {
		this.firstAidTimeLists = firstAidTimeLists;
	}
	
}
