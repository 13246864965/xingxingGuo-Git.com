package com.cn.hwyl.pojo.request;

import java.io.Serializable;

public class HeadRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String platId;
	private String authorKey;
	private String token;
	private String service;
	public String getPlatId() {
		return platId;
	}
	public void setPlatId(String platId) {
		this.platId = platId;
	}
	public String getAuthorKey() {
		return authorKey;
	}
	public void setAuthorKey(String authorKey) {
		this.authorKey = authorKey;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	@Override
	public String toString() {
		return "HeadRequest [platId=" + platId + ", authorKey=" + authorKey + ", token=" + token + ", service="
				+ service + "]";
	}

}
