package com.garfield.travelnote.common.model.bo;

import javax.persistence.Column;
import java.util.List;

/**
 * Created by Jingly on 2018/2/22.
 */
public class NoteBo extends BaseNoteBo{

    /**
     * 用户名
     */
    private String userName;
    /**
     * 留言列表
     */
    private List<NoteCommentBo> noteCommentBoList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<NoteCommentBo> getNoteCommentBoList() {
        return noteCommentBoList;
    }

    public void setNoteCommentBoList(List<NoteCommentBo> noteCommentBoList) {
        this.noteCommentBoList = noteCommentBoList;
    }
}
