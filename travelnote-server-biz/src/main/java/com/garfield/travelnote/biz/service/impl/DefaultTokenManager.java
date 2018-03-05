package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.biz.repository.UserDetailRepository;
import com.garfield.travelnote.biz.service.TokenManager;
import com.garfield.travelnote.biz.shiro.bean.UserDetail;
import com.garfield.travelnote.api.model.bo.UserBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author treezhu
 * @version 1.0
 * @date 2018/2/25 17:18
 */
@Service
public class DefaultTokenManager implements TokenManager {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetail createNewToken(UserBo userBo) {
        removeTokens(userBo.getId());
        String token = UUID.randomUUID().toString();
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(userBo.getId());
        userDetail.setToken(token);
        userDetail.setUserBo(userBo);
        userDetail.setExpire(3600 * 24 * 30L);
        userDetailRepository.save(userDetail);
        return userDetail;
    }

    @Override
    public UserDetail getUserDetail(String token) {
        if (token == null) {
            return null;
        } else {
            return userDetailRepository.findOne(token);
        }
    }

    @Override
    public boolean checkToken(String token) {
        if (token == null) {
            return false;
        }
        return userDetailRepository.exists(token);
    }

    @Override
    public void refreshUserDetails(UserBo userBo) {
        List<UserDetail> userDetails = userDetailRepository.findByUserId(userBo.getId());
        for (UserDetail userDetail : userDetails) {
            userDetail.setUserBo(userBo);
            userDetailRepository.save(userDetail);
        }
    }

    @Override
    public void removeToken(String token) {
        userDetailRepository.delete(token);
    }


    @Override
    public void removeTokens(Long userId){
        List<UserDetail> userDetails = userDetailRepository.findByUserId(userId);
        userDetailRepository.delete(userDetails);
    }
}
