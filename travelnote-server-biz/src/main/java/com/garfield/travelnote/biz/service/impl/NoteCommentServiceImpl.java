package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.biz.service.NoteCommentService;
import com.garfield.travelnote.api.model.bo.AddNoteCommentBo;
import com.garfield.travelnote.dal.domain.NoteCommentDo;
import com.garfield.travelnote.dal.mapper.NoteCommentDoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jingly on 2018/2/24.
 */
@Service
public class NoteCommentServiceImpl implements NoteCommentService {
    @Autowired
    private NoteCommentDoMapper noteCommentDoMapper;

    @Override
    public void addNoteComment(AddNoteCommentBo addNoteCommentBo,Long userId) {
        NoteCommentDo noteCommentDo = new NoteCommentDo();
        BeanUtils.copyProperties(addNoteCommentBo, noteCommentDo);
        noteCommentDo.setUserId(userId);
        noteCommentDo.setIsDeleted(0);

        noteCommentDoMapper.insertSelective(noteCommentDo);
    }
}
