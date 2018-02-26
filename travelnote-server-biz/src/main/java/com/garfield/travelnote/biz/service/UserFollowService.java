package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.common.model.bo.AttentionBo;
import com.garfield.travelnote.common.model.bo.UserFollowBo;

import java.util.List;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface UserFollowService {

    void addFollow(UserFollowBo userFollowBo);

    void cancelFollow(UserFollowBo userFollowBo);

    List<AttentionBo> getAttentionList(Long id);

    List<AttentionBo> getFansList(Long id);
}
