package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.biz.service.PasswordEncodeService;
import com.garfield.travelnote.biz.service.TokenManager;
import com.garfield.travelnote.biz.service.UserService;
import com.garfield.travelnote.common.model.bo.BaseUserBo;
import com.garfield.travelnote.common.model.bo.UserBo;
import com.garfield.travelnote.common.util.AesCryptUtil;
import com.garfield.travelnote.common.util.ResultEnum;
import com.garfield.travelnote.dal.domain.UserDo;
import com.garfield.travelnote.dal.mapper.UserDoMapper;
import com.zhexinit.ov.common.exception.CommonException;
import com.zhexinit.ov.common.util.DateUitl;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    private TokenManager tokenManager;

    @Override
    public void register(BaseUserBo baseUserBo) {

        int count = getCountByName(baseUserBo.getName());
        if (count != 0) {
            throw new CommonException(ResultEnum.userAlreadyExist);
        }

        UserDo existUserDo = userDoMapper.getByPhone(baseUserBo.getPhone());
        if (existUserDo == null) {
            try {
                UserDo userDo = createAppUserDo(baseUserBo);
                userDoMapper.insertSelective(userDo);
            } catch (Exception e) {
                throw new CommonException(ResultEnum.systemError);
            }
        } else {
            throw new CommonException(ResultEnum.userAlreadyExist);
        }
    }

    @Override
    public int getCountByName(String name) {
        return userDoMapper.getCountByName(name);
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

    @Override
    public void updateMyInfo(UserBo newUserBo) {
        UserDo oldUserDo = userDoMapper.selectByPrimaryKey(newUserBo.getId());
        if (!oldUserDo.getName().equals(newUserBo.getName())){
            int existNameCount = getCountByName(newUserBo.getName());
            if (existNameCount>0){
                throw new CommonException(ResultEnum.userAlreadyExist);
            }
        }
        if (!oldUserDo.getPhone().equals(newUserBo.getPhone())){
            UserDo existUserPhoneDo = userDoMapper.getByPhone(newUserBo.getPhone());
            if (existUserPhoneDo!=null){
                throw new CommonException(ResultEnum.userAlreadyExist);
            }
        }
        BeanUtils.copyProperties(newUserBo,oldUserDo);
        userDoMapper.updateByPrimaryKeySelective(oldUserDo);
        tokenManager.refreshUserDetails(newUserBo);
    }

    private UserDo createAppUserDo(BaseUserBo baseUserBo) throws Exception {
        String decPassword = AesCryptUtil.decrypt(baseUserBo.getPassword());
        String dbPassword = passwordEncodeService.encode(decPassword);
        UserDo appUserDo = new UserDo();
        appUserDo.setName(baseUserBo.getName());
        appUserDo.setPhone(baseUserBo.getPhone());
        appUserDo.setPassword(dbPassword);
        appUserDo.setIsDeleted(0);
        Long timestamp = DateUitl.getLongTimestamp();
        appUserDo.setCreatedAt(timestamp);
        appUserDo.setUpdatedAt(timestamp);
        return appUserDo;
    }
}
