package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.biz.service.PasswordEncodeService;
import com.garfield.travelnote.biz.service.UserService;
import com.garfield.travelnote.common.model.bo.BaseUserBo;
import com.garfield.travelnote.common.model.bo.UserBo;
import com.garfield.travelnote.common.util.AesCryptUtil;
import com.garfield.travelnote.common.util.ResultEnum;
import com.garfield.travelnote.dal.domain.UserDo;
import com.garfield.travelnote.dal.mapper.UserDoMapper;
import com.zhexinit.ov.common.exception.CommonException;
import com.zhexinit.ov.common.util.DateUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jingly on 2018/2/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDoMapper userDoMapper;

    @Autowired
    private PasswordEncodeService passwordEncodeService;

    @Override
    public void register(BaseUserBo baseUserBo) {

        String password = baseUserBo.getPassword();
        String confirmPassword = baseUserBo.getConfirmPassword();
        if (password != confirmPassword) {
            throw new CommonException(ResultEnum.passwordNotEqual);
        }

        int count = getUserByName(baseUserBo.getName());
        if (count != 0) {
            throw new CommonException(ResultEnum.illegalName);
        }

        UserDo existUserDo = userDoMapper.getByPhone(baseUserBo.getPhone());
        if (existUserDo == null) {
            try {
                String decPassword = AesCryptUtil.decrypt(baseUserBo.getPassword());
                password = passwordEncodeService.encode(decPassword);
                UserDo userDo = createAppUserDo(baseUserBo.getPhone(), password);
                userDoMapper.insertSelective(userDo);
            } catch (Exception e) {
                throw new CommonException(ResultEnum.systemError);
            }
        } else {
            throw new CommonException(ResultEnum.userAlreadyExist);
        }
    }

    @Override
    public int getUserByName(String name) {
        return userDoMapper.selectUserByName(name);
    }

    @Override
    public UserBo getUserInfo(Long id) {
        UserBo userBo = userDoMapper.selectUserInfo(id);
        if (userBo == null) {
            throw new CommonException(ResultEnum.userNotExist);
        }
        return userBo;
    }

    @Override
    public UserBo getUserByLogin(String login) {
        return userDoMapper.getLoginUser(login);
    }

    private UserDo createAppUserDo(String phone, String password) {
        UserDo appUserDo = new UserDo();
        appUserDo.setPhone(phone);
        appUserDo.setPassword(password);
        appUserDo.setIsDeleted(0);
        Long timestamp = DateUitl.getLongTimestamp();
        appUserDo.setCreatedAt(timestamp);
        appUserDo.setUpdatedAt(timestamp);
        return appUserDo;
    }
}
