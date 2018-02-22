package com.garfield.travelnote.dal.domain;

import javax.persistence.*;

@Table(name = "note_comment")
public class NoteCommentDo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 游记id
     */
    @Column(name = "note_id")
    private Long noteId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 楼
     */
    private Long floor;

    /**
     * 留言内容
     */
    private String comment;

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
     * 获取游记id
     *
     * @return note_id - 游记id
     */
    public Long getNoteId() {
        return noteId;
    }

    /**
     * 设置游记id
     *
     * @param noteId 游记id
     */
    public void setNoteId(Long noteId) {
        this.noteId = noteId;
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
     * 获取楼
     *
     * @return floor - 楼
     */
    public Long getFloor() {
        return floor;
    }

    /**
     * 设置楼
     *
     * @param floor 楼
     */
    public void setFloor(Long floor) {
        this.floor = floor;
    }

    /**
     * 获取留言内容
     *
     * @return comment - 留言内容
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置留言内容
     *
     * @param comment 留言内容
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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