package com.cn.hwyl.pojo.body;

public class UploadThreadBody {
	private String wardshipId;
	private String Key = "HLJW2014";
	private String ptime;

	public String getWardshipId() {
		return wardshipId;
	}

	public void setWardshipId(String wardshipId) {
		this.wardshipId = wardshipId;
	}

	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	public String getPtime() {
		return ptime;
	}

	public void setPtime(String ptime) {
		this.ptime = ptime;
	}

	@Override
	public String toString() {
		return "UploadThreadBody [wardshipId=" + wardshipId + ", Key=" + Key + ", ptime=" + ptime + "]";
	}

}
