package com.ccms.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ec_voucher_detail")
public class EcVoucherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 卡号
     */
    @Column(name = "voucher_code")
    private String voucherCode;

    /**
     * 券码密码
     */
    private String code;

    /**
     * 分隔卡密
     */
    @Column(name = "separate_code")
    private String separateCode;

    /**
     * 券码状态(CANCEL-作废;UNGET-未领取;UNPRINT-未印刷;GOTTEN-已领取;PRINTED-已印刷;USED-已兑换)
     */
    private String status;

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
     * 领取时间
     */
    @Column(name = "get_time")
    private Date getTime;

    /**
     * 领取方式（1 系统发放 ; 2 人工发放 3:其他）
     */
    @Column(name = "get_type")
    private String getType;

    private Integer version;

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
     * 获取分隔卡密
     *
     * @return separate_code - 分隔卡密
     */
    public String getSeparateCode() {
        return separateCode;
    }

    /**
     * 设置分隔卡密
     *
     * @param separateCode 分隔卡密
     */
    public void setSeparateCode(String separateCode) {
        this.separateCode = separateCode;
    }

    /**
     * 获取券码状态(CANCEL-作废;UNGET-未领取;UNPRINT-未印刷;GOTTEN-已领取;PRINTED-已印刷;USED-已兑换)
     *
     * @return status - 券码状态(CANCEL-作废;UNGET-未领取;UNPRINT-未印刷;GOTTEN-已领取;PRINTED-已印刷;USED-已兑换)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置券码状态(CANCEL-作废;UNGET-未领取;UNPRINT-未印刷;GOTTEN-已领取;PRINTED-已印刷;USED-已兑换)
     *
     * @param status 券码状态(CANCEL-作废;UNGET-未领取;UNPRINT-未印刷;GOTTEN-已领取;PRINTED-已印刷;USED-已兑换)
     */
    public void setStatus(String status) {
        this.status = status;
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
     * 获取领取时间
     *
     * @return get_time - 领取时间
     */
    public Date getGetTime() {
        return getTime;
    }

    /**
     * 设置领取时间
     *
     * @param getTime 领取时间
     */
    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    /**
     * 获取领取方式（1 系统发放 ; 2 人工发放 3:其他）
     *
     * @return get_type - 领取方式（1 系统发放 ; 2 人工发放 3:其他）
     */
    public String getGetType() {
        return getType;
    }

    /**
     * 设置领取方式（1 系统发放 ; 2 人工发放 3:其他）
     *
     * @param getType 领取方式（1 系统发放 ; 2 人工发放 3:其他）
     */
    public void setGetType(String getType) {
        this.getType = getType;
    }

    /**
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
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