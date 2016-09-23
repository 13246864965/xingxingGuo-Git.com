package com.cn.hwyl.pojo.body.firstAid;

import com.cn.hwyl.pojo.FirstAid;
import com.cn.hwyl.pojo.FirstaidHistory;
import com.cn.hwyl.pojo.FirstaidResults;

public class FirstAidResultsBody {
	private FirstAid firstAid;
	private FirstaidHistory firstaidHistory;
	private FirstaidResults firstaidResults;
	public FirstAid getFirstAid() {
		return firstAid;
	}
	public void setFirstAid(FirstAid firstAid) {
		this.firstAid = firstAid;
	}
	public FirstaidHistory getFirstaidHistory() {
		return firstaidHistory;
	}
	public void setFirstaidHistory(FirstaidHistory firstaidHistory) {
		this.firstaidHistory = firstaidHistory;
	}
	public FirstaidResults getFirstaidResults() {
		return firstaidResults;
	}
	public void setFirstaidResults(FirstaidResults firstaidResults) {
		this.firstaidResults = firstaidResults;
	}

	
	
}
