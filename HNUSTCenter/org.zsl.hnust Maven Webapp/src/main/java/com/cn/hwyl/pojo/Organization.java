package com.cn.hwyl.pojo;

import java.util.Date;

import com.cn.hwyl.pojo.request.PageInputContext;

public class Organization extends PageInputContext{
    private String orgId;

    private String orgCode;

    private String orgName;

    private String updateUserId;

    private Date updateTime;

    private String orgState;
    
    //新加
	private String orgType;
	private String parentOrgCode;
	private String gateLoginAccount;
	private String gatePassword;
	private String ospDomain;
	private String country;
	private String province;
	private String region;
	private String city;
	private String orgAddress;
	private String legalPerson;
	private String orgHead;
	private String orgHeadphone;
	private String orderNo;
	private String memo;
	private String netConfigId;
	private String ruleUnit;
    
    private int count;
    
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getOrgState() {
		return orgState;
	}

	public void setOrgState(String orgState) {
		this.orgState = orgState;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getParentOrgCode() {
		return parentOrgCode;
	}

	public void setParentOrgCode(String parentOrgCode) {
		this.parentOrgCode = parentOrgCode;
	}

	public String getGateLoginAccount() {
		return gateLoginAccount;
	}

	public void setGateLoginAccount(String gateLoginAccount) {
		this.gateLoginAccount = gateLoginAccount;
	}

	public String getGatePassword() {
		return gatePassword;
	}

	public void setGatePassword(String gatePassword) {
		this.gatePassword = gatePassword;
	}

	public String getOspDomain() {
		return ospDomain;
	}

	public void setOspDomain(String ospDomain) {
		this.ospDomain = ospDomain;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getOrgHead() {
		return orgHead;
	}

	public void setOrgHead(String orgHead) {
		this.orgHead = orgHead;
	}

	public String getOrgHeadphone() {
		return orgHeadphone;
	}

	public void setOrgHeadphone(String orgHeadphone) {
		this.orgHeadphone = orgHeadphone;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getNetConfigId() {
		return netConfigId;
	}

	public void setNetConfigId(String netConfigId) {
		this.netConfigId = netConfigId;
	}

	public String getRuleUnit() {
		return ruleUnit;
	}

	public void setRuleUnit(String ruleUnit) {
		this.ruleUnit = ruleUnit;
	}

	@Override
	public String toString() {
		return "Organization [orgId=" + orgId + ", orgCode=" + orgCode + ", orgName=" + orgName + ", updateUserId="
				+ updateUserId + ", updateTime=" + updateTime + ", orgState=" + orgState + ", orgType=" + orgType
				+ ", parentOrgCode=" + parentOrgCode + ", gateLoginAccount=" + gateLoginAccount + ", gatePassword="
				+ gatePassword + ", ospDomain=" + ospDomain + ", country=" + country + ", province=" + province
				+ ", region=" + region + ", city=" + city + ", orgAddress=" + orgAddress + ", legalPerson="
				+ legalPerson + ", orgHead=" + orgHead + ", orgHeadphone=" + orgHeadphone + ", orderNo=" + orderNo
				+ ", memo=" + memo + ", netConfigId=" + netConfigId + ", ruleUnit=" + ruleUnit + "]";
	}

}