package com.garfield.travelnote.action;

import com.garfield.travelnote.biz.service.impl.UserService;
import com.garfield.travelnote.common.model.bo.BaseUserBo;
import com.garfield.travelnote.common.model.bo.UserBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import com.zhexinit.ov.common.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *  用户Controller
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     */
    @PostMapping(value = "register")
    public ResponseBean<Void> register(@RequestBody @Valid RequestBean<BaseUserBo> param) {

        BaseUserBo baseUserBo = param.getParam();

        userService.register(baseUserBo);
        return ResponseUtil.success();
    }

    /**
     * 获取我的信息
     */
    @PostMapping(value = "getMyInfo")
    public ResponseBean<UserBo> getMyInfo(@RequestBody RequestBean<Long> param){
        Long id = param.getParam();
        UserBo userBo = userService.getUserInfo(id);
        return ResponseUtil.success(userBo);
    }


}
