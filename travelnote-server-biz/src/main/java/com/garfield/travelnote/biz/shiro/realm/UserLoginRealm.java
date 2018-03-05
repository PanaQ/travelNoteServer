package com.garfield.travelnote.biz.shiro.realm;

import com.garfield.travelnote.biz.service.PasswordEncodeService;
import com.garfield.travelnote.biz.service.TokenManager;
import com.garfield.travelnote.biz.service.UserService;
import com.garfield.travelnote.biz.shiro.bean.UserDetail;
import com.garfield.travelnote.api.model.bo.UserBo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author treezhu
 * @version 1.0
 * @date 2018/2/25 16:34
 */
@Component
public class UserLoginRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncodeService passwordEncodeService;

    @Autowired
    private TokenManager tokenManager;

    /**
     * 鉴权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String login = token.getUsername();
        String inputPassword = String.valueOf(token.getPassword());
        UserBo userBo = userService.getUserByLogin(login);
        if (userBo != null) {
            boolean match = passwordEncodeService.match(inputPassword, userBo.getPassword());
            if (match) {
                UserDetail userDetail = tokenManager.createNewToken(userBo);
                return new SimpleAuthenticationInfo(userDetail, inputPassword, getName());
            } else {
                throw new IncorrectCredentialsException();
            }
        } else {
            throw new UnknownAccountException();
        }
    }
}
