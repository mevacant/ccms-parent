package com.ccms.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ec_voucher_address")
public class EcVoucherAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "logic_no")
    private String logicNo;

    @Column(name = "logic_type")
    private String logicType;

    @Column(name = "voucher_code")
    private String voucherCode;

    @Column(name = "addr_id")
    private Long addrId;

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
     * @return voucher_code
     */
    public String getVoucherCode() {
        return voucherCode;
    }

    /**
     * @param voucherCode
     */
    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    /**
     * @return addr_id
     */
    public Long getAddrId() {
        return addrId;
    }

    /**
     * @param addrId
     */
    public void setAddrId(Long addrId) {
        this.addrId = addrId;
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

    public String getLogicNo() {
        return logicNo;
    }

    public void setLogicNo(String logicNo) {
        this.logicNo = logicNo;
    }

    public String getLogicType() {
        return logicType;
    }

    public void setLogicType(String logicType) {
        this.logicType = logicType;
    }
}