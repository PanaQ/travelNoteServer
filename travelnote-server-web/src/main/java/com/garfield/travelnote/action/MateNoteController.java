package com.garfield.travelnote.action;

import com.garfield.travelnote.biz.service.MateNoteService;
import com.garfield.travelnote.common.model.bo.*;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import com.zhexinit.ov.common.query.ListBean;
import com.zhexinit.ov.common.query.SortPagerQuery;
import com.zhexinit.ov.common.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public ResponseBean<ListBean<MateNoteBo>> getMateNoteListByUserId(@Valid @RequestBody RequestBean<SortPagerQuery<MateNoteQuery>> requestBean) {
        SortPagerQuery<MateNoteQuery> sortPagerQuery = requestBean.getParam();
        return ResponseUtil.success(mateNoteService.getMateNoteListByUserId(sortPagerQuery));
    }

    /**
     * 获取自己的所有结伴游列表
     */
    @PostMapping("getMateNoteListByMine")
    public ResponseBean<ListBean<MateNoteBo>> getMateNoteListByMine(@Valid @RequestBody RequestBean<SortPagerQuery> requestBean,UserBo userBo) {
        SortPagerQuery sortPagerQuery = requestBean.getParam();
        Long userId = null;
        if(userBo != null) {
            userId = userBo.getId();
        }
        return ResponseUtil.success(mateNoteService.getMateNoteListByMine(sortPagerQuery,userId));
    }

    /**
     * 获取所有的结伴游列表
     */
    @PostMapping("getMateNoteList")
    public ResponseBean<ListBean<MateNoteBo>> getMateNoteList(@Valid @RequestBody RequestBean<SortPagerQuery> requestBean) {
        SortPagerQuery sortPagerQuery = requestBean.getParam();
        return ResponseUtil.success(mateNoteService.getMateNoteList(sortPagerQuery));
    }

}
