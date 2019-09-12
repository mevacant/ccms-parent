package com.ccms.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_dict_data")
public class SysDictData {
    /**
     * 字典编码
     */
    @Id
    @Column(name = "dict_code")
    private String dictCode;

    /**
     * 父级编号
     */
    @Column(name = "parent_code")
    private String parentCode;

    /**
     * 所有父级编号
     */
    @Column(name = "parent_codes")
    private String parentCodes;

    /**
     * 本级排序号（升序）
     */
    @Column(name = "tree_sort")
    private Long treeSort;

    /**
     * 所有级别排序号
     */
    @Column(name = "tree_sorts")
    private String treeSorts;

    /**
     * 是否最末级
     */
    @Column(name = "tree_leaf")
    private String treeLeaf;

    /**
     * 层次级别
     */
    @Column(name = "tree_level")
    private Short treeLevel;

    /**
     * 全节点名
     */
    @Column(name = "tree_names")
    private String treeNames;

    /**
     * 字典标签
     */
    @Column(name = "dict_label")
    private String dictLabel;

    /**
     * 字典键值
     */
    @Column(name = "dict_value")
    private String dictValue;

    /**
     * 字典类型
     */
    @Column(name = "dict_type")
    private String dictType;

    /**
     * 系统内置（1是 0否）
     */
    @Column(name = "is_sys")
    private String isSys;

    /**
     * 字典描述
     */
    private String description;

    /**
     * css样式（如：color:red)
     */
    @Column(name = "css_style")
    private String cssStyle;

    /**
     * css类名（如：red）
     */
    @Column(name = "css_class")
    private String cssClass;

    /**
     * 状态（0正常 1删除 2停用）
     */
    private String status;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 租户代码
     */
    @Column(name = "corp_code")
    private String corpCode;

    /**
     * 租户名称
     */
    @Column(name = "corp_name")
    private String corpName;

    /**
     * 扩展 String 1
     */
    @Column(name = "extend_s1")
    private String extendS1;

    /**
     * 扩展 String 2
     */
    @Column(name = "extend_s2")
    private String extendS2;

    /**
     * 扩展 String 3
     */
    @Column(name = "extend_s3")
    private String extendS3;

    /**
     * 扩展 String 4
     */
    @Column(name = "extend_s4")
    private String extendS4;

    /**
     * 扩展 String 5
     */
    @Column(name = "extend_s5")
    private String extendS5;

    /**
     * 扩展 String 6
     */
    @Column(name = "extend_s6")
    private String extendS6;

    /**
     * 扩展 String 7
     */
    @Column(name = "extend_s7")
    private String extendS7;

    /**
     * 扩展 String 8
     */
    @Column(name = "extend_s8")
    private String extendS8;

    /**
     * 扩展 Integer 1
     */
    @Column(name = "extend_i1")
    private BigDecimal extendI1;

    /**
     * 扩展 Integer 2
     */
    @Column(name = "extend_i2")
    private BigDecimal extendI2;

    /**
     * 扩展 Integer 3
     */
    @Column(name = "extend_i3")
    private BigDecimal extendI3;

    /**
     * 扩展 Integer 4
     */
    @Column(name = "extend_i4")
    private BigDecimal extendI4;

    /**
     * 扩展 Float 1
     */
    @Column(name = "extend_f1")
    private BigDecimal extendF1;

    /**
     * 扩展 Float 2
     */
    @Column(name = "extend_f2")
    private BigDecimal extendF2;

    /**
     * 扩展 Float 3
     */
    @Column(name = "extend_f3")
    private BigDecimal extendF3;

    /**
     * 扩展 Float 4
     */
    @Column(name = "extend_f4")
    private BigDecimal extendF4;

    /**
     * 扩展 Date 1
     */
    @Column(name = "extend_d1")
    private Date extendD1;

    /**
     * 扩展 Date 2
     */
    @Column(name = "extend_d2")
    private Date extendD2;

    /**
     * 扩展 Date 3
     */
    @Column(name = "extend_d3")
    private Date extendD3;

    /**
     * 扩展 Date 4
     */
    @Column(name = "extend_d4")
    private Date extendD4;

