package com.garfield.travelnote.action;

import com.garfield.travelnote.biz.service.MateNoteService;
import com.garfield.travelnote.common.model.bo.AddMateNoteBo;
import com.garfield.travelnote.common.model.bo.MateNoteBo;
import com.garfield.travelnote.common.model.bo.MateNoteQuery;
import com.garfield.travelnote.common.model.bo.NoteQuery;
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
    public ResponseBean<Void> addMateNote(@RequestBody @Valid RequestBean<AddMateNoteBo> param) {

        AddMateNoteBo mateNoteBo = param.getParam();
        mateNoteService.addMateNote(mateNoteBo);
        return ResponseUtil.success();
    }

    /**
     * 删除结伴游
     */
    @PostMapping(value = "deleteMateNote")
    public ResponseBean<Void> deleteMateNote(@RequestBody @Valid RequestBean<Long> param) {

        Long id = param.getParam();
        mateNoteService.deleteMateNote(id);
        return ResponseUtil.success();
    }

    /**
     * 修改结伴游
     */
    @PostMapping(value = "modifyMateNote")
    public ResponseBean<Void> modifyMateNote(@RequestBody @Valid RequestBean<MateNoteBo> param) {

        MateNoteBo mateNoteBo = param.getParam();
        mateNoteService.modifyMateNote(mateNoteBo);
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
     * 获取结伴游列表
     */
    @PostMapping("getMateNoteList")
    public ResponseBean<ListBean<MateNoteBo>> getMateNoteList(@Valid @RequestBody RequestBean<SortPagerQuery<MateNoteQuery>> requestBean) {
        SortPagerQuery<MateNoteQuery> sortPagerQuery = requestBean.getParam();
        return ResponseUtil.success(mateNoteService.getMateNoteList(sortPagerQuery));
    }

}
