package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.biz.realm.UserDetail;
import com.garfield.travelnote.common.model.bo.UserBo;

/**
 * @author treezhu
 * @version 1.0
 * @date 2018/2/25 17:13
 */
public interface TokenManager {
    UserDetail createNewToken(UserBo userBo);

    UserDetail getUserDetail(String token);

    boolean checkToken(String token);

    void refreshUserDetails(UserDetail userDetail);

    void removeToken(String token);
}
