package com.cn.hwyl.pojo.response;

import java.io.Serializable;

public class Result extends PageOutputContext implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7509022556814122239L;
	// 必传：1成功，0失败
	private String resultCode = "0";
	
	//	返回具体的错误编码
	private String errorCode;
	
	//返回具体的错误信息
	private String errorInfo;
	
	//返回参数
	private Object obj;
	
//	private PageOutputContext pageOutputContext;
//	
//	public PageOutputContext getPageOutputContext() {
//		return pageOutputContext;
//	}
//	public void setPageOutputContext(PageOutputContext pageOutputContext) {
//		this.pageOutputContext = pageOutputContext;
//	}
	//是否登录成功
	private Boolean isLogin;
	
	public Boolean getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "Result [resultCode=" + resultCode + ", errorCode=" + errorCode + ", resultInfo=" + errorInfo + ", obj="
				+ obj + ", isLogin=" + isLogin + "]";
	}

}
