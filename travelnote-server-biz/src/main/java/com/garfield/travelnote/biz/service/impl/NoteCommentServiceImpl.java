package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.common.model.bo.AddNoteCommentBo;
import com.garfield.travelnote.dal.domain.NoteCommentDo;
import com.garfield.travelnote.dal.mapper.NoteCommentDoMapper;
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
    public void addNoteComment(AddNoteCommentBo addNoteCommentBo) {
        NoteCommentDo noteCommentDo = new NoteCommentDo();
        noteCommentDo.setNoteId(addNoteCommentBo.getNoteId());
        noteCommentDo.setUserId(addNoteCommentBo.getCommentUserId());
        noteCommentDo.setComment(addNoteCommentBo.getComment());
        noteCommentDo.setIsDeleted(0);

        noteCommentDoMapper.insertSelective(noteCommentDo);
    }
}
