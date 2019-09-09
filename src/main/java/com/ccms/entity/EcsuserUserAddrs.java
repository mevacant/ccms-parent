package com.ccms.entity;

import javax.persistence.*;

@Table(name = "ecsuser_user_addrs")
public class EcsuserUserAddrs {
    /**
     * 会员地址ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "addr_id")
    private Integer addrId;

    /**
     * 会员ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 会员名称
     */
    private String name;

    /**
     * 地区
     */
    private String area;

    /**
     * 地址
     */
    private String addr;

    /**
     * 邮编
     */
    private String zip;

    /**
     * 电话
     */
    private String tel;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 默认地址
     */
    @Column(name = "def_addr")
    private Boolean defAddr;

    /**
     * 收货人身份证号码
     */
    @Column(name = "person_id")
    private String personId;

    /**
     * 收货人身份证正反面照
     */
    @Column(name = "person_id_card")
    private String personIdCard;

    /**
     * 默认  0否，1是
     */
    @Column(name = "is_real_name")
    private Boolean isRealName;

    /**
     * 获取会员地址ID
     *
     * @return addr_id - 会员地址ID
     */
    public Integer getAddrId() {
        return addrId;
    }

    /**
     * 设置会员地址ID
     *
     * @param addrId 会员地址ID
     */
    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    /**
     * 获取会员ID
     *
     * @return user_id - 会员ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置会员ID
     *
     * @param userId 会员ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取会员名称
     *
     * @return name - 会员名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置会员名称
     *
     * @param name 会员名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取地区
     *
     * @return area - 地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区
     *
     * @param area 地区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取地址
     *
     * @return addr - 地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置地址
     *
     * @param addr 地址
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 获取邮编
     *
     * @return zip - 邮编
     */
    public String getZip() {
        return zip;
    }

    /**
     * 设置邮编
     *
     * @param zip 邮编
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * 获取电话
     *
     * @return tel - 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话
     *
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取手机
     *
     * @return mobile - 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取默认地址
     *
     * @return def_addr - 默认地址
     */
    public Boolean getDefAddr() {
        return defAddr;
    }

    /**
     * 设置默认地址
     *
     * @param defAddr 默认地址
     */
    public void setDefAddr(Boolean defAddr) {
        this.defAddr = defAddr;
    }

    /**
     * 获取收货人身份证号码
     *
     * @return person_id - 收货人身份证号码
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * 设置收货人身份证号码
     *
     * @param personId 收货人身份证号码
     */
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * 获取收货人身份证正反面照
     *
     * @return person_id_card - 收货人身份证正反面照
     */
    public String getPersonIdCard() {
        return personIdCard;
    }

    /**
     * 设置收货人身份证正反面照
     *
     * @param personIdCard 收货人身份证正反面照
     */
    public void setPersonIdCard(String personIdCard) {
        this.personIdCard = personIdCard;
    }

    /**
     * 获取默认  0否，1是
     *
     * @return is_real_name - 默认  0否，1是
     */
    public Boolean getIsRealName() {
        return isRealName;
    }

    /**
     * 设置默认  0否，1是
     *
     * @param isRealName 默认  0否，1是
     */
    public void setIsRealName(Boolean isRealName) {
        this.isRealName = isRealName;
    }
}