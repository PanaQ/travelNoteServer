package com.garfield.travelnote.action;

import com.garfield.travelnote.biz.service.UserFollowService;
import com.garfield.travelnote.common.model.bo.AttentionBo;
import com.garfield.travelnote.common.model.bo.UserBo;
import com.garfield.travelnote.common.model.bo.UserFollowBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import com.zhexinit.ov.common.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 *  关注Controller
 **/
@RestController
@RequestMapping("follow")
public class FollowController {

    @Autowired
    private UserFollowService userFollowService;

    // TODO: 2018/2/27 查询是否已关注 

    /**
     * 添加关注
     */
    @PostMapping(value = "addFollow")
    public ResponseBean<Void> addFollow(@RequestBody @Valid RequestBean<UserFollowBo> param,UserBo userBo) {
        if(userBo != null){
            // TODO: 2018/2/27 判断是否已经关注过 
            Long userId = userBo.getId();
            UserFollowBo userFollowBo = param.getParam();
            userFollowBo.setUserId(userId);
            userFollowService.addFollow(userFollowBo);
        }
        return ResponseUtil.success();
    }

    /**
     * 取消关注
     */
    @PostMapping(value = "cancelFollow")
    public ResponseBean<Void> cancelFollow(@RequestBody @Valid RequestBean<UserFollowBo> param,UserBo userBo) {
        if(userBo != null){
            Long userId = userBo.getId();
            UserFollowBo userFollowBo = param.getParam();
            userFollowBo.setUserId(userId);
            userFollowService.cancelFollow(userFollowBo);
        }
        return ResponseUtil.success();
    }

    /**
     * 获取关注列表
     */
    @PostMapping(value = "getAttentionList")
    public ResponseBean<List<AttentionBo>> getAttentionList(UserBo userBo) {
        List<AttentionBo> attentionBoList = new ArrayList<>();
        if(userBo != null){
            Long userId = userBo.getId();
            attentionBoList = userFollowService.getAttentionList(userId);
        }
        return ResponseUtil.success(attentionBoList);
    }

    /**
     * 获取粉丝列表
     */
    @PostMapping(value = "getFansList")
    public ResponseBean<List<AttentionBo>> getFansList(UserBo userBo) {
        List<AttentionBo> fansList = new ArrayList<>();
        if(userBo != null){
            Long userId = userBo.getId();
            fansList = userFollowService.getFansList(userId);
        }
        return ResponseUtil.success(fansList);
    }


}
