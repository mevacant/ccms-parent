package com.ccms.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ec_page_templete_property")
public class EcPageTempleteProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 模板id
     */
    @Column(name = "templete_id")
    private Long templeteId;

    /**
     * 属性key
     */
    private String type;

    /**
     * 属性value
     */
    private String value;

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
     * 获取模板id
     *
     * @return templete_id - 模板id
     */
    public Long getTempleteId() {
        return templeteId;
    }

    /**
     * 设置模板id
     *
     * @param templeteId 模板id
     */
    public void setTempleteId(Long templeteId) {
        this.templeteId = templeteId;
    }

    /**
     * 获取属性key
     *
     * @return type - 属性key
     */
    public String getType() {
        return type;
    }

    /**
     * 设置属性key
     *
     * @param type 属性key
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取属性value
     *
     * @return value - 属性value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置属性value
     *
     * @param value 属性value
     */
    public void setValue(String value) {
        this.value = value;
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