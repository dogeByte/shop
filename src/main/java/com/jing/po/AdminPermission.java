package com.jing.po;

import java.time.LocalDateTime;

/**
 * <p>Title: Permission</p>
 * <p>Description: 后台管理角色所拥有的权限</p>
 * 
 * @version 1.0.0
 * @author  JingBo
 */
public class AdminPermission {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 权限资源名
     */
    private String name;

    /**
     * 权限资源类型：menu 或 privilege
     */
    private String type;

    /**
     * 权限资源访问路径，如： "/good/insert.action"
     */
    private String url;

    /**
     * 权限代码，如： "good:insert"
     */
    private String code;

    /**
     * 权限是否可用，0代表不可用，1代表可用
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        return "Permission [id=" + id + ", name=" + name + ", type=" + type + ", url=" + url + ", code=" + code
            + ", available=" + available + ", gmtCreate=" + gmtCreate + ", gmtUpdate=" + gmtUpdate + "]";
    }

}
