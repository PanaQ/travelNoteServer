package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.biz.service.UserFollowService;
import com.garfield.travelnote.common.model.bo.AttentionBo;
import com.garfield.travelnote.common.util.ResultEnum;
import com.garfield.travelnote.dal.domain.UserFollowDo;
import com.garfield.travelnote.dal.mapper.UserFollowDoMapper;
import com.zhexinit.ov.common.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Objects;

/**
 * Created by Jingly on 2018/2/22.
 */
@Service
public class UserFollowServiceImpl implements UserFollowService {

    @Autowired
    private UserFollowDoMapper userFollowDoMapper;

    @Override
    public void addFollow(Long userId, Long followId) {
        if (Objects.equals(userId, followId)) {
            throw new CommonException(ResultEnum.notFollowYourself);
        }
        if (existFollow(userId,followId)){
            throw new CommonException(ResultEnum.alreadyFollow);
        }
        UserFollowDo userFollowDo = new UserFollowDo();
        userFollowDo.setUserId(userId);
        userFollowDo.setFollowId(followId);
        userFollowDoMapper.insertSelective(userFollowDo);
    }

    @Override
    public void cancelFollow(Long userId,Long followId) {
        Example example = new Example(UserFollowDo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        criteria.andEqualTo("followId",followId);
        UserFollowDo userFollowDo = new UserFollowDo();
        userFollowDo.setIsDeleted(1);
        userFollowDoMapper.updateByExampleSelective(userFollowDo, example);
    }

    @Override
    public List<AttentionBo> getAttentionList(Long userId) {
        List<AttentionBo> attentionBoList = userFollowDoMapper.selectAttentionList(userId);
        return attentionBoList;
    }

    @Override
    public List<AttentionBo> getFansList(Long userId) {
        List<AttentionBo> attentionBoList = userFollowDoMapper.selectFansList(userId);
        return attentionBoList;
    }

    private boolean existFollow(Long userId, Long followId) {
        Example example = new Example(UserFollowDo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        criteria.andEqualTo("followId", followId);
        criteria.andEqualTo("isDeleted", 0);
        return userFollowDoMapper.selectCountByExample(example) > 0;
    }
}
