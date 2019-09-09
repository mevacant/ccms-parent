package com.ccms.exception;



/**
 * 运行时异常，遇到该异常应该抛出异常信息
 * @author JianguoChen
 *
 */
public class RollBackException extends RuntimeException {

	 
	protected String msg;

	/**
	 * 具体异常码
	 */
	protected String code;

	public RollBackException(String code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}

	public RollBackException() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public String getCode() {
		return code;
	}

	/**
	 * 实例化异常
	 * 
	 * @param msgFormat
	 * @param args
	 * @return
	 */
	public RollBackException newInstance(String msgFormat, Object... args) {
		return new RollBackException(this.code, msgFormat, args);
	}

	public RollBackException(String message, Throwable cause) {
		super(message, cause);
	}

	public RollBackException(Throwable cause) {
		super(cause);
	}

	public RollBackException(String code) {
		this.code = code;
	}
}
