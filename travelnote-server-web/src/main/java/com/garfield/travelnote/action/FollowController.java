package com.garfield.travelnote.action;

import com.garfield.travelnote.biz.service.UserFollowService;
import com.garfield.travelnote.api.model.bo.AttentionBo;
import com.garfield.travelnote.api.model.bo.UserBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import com.zhexinit.ov.common.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 关注Controller
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
    public ResponseBean<Void> addFollow(@RequestBody RequestBean<Long> requestBean, UserBo userBo) {
        userFollowService.addFollow(userBo.getId(), requestBean.getParam());
        return ResponseUtil.success();
    }

    /**
     * 取消关注
     */
    @PostMapping(value = "cancelFollow")
    public ResponseBean<Void> cancelFollow(@RequestBody RequestBean<Long> requestBean, UserBo userBo) {
        userFollowService.cancelFollow(userBo.getId(),requestBean.getParam());
        return ResponseUtil.success();
    }

    /**
     * 获取关注列表
     */
    @PostMapping(value = "getAttentionList")
    public ResponseBean<List<AttentionBo>> getAttentionList(UserBo userBo) {
        List<AttentionBo> attentionBoList = userFollowService.getAttentionList(userBo.getId());
        return ResponseUtil.success(attentionBoList);
    }

    /**
     * 获取粉丝列表
     */
    @PostMapping(value = "getFansList")
    public ResponseBean<List<AttentionBo>> getFansList(UserBo userBo) {
        List<AttentionBo> fansList = userFollowService.getFansList(userBo.getId());
        return ResponseUtil.success(fansList);
    }

    /**
     * 查询是否关注
     * @param requestBean
     * @return
     */
    @PostMapping(value = "isFollow")
    public ResponseBean<Boolean> isFollow(@RequestBody RequestBean<Long> requestBean,UserBo userBo){
        return ResponseUtil.success(userFollowService.isFollow(userBo.getId(),requestBean.getParam()));
    }


}
