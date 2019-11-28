package com.chenbro.cus.model;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class BaseEntity implements Serializable {


    private static final long serialVersionUID = 1L;
    /**
     * 删除标记(0：正常；1：删除；2：审核)
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";

    /**
     * 实体编号(唯一标识)
     */
    protected String uuid;

    /**
     * 组织ID
     */
    protected String organization;

    /**
     * 创建者
     */
    protected String createBy;

    /**
     * 创建日期
     */
    protected Timestamp createDate;

    /**
     * 更新者
     */
    protected  String updateBy;

    /**
     * 更新日期
     */
    protected  Timestamp updateDate;

    /**
     * 删除标识
     */
    protected  String delFlag;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
