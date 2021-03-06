package com.garfield.travelnote.dal.mapper;

import com.garfield.travelnote.api.model.bo.UserBo;
import com.garfield.travelnote.dal.domain.UserDo;
import com.garfield.travelnote.dal.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDoMapper extends MyMapper<UserDo> {
    UserDo getByPhone(@Param("phone") String phone);

    Integer getCountByName(String name);

    UserBo selectUserInfo(Long id);

    UserBo getLoginUser(@Param("login") String login);
}