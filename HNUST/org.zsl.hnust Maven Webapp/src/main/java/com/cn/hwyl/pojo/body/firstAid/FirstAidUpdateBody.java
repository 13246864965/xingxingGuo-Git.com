package com.cn.hwyl.pojo.body.firstAid;

import com.cn.hwyl.pojo.FirstAid;
import com.cn.hwyl.pojo.FirstAidInfo;
import com.cn.hwyl.pojo.Patients;

public class FirstAidUpdateBody {
	
	private FirstAid firstAid;
	private FirstAidInfo firstAidInfo;
	private Patients patients;
	public FirstAid getFirstAid() {
		return firstAid;
	}
	public void setFirstAid(FirstAid firstAid) {
		this.firstAid = firstAid;
	}
	public FirstAidInfo getFirstAidInfo() {
		return firstAidInfo;
	}
	public void setFirstAidInfo(FirstAidInfo firstAidInfo) {
		this.firstAidInfo = firstAidInfo;
	}
	public Patients getPatients() {
		return patients;
	}
	public void setPatients(Patients patients) {
		this.patients = patients;
	}
	
}
