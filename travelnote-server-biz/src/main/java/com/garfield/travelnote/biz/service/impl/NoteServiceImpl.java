package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;
import com.garfield.travelnote.dal.domain.NoteDo;
import com.garfield.travelnote.dal.mapper.NoteDoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jingly on 2018/2/22.
 */
@Service
public class NoteServiceImpl implements NoteService  {

    @Autowired
    private NoteDoMapper noteDoMapper;

    @Override
    public void addNote(BaseNoteBo noteBo) {
        NoteDo noteDo = new NoteDo();
        BeanUtils.copyProperties(noteBo, noteDo);
        noteDo.setIsDeleted(0);
        noteDoMapper.insertSelective(noteDo);
    }

    @Override
    public NoteBo getNoteBoById(Long id) {
        return noteDoMapper.selectNoteBoById(id);
    }
}
