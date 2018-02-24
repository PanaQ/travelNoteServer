package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.common.model.bo.AddNoteCommentBo;
import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface NoteCommentService {

    void addNoteComment(AddNoteCommentBo addNoteCommentBo);
}
