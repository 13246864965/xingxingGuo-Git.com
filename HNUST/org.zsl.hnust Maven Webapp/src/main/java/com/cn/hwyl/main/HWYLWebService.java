package com.cn.hwyl.main;  
  
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.log4j.Logger;

import com.cn.hwyl.pojo.response.Result;
import com.google.gson.Gson;  
  
public class HWYLWebService {

	private static Logger logger = Logger.getLogger(HWYLWebService.class);

	public static String getWSDL(String wsdlUrl, String nameSpace, String method, String head, String body) {

		Gson gson = new Gson();
		Result result = new Result();
		Service service = new Service();

		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(wsdlUrl);

			// 设置operation 名称，
			call.setOperationName(new QName(nameSpace, method));

			// 设置账户，注意参数为XSD_LONG
			call.addParameter("head", org.apache.axis.Constants.XSD_LONG, ParameterMode.IN);
			call.addParameter("body", org.apache.axis.Constants.XSD_LONG, ParameterMode.IN);
			// 设置返回类型为String
			call.setReturnClass(String.class);

			// 设置返回类型为String
			call.setReturnClass(String.class);

			return (String) call.invoke(new Object[] { head, body });
		} catch (Exception e) {
			logger.error("调用" + method + "()出错" + e.getMessage());
			result.setResultCode("0");
			result.setErrorInfo("调用" + method + "()出错" + e.getMessage());
			return gson.toJson(result);
		}
	}

}  