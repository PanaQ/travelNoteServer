package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.biz.service.NoteService;
import com.garfield.travelnote.api.model.bo.BaseNoteBo;
import com.garfield.travelnote.api.model.bo.NoteBo;
import com.garfield.travelnote.api.util.ResultEnum;
import com.garfield.travelnote.dal.domain.NoteDo;
import com.garfield.travelnote.dal.mapper.NoteDoMapper;
import com.zhexinit.ov.common.exception.CommonException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jingly on 2018/2/22.
 */
@Service
public class NoteServiceImpl implements NoteService {

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

    @Override
    public void deleteNote(Long id,Long userId) {
        NoteDo noteDo = noteDoMapper.selectById(id,userId);
        if(noteDo == null){
            throw new CommonException(ResultEnum.noteNotExist);
        }
        noteDo.setIsDeleted(1);
        noteDoMapper.updateByPrimaryKeySelective(noteDo);
    }

    @Override
    public void modifyNote(BaseNoteBo noteBo) {
        NoteDo noteDo = noteDoMapper.selectById(noteBo.getId(),noteBo.getUserId());
        if(noteDo == null){
            throw new CommonException(ResultEnum.noteNotExist);
        }
        BeanUtils.copyProperties(noteBo, noteDo);
        noteDoMapper.updateByPrimaryKeySelective(noteDo);
    }

    @Override
    public List<BaseNoteBo> getNoteListByUserId(Long userId) {
        List<BaseNoteBo> baseNoteBos = noteDoMapper.selectNoteListByUserId(userId);
        return baseNoteBos;
    }

    @Override
    public List<BaseNoteBo> getNoteList() {
        List<BaseNoteBo> baseNoteBos = noteDoMapper.selectNoteList();
        return baseNoteBos;
    }


}
