package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.api.model.bo.AddNoteCommentBo;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface NoteCommentService {

    void addNoteComment(AddNoteCommentBo addNoteCommentBo,Long userId);
}
