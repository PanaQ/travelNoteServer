package com.garfield.travelnote.action;

import com.garfield.travelnote.biz.service.impl.NoteService;
import com.garfield.travelnote.biz.service.impl.UserFollowService;
import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;
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


}
