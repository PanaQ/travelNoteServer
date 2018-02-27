package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.biz.shiro.bean.UserDetail;
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

    void refreshUserDetails(UserBo userBo);

    void removeToken(String token);

    void removeTokens(Long userId);
}