    /**
     * 获取字典编码
     *
     * @return dict_code - 字典编码
     */
    public String getDictCode() {
        return dictCode;
    }

    /**
     * 设置字典编码
     *
     * @param dictCode 字典编码
     */
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    /**
     * 获取父级编号
     *
     * @return parent_code - 父级编号
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 设置父级编号
     *
     * @param parentCode 父级编号
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * 获取所有父级编号
     *
     * @return parent_codes - 所有父级编号
     */
    public String getParentCodes() {
        return parentCodes;
    }

    /**
     * 设置所有父级编号
     *
     * @param parentCodes 所有父级编号
     */
    public void setParentCodes(String parentCodes) {
        this.parentCodes = parentCodes;
    }

    /**
     * 获取本级排序号（升序）
     *
     * @return tree_sort - 本级排序号（升序）
     */
    public Long getTreeSort() {
        return treeSort;
    }

    /**
     * 设置本级排序号（升序）
     *
     * @param treeSort 本级排序号（升序）
     */
    public void setTreeSort(Long treeSort) {
        this.treeSort = treeSort;
    }

    /**
     * 获取所有级别排序号
     *
     * @return tree_sorts - 所有级别排序号
     */
    public String getTreeSorts() {
        return treeSorts;
    }

    /**
     * 设置所有级别排序号
     *
     * @param treeSorts 所有级别排序号
     */
    public void setTreeSorts(String treeSorts) {
        this.treeSorts = treeSorts;
    }

    /**
     * 获取是否最末级
     *
     * @return tree_leaf - 是否最末级
     */
    public String getTreeLeaf() {
        return treeLeaf;
    }

    /**
     * 设置是否最末级
     *
     * @param treeLeaf 是否最末级
     */
    public void setTreeLeaf(String treeLeaf) {
        this.treeLeaf = treeLeaf;
    }

    /**
     * 获取层次级别
     *
     * @return tree_level - 层次级别
     */
    public Short getTreeLevel() {
        return treeLevel;
    }

    /**
     * 设置层次级别
     *
     * @param treeLevel 层次级别
     */
    public void setTreeLevel(Short treeLevel) {
        this.treeLevel = treeLevel;
    }

    /**
     * 获取全节点名
     *
     * @return tree_names - 全节点名
     */
    public String getTreeNames() {
        return treeNames;
    }

    /**
     * 设置全节点名
     *
     * @param treeNames 全节点名
     */
    public void setTreeNames(String treeNames) {
        this.treeNames = treeNames;
    }

    /**
     * 获取字典标签
     *
     * @return dict_label - 字典标签
     */
    public String getDictLabel() {
        return dictLabel;
    }

    /**
     * 设置字典标签
     *
     * @param dictLabel 字典标签
     */
    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    /**
     * 获取字典键值
     *
     * @return dict_value - 字典键值
     */
    public String getDictValue() {
        return dictValue;
    }

    /**
     * 设置字典键值
     *
     * @param dictValue 字典键值
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    /**
     * 获取字典类型
     *
     * @return dict_type - 字典类型
     */
    public String getDictType() {
        return dictType;
    }

    /**
     * 设置字典类型
     *
     * @param dictType 字典类型
     */
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    /**
     * 获取系统内置（1是 0否）
     *
     * @return is_sys - 系统内置（1是 0否）
     */
    public String getIsSys() {
        return isSys;
    }

    /**
     * 设置系统内置（1是 0否）
     *
     * @param isSys 系统内置（1是 0否）
     */
    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

    /**
     * 获取字典描述
     *
     * @return description - 字典描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置字典描述
     *
     * @param description 字典描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取css样式（如：color:red)
     *
     * @return css_style - css样式（如：color:red)
     */
    public String getCssStyle() {
        return cssStyle;
    }

