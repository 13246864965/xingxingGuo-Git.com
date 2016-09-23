package com.cn.hwyl.pojo.body;

import java.util.List;

import com.cn.hwyl.pojo.ThrombolysisSurvey;

public class ThrombolysisSurveyBody {

	private ThrombolysisSurvey thrombolysisSurvey;
	private List<ThrombolysisSurvey> thrombolysisSurveyLists;
	private String cFirstaidid;
	
	public String getcFirstaidid() {
		return cFirstaidid;
	}
	public void setcFirstaidid(String cFirstaidid) {
		this.cFirstaidid = cFirstaidid;
	}
	public ThrombolysisSurvey getThrombolysisSurvey() {
		return thrombolysisSurvey;
	}
	public void setThrombolysisSurvey(ThrombolysisSurvey thrombolysisSurvey) {
		this.thrombolysisSurvey = thrombolysisSurvey;
	}
	public List<ThrombolysisSurvey> getThrombolysisSurveyLists() {
		return thrombolysisSurveyLists;
	}
	public void setThrombolysisSurveyLists(List<ThrombolysisSurvey> thrombolysisSurveyLists) {
		this.thrombolysisSurveyLists = thrombolysisSurveyLists;
	}
	
	
}
