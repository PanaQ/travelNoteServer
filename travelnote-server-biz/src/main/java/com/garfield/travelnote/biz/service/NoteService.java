package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.api.model.bo.BaseNoteBo;
import com.garfield.travelnote.api.model.bo.NoteBo;

import java.util.List;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface NoteService {
    /**
     * 发表游记
     */
    void addNote(BaseNoteBo noteBo);

    NoteBo getNoteBoById(Long id);

    void deleteNote(Long id,Long userId);

    void modifyNote(BaseNoteBo noteBo);

    List<BaseNoteBo> getNoteListByUserId(Long userId);

    List<BaseNoteBo> getNoteList();

}
