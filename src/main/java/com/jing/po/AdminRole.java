package com.jing.po;

import java.time.LocalDateTime;

/**
 * <p>Title: Role</p>
 * <p>Description: 后台管理用户所拥有的角色</p>
 * 
 * @version 1.0.0
 * @author  JingBo
 */
public class AdminRole {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色是否可用：0代表不可用，1代表可用
     */
    private Integer available;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
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
        return "Role [id=" + id + ", name=" + name + ", available=" + available + ", gmtCreate=" + gmtCreate
            + ", gmtUpdate=" + gmtUpdate + "]";
    }

}
