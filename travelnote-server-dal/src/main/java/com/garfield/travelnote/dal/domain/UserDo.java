package com.garfield.travelnote.dal.domain;

import javax.persistence.*;

@Table(name = "user")
public class UserDo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 登录名
     */
    private String name;

    /**
     * 用户性别；0：男 ；1 ： 女
     */
    private Integer gender;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户偏好 
     */
    private String favourite;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码错误次数
     */
    @Column(name = "invalid_pwd_count")
    private Long invalidPwdCount;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Long createdAt;

    /**
     * 更新时间
     */
    @Column(name = "updated_at")
    private Long updatedAt;

    /**
     * 是否删除0：否1：是
     */
    @Column(name = "is_deleted")
    private Integer isDeleted;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取登录名
     *
     * @return name - 登录名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置登录名
     *
     * @param name 登录名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取用户性别；0：男 ；1 ： 女
     *
     * @return gender - 用户性别；0：男 ；1 ： 女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置用户性别；0：男 ；1 ： 女
     *
     * @param gender 用户性别；0：男 ；1 ： 女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取用户头像
     *
     * @return avatar - 用户头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置用户头像
     *
     * @param avatar 用户头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 获取用户偏好 
     *
     * @return favourite - 用户偏好 
     */
    public String getFavourite() {
        return favourite;
    }

    /**
     * 设置用户偏好 
     *
     * @param favourite 用户偏好 
     */
    public void setFavourite(String favourite) {
        this.favourite = favourite == null ? null : favourite.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取密码错误次数
     *
     * @return invalid_pwd_count - 密码错误次数
     */
    public Long getInvalidPwdCount() {
        return invalidPwdCount;
    }

    /**
     * 设置密码错误次数
     *
     * @param invalidPwdCount 密码错误次数
     */
    public void setInvalidPwdCount(Long invalidPwdCount) {
        this.invalidPwdCount = invalidPwdCount;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取创建时间
     *
     * @return created_at - 创建时间
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取更新时间
     *
     * @return updated_at - 更新时间
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 设置更新时间
     *
     * @param updatedAt 更新时间
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 获取是否删除0：否1：是
     *
     * @return is_deleted - 是否删除0：否1：是
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除0：否1：是
     *
     * @param isDeleted 是否删除0：否1：是
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}