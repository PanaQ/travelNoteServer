package com.garfield.travelnote.action;

import com.garfield.travelnote.biz.service.MateNoteService;
import com.garfield.travelnote.api.model.bo.*;
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
 *  结伴游Controller
 **/
@RestController
@RequestMapping("mateNote")
public class MateNoteController {

    @Autowired
    private MateNoteService mateNoteService;

    /**
     * 发布结伴游
     */
    @PostMapping(value = "addMateNote")
    public ResponseBean<Void> addMateNote(@RequestBody @Valid RequestBean<AddMateNoteBo> param, UserBo userBo) {
        if(userBo != null){
            Long userId = userBo.getId();
            AddMateNoteBo mateNoteBo = param.getParam();
            mateNoteBo.setUserId(userId);
            mateNoteService.addMateNote(mateNoteBo);
        }

        return ResponseUtil.success();
    }

    /**
     * 删除结伴游
     */
    @PostMapping(value = "deleteMateNote")
    public ResponseBean<Void> deleteMateNote(@RequestBody @Valid RequestBean<Long> param,UserBo userBo) {
        if(userBo != null) {
            Long userId = userBo.getId();
            Long id = param.getParam();
            mateNoteService.deleteMateNote(id,userId);
        }
        return ResponseUtil.success();
    }

    /**
     * 修改结伴游
     */
    @PostMapping(value = "modifyMateNote")
    public ResponseBean<Void> modifyMateNote(@RequestBody @Valid RequestBean<MateNoteBo> param,UserBo userBo) {
        if(userBo != null) {
            Long userId = userBo.getId();
            MateNoteBo mateNoteBo = param.getParam();
            mateNoteService.modifyMateNote(mateNoteBo,userId);
        }
        return ResponseUtil.success();
    }

    /**
     * 根据id查看结伴游
     */
    @PostMapping(value = "getMateNoteById")
    public ResponseBean<MateNoteBo> getMateNoteById(@RequestBody RequestBean<Long> param){
        Long id = param.getParam();
        MateNoteBo mateNoteBo = mateNoteService.getNoteBoById(id);
        return ResponseUtil.success(mateNoteBo);
    }

    /**
     * 根据userId获取结伴游列表(获取别人的)
     */
    @PostMapping("getMateNoteListByUserId")
    public ResponseBean<List<MateNoteBo>> getMateNoteListByUserId(@Valid @RequestBody RequestBean<Long> requestBean) {
        Long userId = requestBean.getParam();
        return ResponseUtil.success(mateNoteService.getMateNoteListByUserId(userId));
    }

    /**
     * 获取自己的所有结伴游列表
     */
    @PostMapping("getMateNoteListByMine")
    public ResponseBean<List<MateNoteBo>> getMateNoteListByMine(UserBo userBo) {
        List<MateNoteBo> mateNoteBoList = new ArrayList<>();
        if(userBo != null) {
            Long userId = userBo.getId();
            mateNoteBoList = mateNoteService.getMateNoteListByUserId(userId);
        }
        return ResponseUtil.success(mateNoteBoList);
    }

    /**
     * 获取所有的结伴游列表
     */
    @PostMapping("getMateNoteList")
    public ResponseBean<List<MateNoteBo>> getMateNoteList() {
        return ResponseUtil.success(mateNoteService.getMateNoteList());
    }

}
