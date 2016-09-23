package com.cn.hwyl.pojo.body.firstAid;

import com.cn.hwyl.pojo.DeviceUpdate;
import com.cn.hwyl.pojo.FirstAid;
import com.cn.hwyl.pojo.FirstAidInfo;
import com.cn.hwyl.pojo.Patients;

public class FirstAidAddBody {
	
	
	private FirstAid firstAid;
	private FirstAidInfo firstAidInfo;
	private Patients patients;
	
	private DeviceUpdate deviceUpdate;
	
	
	
	public DeviceUpdate getDeviceUpdate() {
		return deviceUpdate;
	}
	public void setDeviceUpdate(DeviceUpdate deviceUpdate) {
		this.deviceUpdate = deviceUpdate;
	}
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
