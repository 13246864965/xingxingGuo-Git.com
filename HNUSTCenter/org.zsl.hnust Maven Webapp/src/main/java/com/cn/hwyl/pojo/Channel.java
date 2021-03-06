package com.cn.hwyl.pojo;

public class Channel extends Organization{
    private String channelCode;

    private String contractNo;

    private String channelType;

    private String makeType;

    private String makeOrgnize;

    private String friendOrgnize;
    

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getMakeType() {
		return makeType;
	}

	public void setMakeType(String makeType) {
		this.makeType = makeType;
	}

	public String getMakeOrgnize() {
		return makeOrgnize;
	}

	public void setMakeOrgnize(String makeOrgnize) {
		this.makeOrgnize = makeOrgnize;
	}

	public String getFriendOrgnize() {
		return friendOrgnize;
	}

	public void setFriendOrgnize(String friendOrgnize) {
		this.friendOrgnize = friendOrgnize;
	}

	@Override
	public String toString() {
		return "Channel [channelCode=" + channelCode + ", contractNo=" + contractNo + ", channelType=" + channelType
				+ ", makeType=" + makeType + ", makeOrgnize=" + makeOrgnize + ", friendOrgnize=" + friendOrgnize + "]";
	}

}