package com.jing.po;

import java.time.LocalDateTime;

/**
 * <p>Title: RolePermission</p>
 * <p>Description: 后台管理角色和后台管理权限的关联</p>
 * 
 * @version 1.0.0
 * @author  JingBo
 */
public class AdminRolePermission {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 后台管理角色的主键
     */
    private Integer adminRoleId;

    /**
     * 后台管理权限的主键
     */
    private Integer adminPermissionId;

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

    public Integer getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(Integer adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public Integer getAdminPermissionId() {
        return adminPermissionId;
    }

    public void setAdminPermissionId(Integer adminPermissionId) {
        this.adminPermissionId = adminPermissionId;
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
        return "AdminPolePermission [id=" + id + ", adminRoleId=" + adminRoleId + ", adminPermissionId="
            + adminPermissionId + ", gmtCreate=" + gmtCreate + ", gmtUpdate=" + gmtUpdate + "]";
    }

}
