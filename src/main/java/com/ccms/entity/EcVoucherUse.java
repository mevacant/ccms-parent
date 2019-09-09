package com.ccms.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ec_voucher_use")
public class EcVoucherUse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 年
     */
    private String year;

    /**
     * 券码主表ID
     */
    @Column(name = "main_id")
    private Long mainId;

    /**
     * 券码分类(1对于1 ONE_TO_ONE ；ONE_TO_MANY - 多人使用券)
     */
    @Column(name = "voucher_type")
    private String voucherType;

    /**
     * 兑换类型
     */
    @Column(name = "code_type")
    private String codeType;

    /**
     * 卡号
     */
    @Column(name = "voucher_code")
    private String voucherCode;

    /**
     * 券码密码
     */
    private String code;

    /**
     * 兑换时间
     */
    @Column(name = "use_time")
    private Date useTime;

    @Column(name = "exchange_type")
    private String exchangeType;

    @Column(name = "exchange_id")
    private Long exchangeId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 操作时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 操作人
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户手机号
     *
     * @return mobile - 用户手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置用户手机号
     *
     * @param mobile 用户手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取年
     *
     * @return year - 年
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年
     *
     * @param year 年
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取券码主表ID
     *
     * @return main_id - 券码主表ID
     */
    public Long getMainId() {
        return mainId;
    }

    /**
     * 设置券码主表ID
     *
     * @param mainId 券码主表ID
     */
    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }

    /**
     * 获取券码分类(1对于1 ONE_TO_ONE ；ONE_TO_MANY - 多人使用券)
     *
     * @return voucher_type - 券码分类(1对于1 ONE_TO_ONE ；ONE_TO_MANY - 多人使用券)
     */
    public String getVoucherType() {
        return voucherType;
    }

    /**
     * 设置券码分类(1对于1 ONE_TO_ONE ；ONE_TO_MANY - 多人使用券)
     *
     * @param voucherType 券码分类(1对于1 ONE_TO_ONE ；ONE_TO_MANY - 多人使用券)
     */
    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    /**
     * 获取兑换类型
     *
     * @return code_type - 兑换类型
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * 设置兑换类型
     *
     * @param codeType 兑换类型
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    /**
     * 获取卡号
     *
     * @return voucher_code - 卡号
     */
    public String getVoucherCode() {
        return voucherCode;
    }

    /**
     * 设置卡号
     *
     * @param voucherCode 卡号
     */
    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    /**
     * 获取券码密码
     *
     * @return code - 券码密码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置券码密码
     *
     * @param code 券码密码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取兑换时间
     *
     * @return use_time - 兑换时间
     */
    public Date getUseTime() {
        return useTime;
    }

    /**
     * 设置兑换时间
     *
     * @param useTime 兑换时间
     */
    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    /**
     * @return exchange_type
     */
    public String getExchangeType() {
        return exchangeType;
    }

    /**
     * @param exchangeType
     */
    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    /**
     * @return exchange_id
     */
    public Long getExchangeId() {
        return exchangeId;
    }

    /**
     * @param exchangeId
     */
    public void setExchangeId(Long exchangeId) {
        this.exchangeId = exchangeId;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取操作时间
     *
     * @return update_date - 操作时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置操作时间
     *
     * @param updateDate 操作时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取操作人
     *
     * @return update_by - 操作人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置操作人
     *
     * @param updateBy 操作人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}