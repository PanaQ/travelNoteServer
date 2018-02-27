package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.common.model.bo.BaseUserBo;
import com.garfield.travelnote.common.model.bo.UserBo;

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
    int getCountByName(String name);

    /**
     * 查询用户信息
     *
     * @param id
     * @return
     */
    UserBo getUserInfo(Long id);

    /**
     * 登录
     *
     * @param login    登录账号 手机号或用户名
     */
    UserBo getUserByLogin(String login);
}
