package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.common.model.bo.AttentionBo;

import java.util.List;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface UserFollowService {

    void addFollow(Long userId,Long followId);

    void cancelFollow(Long userId,Long followId);

    List<AttentionBo> getAttentionList(Long userId);

    List<AttentionBo> getFansList(Long userId);
}