    /**
     * 设置css样式（如：color:red)
     *
     * @param cssStyle css样式（如：color:red)
     */
    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }

    /**
     * 获取css类名（如：red）
     *
     * @return css_class - css类名（如：red）
     */
    public String getCssClass() {
        return cssClass;
    }

    /**
     * 设置css类名（如：red）
     *
     * @param cssClass css类名（如：red）
     */
    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    /**
     * 获取状态（0正常 1删除 2停用）
     *
     * @return status - 状态（0正常 1删除 2停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1删除 2停用）
     *
     * @param status 状态（0正常 1删除 2停用）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取备注信息
     *
     * @return remarks - 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注信息
     *
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取租户代码
     *
     * @return corp_code - 租户代码
     */
    public String getCorpCode() {
        return corpCode;
    }

    /**
     * 设置租户代码
     *
     * @param corpCode 租户代码
     */
    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

    /**
     * 获取租户名称
     *
     * @return corp_name - 租户名称
     */
    public String getCorpName() {
        return corpName;
    }

    /**
     * 设置租户名称
     *
     * @param corpName 租户名称
     */
    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    /**
     * 获取扩展 String 1
     *
     * @return extend_s1 - 扩展 String 1
     */
    public String getExtendS1() {
        return extendS1;
    }

    /**
     * 设置扩展 String 1
     *
     * @param extendS1 扩展 String 1
     */
    public void setExtendS1(String extendS1) {
        this.extendS1 = extendS1;
    }

    /**
     * 获取扩展 String 2
     *
     * @return extend_s2 - 扩展 String 2
     */
    public String getExtendS2() {
        return extendS2;
    }

    /**
     * 设置扩展 String 2
     *
     * @param extendS2 扩展 String 2
     */
    public void setExtendS2(String extendS2) {
        this.extendS2 = extendS2;
    }

    /**
     * 获取扩展 String 3
     *
     * @return extend_s3 - 扩展 String 3
     */
    public String getExtendS3() {
        return extendS3;
    }

    /**
     * 设置扩展 String 3
     *
     * @param extendS3 扩展 String 3
     */
    public void setExtendS3(String extendS3) {
        this.extendS3 = extendS3;
    }

    /**
     * 获取扩展 String 4
     *
     * @return extend_s4 - 扩展 String 4
     */
    public String getExtendS4() {
        return extendS4;
    }

    /**
     * 设置扩展 String 4
     *
     * @param extendS4 扩展 String 4
     */
    public void setExtendS4(String extendS4) {
        this.extendS4 = extendS4;
    }

    /**
     * 获取扩展 String 5
     *
     * @return extend_s5 - 扩展 String 5
     */
    public String getExtendS5() {
        return extendS5;
    }

    /**
     * 设置扩展 String 5
     *
     * @param extendS5 扩展 String 5
     */
    public void setExtendS5(String extendS5) {
        this.extendS5 = extendS5;
    }

    /**
     * 获取扩展 String 6
     *
     * @return extend_s6 - 扩展 String 6
     */
    public String getExtendS6() {
        return extendS6;
    }

    /**
     * 设置扩展 String 6
     *
     * @param extendS6 扩展 String 6
     */
    public void setExtendS6(String extendS6) {
        this.extendS6 = extendS6;
    }

    /**
     * 获取扩展 String 7
     *
     * @return extend_s7 - 扩展 String 7
     */
    public String getExtendS7() {
        return extendS7;
    }

    /**
     * 设置扩展 String 7
     *
     * @param extendS7 扩展 String 7
     */
    public void setExtendS7(String extendS7) {
        this.extendS7 = extendS7;
    }

    /**
     * 获取扩展 String 8
     *
     * @return extend_s8 - 扩展 String 8
     */
    public String getExtendS8() {
        return extendS8;
    }

    /**
     * 设置扩展 String 8
     *
     * @param extendS8 扩展 String 8
     */
    public void setExtendS8(String extendS8) {
        this.extendS8 = extendS8;
    }

    /**
     * 获取扩展 Integer 1
     *
     * @return extend_i1 - 扩展 Integer 1
     */
    public BigDecimal getExtendI1() {
        return extendI1;
    }

    /**
     * 设置扩展 Integer 1
     *
     * @param extendI1 扩展 Integer 1
     */
    public void setExtendI1(BigDecimal extendI1) {
        this.extendI1 = extendI1;
    }

    /**
     * 获取扩展 Integer 2
     *
     * @return extend_i2 - 扩展 Integer 2
     */
    public BigDecimal getExtendI2() {
        return extendI2;
    }

    /**
     * 设置扩展 Integer 2
     *
     * @param extendI2 扩展 Integer 2
     */
    public void setExtendI2(BigDecimal extendI2) {
        this.extendI2 = extendI2;
    }

    /**
     * 获取扩展 Integer 3
     *
     * @return extend_i3 - 扩展 Integer 3
     */
    public BigDecimal getExtendI3() {
        return extendI3;
    }

    /**
     * 设置扩展 Integer 3
     *
     * @param extendI3 扩展 Integer 3
     */
    public void setExtendI3(BigDecimal extendI3) {
        this.extendI3 = extendI3;
    }

    /**
     * 获取扩展 Integer 4
     *
     * @return extend_i4 - 扩展 Integer 4
     */
    public BigDecimal getExtendI4() {
        return extendI4;
    }

    /**
     * 设置扩展 Integer 4
     *
     * @param extendI4 扩展 Integer 4
     */
    public void setExtendI4(BigDecimal extendI4) {
        this.extendI4 = extendI4;
    }

    /**
     * 获取扩展 Float 1
     *
     * @return extend_f1 - 扩展 Float 1
     */
    public BigDecimal getExtendF1() {
        return extendF1;
    }

    /**
     * 设置扩展 Float 1
     *
     * @param extendF1 扩展 Float 1
     */
    public void setExtendF1(BigDecimal extendF1) {
        this.extendF1 = extendF1;
    }

    /**
     * 获取扩展 Float 2
     *
     * @return extend_f2 - 扩展 Float 2
     */
    public BigDecimal getExtendF2() {
        return extendF2;
    }

    /**
     * 设置扩展 Float 2
     *
     * @param extendF2 扩展 Float 2
     */
    public void setExtendF2(BigDecimal extendF2) {
        this.extendF2 = extendF2;
    }

    /**
     * 获取扩展 Float 3
     *
     * @return extend_f3 - 扩展 Float 3
     */
    public BigDecimal getExtendF3() {
        return extendF3;
    }

    /**
     * 设置扩展 Float 3
     *
     * @param extendF3 扩展 Float 3
     */
    public void setExtendF3(BigDecimal extendF3) {
        this.extendF3 = extendF3;
    }

    /**
     * 获取扩展 Float 4
     *
     * @return extend_f4 - 扩展 Float 4
     */
    public BigDecimal getExtendF4() {
        return extendF4;
    }

    /**
     * 设置扩展 Float 4
     *
     * @param extendF4 扩展 Float 4
     */
    public void setExtendF4(BigDecimal extendF4) {
        this.extendF4 = extendF4;
    }

    /**
     * 获取扩展 Date 1
     *
     * @return extend_d1 - 扩展 Date 1
     */
    public Date getExtendD1() {
        return extendD1;
    }

    /**
     * 设置扩展 Date 1
     *
     * @param extendD1 扩展 Date 1
     */
    public void setExtendD1(Date extendD1) {
        this.extendD1 = extendD1;
    }

    /**
     * 获取扩展 Date 2
     *
     * @return extend_d2 - 扩展 Date 2
     */
    public Date getExtendD2() {
        return extendD2;
    }

    /**
     * 设置扩展 Date 2
     *
     * @param extendD2 扩展 Date 2
     */
    public void setExtendD2(Date extendD2) {
        this.extendD2 = extendD2;
    }

    /**
     * 获取扩展 Date 3
     *
     * @return extend_d3 - 扩展 Date 3
     */
    public Date getExtendD3() {
        return extendD3;
    }

    /**
     * 设置扩展 Date 3
     *
     * @param extendD3 扩展 Date 3
     */
    public void setExtendD3(Date extendD3) {
        this.extendD3 = extendD3;
    }

    /**
     * 获取扩展 Date 4
     *
     * @return extend_d4 - 扩展 Date 4
     */
    public Date getExtendD4() {
        return extendD4;
    }

    /**
     * 设置扩展 Date 4
     *
     * @param extendD4 扩展 Date 4
     */
    public void setExtendD4(Date extendD4) {
        this.extendD4 = extendD4;
    }
}