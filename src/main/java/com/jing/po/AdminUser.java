package com.jing.po;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>Title: SystemUser</p>
 * <p>Description: 后台管理用户</p>
 * 
 * @version 1.0.0
 * @author  JingBo
 */
public class AdminUser {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码加密存储时使用的盐
     */
    private String salt;

    /**
     * 用户是否被锁定：0代表未锁定，1代表被锁定
     */
    private Integer locked;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
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
        return "SystemUser [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
            + ", locked=" + locked + ", gmtCreate="
            + gmtCreate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + ", gmtUpdate="
            + gmtUpdate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "]";
    }

}
