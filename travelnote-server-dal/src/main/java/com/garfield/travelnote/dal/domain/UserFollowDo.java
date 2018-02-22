package com.garfield.travelnote.dal.domain;

import javax.persistence.*;

@Table(name = "user_follow")
public class UserFollowDo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 关注用户id
     */
    @Column(name = "follow_id")
    private Long followId;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Long createdAt;

    /**
     * 修改时间
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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取关注用户id
     *
     * @return follow_id - 关注用户id
     */
    public Long getFollowId() {
        return followId;
    }

    /**
     * 设置关注用户id
     *
     * @param followId 关注用户id
     */
    public void setFollowId(Long followId) {
        this.followId = followId;
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
     * 获取修改时间
     *
     * @return updated_at - 修改时间
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 设置修改时间
     *
     * @param updatedAt 修改时间
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