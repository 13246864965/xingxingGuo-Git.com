package com.cn.hwyl.pojo;

public class HospitalServiceCenter extends Channel{
    private String serviceCenterCode;

//    private String netConfigId;

    private String centerType;

    private String serviceCenterGroupCode;

    private String serviceCenterGroupName;

    private String netSolutionTemplate;
    
    private String roleId;

    
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getServiceCenterCode() {
		return serviceCenterCode;
	}

	public void setServiceCenterCode(String serviceCenterCode) {
		this.serviceCenterCode = serviceCenterCode;
	}


	public String getCenterType() {
		return centerType;
	}

	public void setCenterType(String centerType) {
		this.centerType = centerType;
	}


	public String getServiceCenterGroupCode() {
		return serviceCenterGroupCode;
	}

	public void setServiceCenterGroupCode(String serviceCenterGroupCode) {
		this.serviceCenterGroupCode = serviceCenterGroupCode;
	}

	public String getServiceCenterGroupName() {
		return serviceCenterGroupName;
	}

	public void setServiceCenterGroupName(String serviceCenterGroupName) {
		this.serviceCenterGroupName = serviceCenterGroupName;
	}

	public String getNetSolutionTemplate() {
		return netSolutionTemplate;
	}

	public void setNetSolutionTemplate(String netSolutionTemplate) {
		this.netSolutionTemplate = netSolutionTemplate;
	}

	@Override
	public String toString() {
		return "HospitalServiceCenter [serviceCenterCode=" + serviceCenterCode + ", centerType=" + centerType
				+ ", serviceCenterGroupCode=" + serviceCenterGroupCode + ", serviceCenterGroupName="
				+ serviceCenterGroupName + ", netSolutionTemplate=" + netSolutionTemplate + "]";
	}

}