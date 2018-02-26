package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface NoteService {
    /**
     * 发表游记
     */
    void addNote(BaseNoteBo noteBo);

    NoteBo getNoteBoById(Long id);
}
