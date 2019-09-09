package com.ccms.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ec_voucher_log")
public class EcVoucherLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String mobile;

    private String code;

    /**
     * 券码主表ID
     */
    @Column(name = "main_id")
    private Long mainId;

    /**
     * 4001.券码为空,4002.券码校验不满足后台生成规则,4003.券码在数据库中找不到,4004.券码已过期,4005.券码已冻结（不能领取/兑换）,4006.券码已作废（删除）,4007.券码已被领取/兑换,4008.已超过每批次每人允许领取/兑换张数,4009.已超过券码包实际兑换人数,4010.兑换成功,4011.其它
     */
    @Column(name = "check_result")
    private String checkResult;

    @Column(name = "error_msg")
    private String errorMsg;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

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
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
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
     * 获取4001.券码为空,4002.券码校验不满足后台生成规则,4003.券码在数据库中找不到,4004.券码已过期,4005.券码已冻结（不能领取/兑换）,4006.券码已作废（删除）,4007.券码已被领取/兑换,4008.已超过每批次每人允许领取/兑换张数,4009.已超过券码包实际兑换人数,4010.兑换成功,4011.其它
     *
     * @return check_result - 4001.券码为空,4002.券码校验不满足后台生成规则,4003.券码在数据库中找不到,4004.券码已过期,4005.券码已冻结（不能领取/兑换）,4006.券码已作废（删除）,4007.券码已被领取/兑换,4008.已超过每批次每人允许领取/兑换张数,4009.已超过券码包实际兑换人数,4010.兑换成功,4011.其它
     */
    public String getCheckResult() {
        return checkResult;
    }

    /**
     * 设置4001.券码为空,4002.券码校验不满足后台生成规则,4003.券码在数据库中找不到,4004.券码已过期,4005.券码已冻结（不能领取/兑换）,4006.券码已作废（删除）,4007.券码已被领取/兑换,4008.已超过每批次每人允许领取/兑换张数,4009.已超过券码包实际兑换人数,4010.兑换成功,4011.其它
     *
     * @param checkResult 4001.券码为空,4002.券码校验不满足后台生成规则,4003.券码在数据库中找不到,4004.券码已过期,4005.券码已冻结（不能领取/兑换）,4006.券码已作废（删除）,4007.券码已被领取/兑换,4008.已超过每批次每人允许领取/兑换张数,4009.已超过券码包实际兑换人数,4010.兑换成功,4011.其它
     */
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    /**
     * @return error_msg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return update_date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}