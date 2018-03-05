package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.biz.service.MateNoteService;
import com.garfield.travelnote.api.model.bo.AddMateNoteBo;
import com.garfield.travelnote.api.model.bo.MateNoteBo;
import com.garfield.travelnote.api.util.ResultEnum;
import com.garfield.travelnote.dal.domain.MateNoteDo;
import com.garfield.travelnote.dal.mapper.MateNoteDoMapper;
import com.zhexinit.ov.common.exception.CommonException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jingly on 2018/2/24.
 */
@Service
public class MateNoteServiceImpl implements MateNoteService {

    @Autowired
    private MateNoteDoMapper mateNoteDoMapper;

    @Override
    public void addMateNote(AddMateNoteBo addMateNoteBo) {
        MateNoteDo mateNoteDo = new MateNoteDo();
        BeanUtils.copyProperties(addMateNoteBo, mateNoteDo);
        mateNoteDo.setIsDeleted(0);
        mateNoteDoMapper.insertSelective(mateNoteDo);
    }

    @Override
    public MateNoteBo getNoteBoById(Long id) {
        MateNoteBo mateNoteBo = mateNoteDoMapper.selectMateNoteById(id);
        if(mateNoteBo == null){
            throw new CommonException(ResultEnum.mateNoteNotExist);
        }
        return mateNoteBo;
    }

    @Override
    public void deleteMateNote(Long id,Long userId) {
        MateNoteDo mateNoteDo = mateNoteDoMapper.selectById(id,userId);
        if(mateNoteDo == null){
            throw new CommonException(ResultEnum.mateNoteNotExist);
        }
        mateNoteDo.setIsDeleted(1);
        mateNoteDoMapper.updateByPrimaryKeySelective(mateNoteDo);
    }

    @Override
    public void modifyMateNote(MateNoteBo mateNoteBo,Long userId) {
        MateNoteDo mateNoteDo = mateNoteDoMapper.selectById(mateNoteBo.getId(),userId);
        if(mateNoteDo == null){
            throw new CommonException(ResultEnum.mateNoteNotExist);
        }
        BeanUtils.copyProperties(mateNoteBo, mateNoteDo);
        mateNoteDoMapper.updateByPrimaryKeySelective(mateNoteDo);
    }

    @Override
    public List<MateNoteBo> getMateNoteList() {
        List<MateNoteBo> baseNoteBos = mateNoteDoMapper.selectMateNoteList();
        return baseNoteBos;
    }

    @Override
    public List<MateNoteBo> getMateNoteListByUserId(Long userId) {
        List<MateNoteBo> baseNoteBos = mateNoteDoMapper.selectMateNoteListByUserId(userId);
        return baseNoteBos;
    }

}
