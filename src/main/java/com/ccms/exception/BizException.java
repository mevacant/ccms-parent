package com.ccms.exception;



/**
 * 业务异常基类，所有业务异常都必须继承于此异常
 * 
 *         定义异常时，需要先确定异常所属模块。例如：绑定银行卡报错 可以定义为 [10040001] 前四位数为系统模块编号，后4位为错误代码 ,唯一 <br>
 *         支付规则业务异常 1002 <br>
 *         银行卡业务异常 1004 <br>
 *         交易业务异常 1005 <br>
 *         福利业务异常 1006 <br>
 *         通用异常 9004  <br>
 */
public class BizException extends Exception {

	 
	protected String msg;

	/**
	 * 具体异常码
	 */
	protected String code;

	public BizException(String code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}

	public BizException() {
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
	public BizException newInstance(String msgFormat, Object... args) {
		return new BizException(this.code, msgFormat, args);
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(Throwable cause) {
		super(cause);
	}

	public BizException(String code) {
		this.code = code;
	}
}
