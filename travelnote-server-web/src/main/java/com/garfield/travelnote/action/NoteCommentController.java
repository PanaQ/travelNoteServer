package com.garfield.travelnote.action;

import com.garfield.travelnote.biz.service.NoteCommentService;
import com.garfield.travelnote.common.model.bo.AddNoteCommentBo;
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
 *  留言Controller
 **/
@RestController
@RequestMapping("noteComment")
public class NoteCommentController {

    @Autowired
    private NoteCommentService noteCommentService;

    /**
     * 发表留言
     */
    @PostMapping(value = "addNoteComment")
    public ResponseBean<Void> addNoteComment(@RequestBody @Valid RequestBean<AddNoteCommentBo> param) {

        AddNoteCommentBo addNoteCommentBo = param.getParam();
        noteCommentService.addNoteComment(addNoteCommentBo);
        return ResponseUtil.success();
    }



}
