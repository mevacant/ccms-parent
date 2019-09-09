package com.ccms.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ec_voucher_main")
public class EcVoucherMain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 年
     */
    private String year;

    /**
     * 批次ID
     */
    @Column(name = "batch_id")
    private String batchId;

    /**
     * 券码分类(ONE_TO_ONE:一对一；ONE_TO_MANY:一对多)
     */
    @Column(name = "voucher_type")
    private String voucherType;

    /**
     * 券码类型(A-仙果)
     */
    @Column(name = "code_type")
    private String codeType;

    /**
     * 发放理由
     */
    private String reason;

    /**
     * 券码总张数(一对一,若一对多,为1)
     */
    @Column(name = "code_total")
    private Integer codeTotal;

    /**
     * 分发渠道名称
     */
    @Column(name = "channel_name")
    private String channelName;

    /**
     * 分发渠道编码
     */
    @Column(name = "channel_code")
    private String channelCode;

    /**
     * 状态(CANCEL 作废;VALID 有效)
     */
    @Column(name = "batch_status")
    private String batchStatus;

    /**
     * 有效开始时间
     */
    @Column(name = "begin_time")
    private Date beginTime;

    /**
     * 有效结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "exchange_type")
    private String exchangeType;

    /**
     * 兑换对象id
     */
    @Column(name = "exchange_id")
    private Long exchangeId;

    /**
     * 兑换值
     */
    @Column(name = "exchange_val")
    private String exchangeVal;

    /**
     * 兑换备注
     */
    @Column(name = "exchange_remark")
    private String exchangeRemark;

    /**
     * 每个人的领取数量限制
     */
    @Column(name = "each_allowcount")
    private Integer eachAllowcount;

    @Column(name = "package_code")
    private String packageCode;

    @Column(name = "package_name")
    private String packageName;

    /**
     * 允许使用的数量(一对多)
     */
    @Column(name = "package_allowcount")
    private Integer packageAllowcount;

    /**
     * 已使用数量(一对多)
     */
    @Column(name = "package_usecount")
    private Integer packageUsecount;

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
     * 获取批次ID
     *
     * @return batch_id - 批次ID
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * 设置批次ID
     *
     * @param batchId 批次ID
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    /**
     * 获取券码分类(ONE_TO_ONE:一对一；ONE_TO_MANY:一对多)
     *
     * @return voucher_type - 券码分类(ONE_TO_ONE:一对一；ONE_TO_MANY:一对多)
     */
    public String getVoucherType() {
        return voucherType;
    }

    /**
     * 设置券码分类(ONE_TO_ONE:一对一；ONE_TO_MANY:一对多)
     *
     * @param voucherType 券码分类(ONE_TO_ONE:一对一；ONE_TO_MANY:一对多)
     */
    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    /**
     * 获取券码类型(A-仙果)
     *
     * @return code_type - 券码类型(A-仙果)
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * 设置券码类型(A-仙果)
     *
     * @param codeType 券码类型(A-仙果)
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    /**
     * 获取发放理由
     *
     * @return reason - 发放理由
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置发放理由
     *
     * @param reason 发放理由
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取券码总张数(一对一,若一对多,为1)
     *
     * @return code_total - 券码总张数(一对一,若一对多,为1)
     */
    public Integer getCodeTotal() {
        return codeTotal;
    }

    /**
     * 设置券码总张数(一对一,若一对多,为1)
     *
     * @param codeTotal 券码总张数(一对一,若一对多,为1)
     */
    public void setCodeTotal(Integer codeTotal) {
        this.codeTotal = codeTotal;
    }

    /**
     * 获取分发渠道名称
     *
     * @return channel_name - 分发渠道名称
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 设置分发渠道名称
     *
     * @param channelName 分发渠道名称
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * 获取分发渠道编码
     *
     * @return channel_code - 分发渠道编码
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * 设置分发渠道编码
     *
     * @param channelCode 分发渠道编码
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    /**
     * 获取状态(CANCEL 作废;VALID 有效)
     *
     * @return batch_status - 状态(CANCEL 作废;VALID 有效)
     */
    public String getBatchStatus() {
        return batchStatus;
    }

    /**
     * 设置状态(CANCEL 作废;VALID 有效)
     *
     * @param batchStatus 状态(CANCEL 作废;VALID 有效)
     */
    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    /**
     * 获取有效开始时间
     *
     * @return begin_time - 有效开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 设置有效开始时间
     *
     * @param beginTime 有效开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取有效结束时间
     *
     * @return end_time - 有效结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置有效结束时间
     *
     * @param endTime 有效结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
     * 获取兑换对象id
     *
     * @return exchange_id - 兑换对象id
     */
    public Long getExchangeId() {
        return exchangeId;
    }

    /**
     * 设置兑换对象id
     *
     * @param exchangeId 兑换对象id
     */
    public void setExchangeId(Long exchangeId) {
        this.exchangeId = exchangeId;
    }

    /**
     * 获取兑换值
     *
     * @return exchange_val - 兑换值
     */
    public String getExchangeVal() {
        return exchangeVal;
    }

    /**
     * 设置兑换值
     *
     * @param exchangeVal 兑换值
     */
    public void setExchangeVal(String exchangeVal) {
        this.exchangeVal = exchangeVal;
    }

    /**
     * 获取兑换备注
     *
     * @return exchange_remark - 兑换备注
     */
    public String getExchangeRemark() {
        return exchangeRemark;
    }

    /**
     * 设置兑换备注
     *
     * @param exchangeRemark 兑换备注
     */
    public void setExchangeRemark(String exchangeRemark) {
        this.exchangeRemark = exchangeRemark;
    }

    /**
     * 获取每个人的领取数量限制
     *
     * @return each_allowcount - 每个人的领取数量限制
     */
    public Integer getEachAllowcount() {
        return eachAllowcount;
    }

    /**
     * 设置每个人的领取数量限制
     *
     * @param eachAllowcount 每个人的领取数量限制
     */
    public void setEachAllowcount(Integer eachAllowcount) {
        this.eachAllowcount = eachAllowcount;
    }

    /**
     * @return package_code
     */
    public String getPackageCode() {
        return packageCode;
    }

    /**
     * @param packageCode
     */
    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    /**
     * @return package_name
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * @param packageName
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * 获取允许使用的数量(一对多)
     *
     * @return package_allowcount - 允许使用的数量(一对多)
     */
    public Integer getPackageAllowcount() {
        return packageAllowcount;
    }

    /**
     * 设置允许使用的数量(一对多)
     *
     * @param packageAllowcount 允许使用的数量(一对多)
     */
    public void setPackageAllowcount(Integer packageAllowcount) {
        this.packageAllowcount = packageAllowcount;
    }

    /**
     * 获取已使用数量(一对多)
     *
     * @return package_usecount - 已使用数量(一对多)
     */
    public Integer getPackageUsecount() {
        return packageUsecount;
    }

    /**
     * 设置已使用数量(一对多)
     *
     * @param packageUsecount 已使用数量(一对多)
     */
    public void setPackageUsecount(Integer packageUsecount) {
        this.packageUsecount = packageUsecount;
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