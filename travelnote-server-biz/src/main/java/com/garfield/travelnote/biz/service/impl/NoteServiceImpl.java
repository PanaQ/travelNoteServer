package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.biz.service.NoteService;
import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;
import com.garfield.travelnote.common.model.bo.NoteQuery;
import com.garfield.travelnote.common.util.ResultEnum;
import com.garfield.travelnote.dal.domain.NoteDo;
import com.garfield.travelnote.dal.mapper.NoteDoMapper;
import com.github.pagehelper.PageHelper;
import com.zhexinit.ov.common.exception.CommonException;
import com.zhexinit.ov.common.query.ListBean;
import com.zhexinit.ov.common.query.SortPagerQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void deleteNote(Long id) {
        NoteDo noteDo = noteDoMapper.selectById(id);
        if(noteDo == null){
            throw new CommonException(ResultEnum.noteNotExist);
        }
        noteDo.setIsDeleted(1);
        noteDoMapper.updateByPrimaryKeySelective(noteDo);
    }

    @Override
    public void modifyNote(BaseNoteBo noteBo) {
        NoteDo noteDo = noteDoMapper.selectById(noteBo.getId());
        if(noteDo == null){
            throw new CommonException(ResultEnum.noteNotExist);
        }
        BeanUtils.copyProperties(noteBo, noteDo);
        noteDoMapper.updateByPrimaryKeySelective(noteDo);
    }

    @Override
    public ListBean<BaseNoteBo> getNoteList(SortPagerQuery<NoteQuery> sortPagerQuery) {
        List<BaseNoteBo> listCountry = PageHelper.startPage(sortPagerQuery.getCurrent(), sortPagerQuery.getPageSize());
        List<BaseNoteBo> baseNoteBos = noteDoMapper.selectNoteList(sortPagerQuery);
        int total = listCountry.size();

        return new ListBean<>(total,baseNoteBos);
    }
}
