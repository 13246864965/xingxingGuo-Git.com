package com.cn.hwyl.service;
/**
 * 请求心电数据  callback
 * @author lahm
 *
 */
public interface HttpRedDataListener {
//	void HttpRedDataFailure();
	String HttpRedDataSuccess(String result);
}
