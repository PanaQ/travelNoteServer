package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.common.model.bo.BaseUserBo;
import com.garfield.travelnote.common.model.bo.UserBo;
import com.zhexinit.ov.common.bean.RequestBean;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface UserService {
    /**
     * 注册
     */
    void register(BaseUserBo baseUserBo);

    /**
     * 根据名称查询用户
     */
    int getUserByName(String name);

    UserBo getUserInfo(Long id);
}
