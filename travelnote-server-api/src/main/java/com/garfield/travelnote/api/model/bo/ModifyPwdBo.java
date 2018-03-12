package com.garfield.travelnote.api.model.bo;

import org.hibernate.validator.constraints.NotEmpty;

public class ModifyPwdBo {

    @NotEmpty
    private String oldPassword;

    @NotEmpty
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
