package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.api.model.bo.AddMateNoteBo;
import com.garfield.travelnote.api.model.bo.MateNoteBo;

import java.util.List;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface MateNoteService {

    void addMateNote(AddMateNoteBo addMateNoteBo);

    MateNoteBo getNoteBoById(Long id);

    void deleteMateNote(Long id,Long userId);

    void modifyMateNote(MateNoteBo mateNoteBo,Long userId);

    List<MateNoteBo> getMateNoteList();

    List<MateNoteBo> getMateNoteListByUserId(Long userId);

}
