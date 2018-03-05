package com.garfield.travelnote.biz.shiro;

import com.garfield.travelnote.biz.service.TokenManager;
import com.garfield.travelnote.biz.shiro.bean.UserDetail;
import com.garfield.travelnote.api.model.bo.UserBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class UserContextHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private TokenManager tokenManager;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class clazz = methodParameter.getParameterType();
        return UserBo.class.isAssignableFrom(clazz);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String token = nativeWebRequest.getHeader("X-Auth-Token");

        if (token == null) {
            return null;
        }

        UserDetail userDetail =  tokenManager.getUserDetail(token);
        if (userDetail == null || userDetail.getUserBo() == null) {
            return null;
        }

        return userDetail.getUserBo();
    }
}
