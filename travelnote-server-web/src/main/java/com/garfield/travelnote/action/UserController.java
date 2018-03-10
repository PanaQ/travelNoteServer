package com.garfield.travelnote.action;

import com.garfield.travelnote.api.model.bo.ModifyPwdBo;
import com.garfield.travelnote.biz.shiro.bean.UserDetail;
import com.garfield.travelnote.biz.service.TokenManager;
import com.garfield.travelnote.biz.service.UserService;
import com.garfield.travelnote.api.model.bo.LoginBean;
import com.garfield.travelnote.api.util.ResultEnum;
import com.garfield.travelnote.api.model.bo.BaseUserBo;
import com.garfield.travelnote.api.model.bo.UserBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import com.zhexinit.ov.common.util.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 *  用户Controller
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManager tokenManager;

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
    public ResponseBean<UserBo> getMyInfo(UserBo userBo){
        return ResponseUtil.success(userBo);
    }

    /**
     * 修改用户信息
     */
    @PostMapping(value = "updateMyInfo")
    public ResponseBean<Void> updateMyInfo(@RequestBody @Valid RequestBean<UserBo> requestBean,UserBo userBo){
        UserBo newUserBo = requestBean.getParam();
        newUserBo.setId(userBo.getId());
        userService.updateMyInfo(newUserBo);
        return ResponseUtil.success();
    }

    /**
     * 修改密码
     * @param requestBean
     * @param userBo
     * @return
     */
    @PostMapping(value = "modifyPwd")
    public ResponseBean<Void> modifyPwd(@RequestBody @Valid RequestBean<ModifyPwdBo> requestBean,UserBo userBo){
        userService.updatePassword(userBo.getId(),requestBean.getParam());
        return ResponseUtil.success();
    }


    /**
     * 用户登录
     * @param requestBean
     * @param response
     * @return
     */
    @PostMapping(value = "login")
    public ResponseBean<Void> login(@RequestBody RequestBean<LoginBean> requestBean, HttpServletResponse response){
        LoginBean loginBean = requestBean.getParam();
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginBean.getLogin(),loginBean.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            UserDetail userDetail = (UserDetail) subject.getPrincipals().getPrimaryPrincipal();
            response.setHeader("X-Auth-Token",userDetail.getToken());
            return ResponseUtil.success();
        }catch (UnknownAccountException e){
            return ResponseUtil.fail(ResultEnum.userNotExist);
        }catch (IncorrectCredentialsException e){
            return ResponseUtil.fail(ResultEnum.errorPassword);
        }catch (AuthenticationException e){
            return ResponseUtil.fail(ResultEnum.loginFailed);
        }
    }

    /**
     * 用户退出
     * @param token
     * @return
     */
    @PostMapping(value = "logout")
    public ResponseBean<Void> logout(@RequestHeader("X-Auth-Token") String token){
        tokenManager.removeToken(token);
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return ResponseUtil.success();
    }


}
