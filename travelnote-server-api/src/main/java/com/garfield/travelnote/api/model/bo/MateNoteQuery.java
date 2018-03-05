package com.garfield.travelnote.api.model.bo;

import javax.validation.constraints.NotNull;

public class MateNoteQuery {

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
