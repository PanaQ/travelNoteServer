package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.biz.service.UserFollowService;
import com.garfield.travelnote.common.model.bo.AttentionBo;
import com.garfield.travelnote.common.util.ResultEnum;
import com.garfield.travelnote.common.model.bo.UserFollowBo;
import com.garfield.travelnote.dal.domain.UserFollowDo;
import com.garfield.travelnote.dal.mapper.UserFollowDoMapper;
import com.zhexinit.ov.common.exception.CommonException;
import org.springframework.beans.BeanUtils;
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
    public void addFollow(UserFollowBo userFollowBo) {

        if(Objects.equals(userFollowBo.getUserId(), userFollowBo.getFollowId())){
            throw new CommonException(ResultEnum.notFollowYourself);
        }

        UserFollowDo userFollowDo = new UserFollowDo();
        BeanUtils.copyProperties(userFollowBo,userFollowDo);
        userFollowDo.setIsDeleted(0);

        userFollowDoMapper.insertSelective(userFollowDo);
    }

    @Override
    public void cancelFollow(UserFollowBo userFollowBo) {

        Example example = new Example(UserFollowDo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userFollowBo.getUserId());
        criteria.andEqualTo("followId",userFollowBo.getFollowId());

        UserFollowDo userFollowDo = new UserFollowDo();
        userFollowDo.setIsDeleted(1);
        userFollowDoMapper.updateByExampleSelective(userFollowDo, example);
    }

    @Override
    public List<AttentionBo> getAttentionList(Long id) {
        List<AttentionBo> attentionBoList = userFollowDoMapper.selectAttentionList(id);
        return attentionBoList;
    }

    @Override
    public List<AttentionBo> getFansList(Long id) {
        List<AttentionBo> attentionBoList = userFollowDoMapper.selectAttentionList(id);
        return attentionBoList;
    }
}
