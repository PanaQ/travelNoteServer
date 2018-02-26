package com.garfield.travelnote.action;

import com.garfield.travelnote.biz.service.UserFollowService;
import com.garfield.travelnote.common.model.bo.AttentionBo;
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
import java.util.List;

/**
 *  关注Controller
 **/
@RestController
@RequestMapping("follow")
public class FollowController {

    @Autowired
    private UserFollowService userFollowService;

    /**
     * 添加关注
     */
    @PostMapping(value = "addFollow")
    public ResponseBean<Void> addFollow(@RequestBody @Valid RequestBean<UserFollowBo> param) {

        UserFollowBo userFollowBo = param.getParam();
        userFollowService.addFollow(userFollowBo);
        return ResponseUtil.success();
    }

    /**
     * 取消关注
     */
    @PostMapping(value = "cancelFollow")
    public ResponseBean<Void> cancelFollow(@RequestBody @Valid RequestBean<UserFollowBo> param) {
        UserFollowBo userFollowBo = param.getParam();
        userFollowService.cancelFollow(userFollowBo);
        return ResponseUtil.success();
    }

    /**
     * 获取关注列表
     */
    @PostMapping(value = "getAttentionList")
    public ResponseBean<List<AttentionBo>> getAttentionList(@RequestBody @Valid RequestBean<Long> param) {
        Long id = param.getParam();
        List<AttentionBo> attentionBoList = userFollowService.getAttentionList(id);
        return ResponseUtil.success(attentionBoList);
    }

    /**
     * 获取粉丝列表
     */
    @PostMapping(value = "getFansList")
    public ResponseBean<List<AttentionBo>> getFansList(@RequestBody @Valid RequestBean<Long> param) {
        Long id = param.getParam();
        List<AttentionBo> attentionBoList = userFollowService.getFansList(id);
        return ResponseUtil.success(attentionBoList);
    }


}
