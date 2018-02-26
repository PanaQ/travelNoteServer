package com.garfield.travelnote.common.model.bo;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class AddNoteCommentBo {

    /**
     * 游记id
     */
    @NotNull(message = "游记id不能为空")
    private Long noteId;

    /**
     * 留言用户id
     */
    @NotNull(message = "留言用户id不能为空")
    private Long userId;

    /**
     * 留言内容
     */
    @NotEmpty(message = "留言内容不能为空")
    private String comment;

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }



}