package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.common.model.bo.AddMateNoteBo;
import com.garfield.travelnote.common.model.bo.MateNoteBo;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface MateNoteService {

    void addMateNote(AddMateNoteBo addMateNoteBo);

    MateNoteBo getNoteBoById(Long id);
}
