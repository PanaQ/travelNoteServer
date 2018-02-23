package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;
import com.garfield.travelnote.common.model.bo.UserFollowBo;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface UserFollowService {

    void addFollow(UserFollowBo userFollowBo);

    void cancelFollow(UserFollowBo userFollowBo);
}
