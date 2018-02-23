package com.garfield.travelnote.action;

import com.garfield.travelnote.biz.service.impl.NoteService;
import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;
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
 *  用户Controller
 **/
@RestController
@RequestMapping("note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    /**
     * 发表游记
     */
    @PostMapping(value = "addNote")
    public ResponseBean<Void> addNote(@RequestBody @Valid RequestBean<BaseNoteBo> param) {

        BaseNoteBo noteBo = param.getParam();
        noteService.addNote(noteBo);
        return ResponseUtil.success();
    }

    /**
     * 根据id查看游记
     */
    @PostMapping(value = "getNoteById")
    public ResponseBean<NoteBo> getNoteById(@RequestBody RequestBean<Long> param){
        Long id = param.getParam();
        NoteBo noteBo = noteService.getNoteBoById(id);
        return ResponseUtil.success(noteBo);
    }


}
