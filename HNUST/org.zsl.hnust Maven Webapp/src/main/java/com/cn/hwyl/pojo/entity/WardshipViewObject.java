package com.cn.hwyl.pojo.entity;

public class WardshipViewObject {

	private String wardshipId;// 合同号
	private String userName;// 用户名称
	private String sex;// 性别，见附录 3.1.1
	private String year;// 年龄
	private String relationPhone;// 联系人电话
	private String urgentMan;// 紧急联系人
	private String urgentManPhone;// 紧急联系人电话
	private String orgCode;// 机构代码
	private String orgName;// 机构名称
	private String createTime;// 创建时间
	private String serviceEndTime;// 服务结束时间
	private String realReturnTime;// 实际归还时间
	private String certNo;// 身份证号
	private String labelNo;// 标签号

	public String getWardshipId() {
		return wardshipId;
	}

	public void setWardshipId(String wardshipId) {
		this.wardshipId = wardshipId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex=="男"?"F":"M";
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRelationPhone() {
		return relationPhone;
	}

	public void setRelationPhone(String relationPhone) {
		this.relationPhone = relationPhone;
	}

	public String getUrgentMan() {
		return urgentMan;
	}

	public void setUrgentMan(String urgentMan) {
		this.urgentMan = urgentMan;
	}

	public String getUrgentManPhone() {
		return urgentManPhone;
	}

	public void setUrgentManPhone(String urgentManPhone) {
		this.urgentManPhone = urgentManPhone;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getServiceEndTime() {
		return serviceEndTime;
	}

	public void setServiceEndTime(String serviceEndTime) {
		this.serviceEndTime = serviceEndTime;
	}

	public String getRealReturnTime() {
		return realReturnTime;
	}

	public void setRealReturnTime(String realReturnTime) {
		this.realReturnTime = realReturnTime;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getLabelNo() {
		return labelNo;
	}

	public void setLabelNo(String labelNo) {
		this.labelNo = labelNo;
	}
}
