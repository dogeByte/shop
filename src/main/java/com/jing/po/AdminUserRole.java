package com.jing.po;

import java.time.LocalDateTime;

/**
 * <p>Title: SystemUserRole</p>
 * <p>Description: 后台管理用户和后台管理角色的关联</p>
 * 
 * @version 1.0.0
 * @author  JingBo
 */
public class AdminUserRole {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 后台管理用户的主键
     */
    private Integer adminUserId;

    /**
     * 后台管理角色的主键
     */
    private Integer adminRoleId;
    /**
     * 对象创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 对象更新时间
     */
    private LocalDateTime gmtUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public Integer getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(Integer adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(LocalDateTime gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @Override
    public String toString() {
        return "AdminUserRole [id=" + id + ", adminUserId=" + adminUserId + ", adminRoleId=" + adminRoleId
            + ", gmtCreate=" + gmtCreate + ", gmtUpdate=" + gmtUpdate + "]";
    }

}
