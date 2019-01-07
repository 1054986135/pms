package com.zs.sm.exception;
/**
 * 异常类
 * @author Administrator
 *
 */
public class AppException extends Exception {

/**
	 * 
	 */
	private static final long serialVersionUID = -5243848352546754553L;
//	异常编码
  private int errCode;
//  异常信息
  private String errMsg;
  
  /**
   * 代参构造函数
   * @param errCode
   * @param errMsg
   */
public AppException(int errCode, String errMsg) {
	this.errCode = errCode;
	this.errMsg = errMsg;
}


public int getErrCode() {
	return errCode;
}


public void setErrCode(int errCode) {
	this.errCode = errCode;
}


public String getErrMsg() {
	return errMsg;
}


public void setErrMsg(String errMsg) {
	this.errMsg = errMsg;
}
  
}
