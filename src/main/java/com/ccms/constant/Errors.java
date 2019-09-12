package com.ccms.constant;

/**
 * 错误信息
 * @author JianguoChen
 *
 */
public class Errors {
	
	public static final String RESPONSE_SUCCESS = "1";
	public static final String RESPONSE_ERROR = "0";

	/**
	 * 通用错误code 以 0xxx 开头
	 */
	public static final String ERROR = "0100"; //失败
	public static final String ERROR_INNER = "0200"; //失败
	public static final String ERROR_QUERY_DATA_EMPTY = "0201"; //没有查询数据
	public static final String ERROR_UNKNOWN = "0101"; //未知错误
	public static final String ERROR_REQUEST = "0102"; //参数错误
	public static final String ERROR_OVERTIME = "0103"; //0103=请求超时请稍后重试
	public static final String ERROR_INTERFACE_SIGN = "0104"; //错误的接口签名
	public static final String ERROR_REPEAT_REQUEST = "0106"; //重复请求
	public static final String ERROR_NOT_ENTRY_UESR = "0107"; //用户未登录
	public static final String ERROR_NOT_PRODUCT = "0108"; //没有符合条件的产品信息
	public static final String ERROR_NOT_PRODUCTTERM = "0109"; //没有符合条件的产品期限信息
	public static final String ERROR_NOT_PRODUCTCOST = "0110"; //没有符合条件的产品费率信息
	public static final String ERROR_NOT_PRODUCTCOSTITEM = "0111"; //没有符合条件的产品费率明细信息
	public static final String ERROR_NOT_PATTEN_MOBILE = "0112"; //手机号码输入有误,请重新输入
	public static final String ERROR_APPLY_INFO_NULL = "0113"; //申请信息异常

	/**
	 * bd
	 */
	public static final String ERROR_BD_BANKCARD_EXIST = "10101"; //银行卡已存在
	public static final String ERROR_BD_BANKCARD_NOT_EXIST = "10102"; //银行卡不存在

	/**
	 * member
	 */
	public static final String ERROR_MEMBER_FAV_SHOP_REPEAT = "10201"; //重复收藏店铺
	public static final String ERROR_MEMBER_ORDER_NOT_EXIST = "10202"; //订单不存在

	public static final String ERROR_USER_NOT_FOUND = "2001"; //用户不存在
	public static final String ERROR_REPEAT_PWD = "2002"; //手机号与登陆密码不匹配
	public static final String ERROR_REPEAT_PWD_OLD = "2003"; //原密码输入错误
	public static final String ERROR_REPEAT_PWD_LOCKED = "2004"; //如果再次输入错误，账号将被冻结
	public static final String ERROR_ACCOUNT_LOCKED = "2005"; //账号锁定，请24小时后再试

	public static final String ERROR_MAX_ERROR_TIMES = "2006"; //次数超限，请24小时后再试
	public static final String ERROR_LOGIN_PWD_LEFT_TIMES = "2007"; //密码输入错误，还可输入%s次

	public static final String ERROR_TIMES_IMG_CODE = "2008"; //获取图形验证码次数超限，请稍后再试
	public static final String ERROR_TIMES_VERIFY_CODE = "2009"; //获取验证码次数超限，请稍后再试


	public static final String ERROR_SEND_MSG = "3017"; //短信发送失败
	public static final String ERROR_REAL_MSG = "4001"; //实名超限


	/**
	 *券码
	 */
	public static final String ERROR_VOUCHER_EMPTY = "4001"; //4001.券码为空
	public static final String ERROR_VOUCHER_INVALID = "4002"; //4002.券码校验不满足后台生成规则
	public static final String ERROR_VOUCHER_NOT_FOUND = "4003"; //4003.券码在数据库中找不到
	public static final String ERROR_VOUCHER_OVERDUE = "4004"; //4004.券码已过期
	public static final String ERROR_VOUCHER_FROZEN = "4005"; //4005.券码已冻结（不能领取/兑换）
	public static final String ERROR_VOUCHER_CANCEL = "4006"; //4006.券码已作废（删除）
	public static final String ERROR_VOUCHER_USED = "4007"; //4007.券码已被领取/兑换 还未填写收货地址
	public static final String ERROR_VOUCHER_EACH_MAX = "4008"; //4008.已超过每批次每人允许领取/兑换张数
	public static final String ERROR_VOUCHER_PACKAGE_MAX = "4009"; //4009.已超过券码包实际兑换人数
//	public static final String ERROR_VOUCHER_SUCCESS = "4010"; //4010.兑换成功
	public static final String ERROR_VOUCHER_USED_ADDR = "4011"; //4011.券码已被领取/兑换 已经填写收货地址
	public static final String ERROR_VOUCHER_CANNOT_CHANGE_ADDR = "4012"; //4012.已发货 不能修改地址
	public static final String ERROR_VOUCHER_EXCHANGE_FAIL = "4099"; //4011.其它)

	/**
	 * 购物车
	 */
	public static final String ERROR_CART_CROSS_MAX_AMT_LIMIT = "5001"; //跨境商品超过海关金额限制
	public static final String ERROR_CART_HAS_WAIT_PAY_ORDER = "5002"; //存在未付款订单
	public static final String ERROR_CART_WAREHOUSE_INSUFFICIENT = "5003"; //商品库存不足

}
