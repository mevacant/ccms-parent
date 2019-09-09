package com.ccms.vo;


import com.alibaba.fastjson.JSON;
import com.ccms.constant.Errors;
import com.ccms.util.ReadProperties;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * app返回response entity
 */
public class AppRspObject<T>  implements Serializable{

	private static final long serialVersionUID = 5376493909622407337L;

	private String success;
	private T data ;
	private ErrorVo error;
	private String signType;
	private String sign;
	private String timeStamp;


	//public static ReadProperties readProperties = ReadProperties.getInst("Message");

	public static <T> AppRspObject<T> createSuccRsp(T obj) {
		AppRspObject<T> rspObject = new AppRspObject<T>(obj);
		return rspObject;
	}

	public static AppRspObject createFailRsp(String errorCode) {
		return new AppRspObject(errorCode, null);
	}

	public static AppRspObject createFailRsp(String errorCode, String errorMessage) {
		return new AppRspObject(errorCode, errorMessage);
	}


	public AppRspObject() {
		this.success = Errors.RESPONSE_SUCCESS;
		this.timeStamp = String.valueOf(System.currentTimeMillis());
	}


	private AppRspObject(T obj) {
		this.success = Errors.RESPONSE_SUCCESS;
		this.data = obj;
		this.error = null;
		this.timeStamp = String.valueOf(System.currentTimeMillis());
	}

	private AppRspObject(String errorCode, String errorMessage) {
		this.success = Errors.RESPONSE_ERROR;
		this.data = null;
		this.timeStamp = String.valueOf(System.currentTimeMillis());
		ErrorVo errorVo = new ErrorVo();
		errorVo.setCode(errorCode);
		if (StringUtils.isNotBlank(errorMessage))
			errorVo.setMessage(errorMessage);
//		else
//			errorVo.setMessage(readProperties.getValuesByKey("Message", errorCode));
		this.error = errorVo;
	}


	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}


	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ErrorVo getError() {
		return error;
	}
	public void setError(ErrorVo error) {
		this.error = error;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
