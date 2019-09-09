package com.ccms.enums;

public enum VoucherEnum {
	//券码分类（1 - 1对于1 券码 ；2 - 多人使用券）
	VOUCHER_TYPE_ONE_TO_ONE("ONE_TO_ONE"),
	VOUCHER_TYPE_ONE_TO_MANY("ONE_TO_MANY"),
    
    //批次状态(0 作废;1 有效 ;2 冻结;3 过期 )
	BATCH_STATUS_CANCEL("CANCEL"),
	BATCH_STATUS_VALID("VALID"),
	BATCH_STATUS_FROZEN("FROZEN"),
	BATCH_STATUS_OVERDUE("OVERDUE"),
	
	//券码状态（0 作废； 1 未领取；2 已领取；3 已兑换未填写收货地址,4 已兑换已 填写地址）
	CODE_STATUS_CANCEL("CANCEL"),
	CODE_STATUS_UNGET("UNGET"),
	CODE_STATUS_GOTTEN("GOTTEN"),
	CODE_STATUS_USED("USED"),
	CODE_STATUS_USED_ADDR("USED_ADDR"),

	//兑换类型,A;B;C
	EXCHANGE_TYPE_XIANGUO("A"),
	EXCHANGE_TYPE_DIKOU("DIKOU"),
	EXCHANGE_TYPE_HONGBAO("HONGBAO");

    private String value;

    private VoucherEnum(String value) {

        this.value = value;

    }
    
    public String getValue() {

        return this.value;

    }
    
    public static void main(String[] args) {
	}
    
}
