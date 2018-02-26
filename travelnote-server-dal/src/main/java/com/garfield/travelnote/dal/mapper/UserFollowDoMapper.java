package com.garfield.travelnote.dal.mapper;

import com.garfield.travelnote.common.model.bo.AttentionBo;
import com.garfield.travelnote.dal.domain.UserFollowDo;
import com.garfield.travelnote.dal.util.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFollowDoMapper extends MyMapper<UserFollowDo> {
    List<AttentionBo> selectAttentionList(Long id);

    List<AttentionBo> selectFansList(Long id);
}