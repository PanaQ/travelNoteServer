package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.biz.service.MateNoteService;
import com.garfield.travelnote.common.bean.ResultEnum;
import com.garfield.travelnote.common.model.bo.AddMateNoteBo;
import com.garfield.travelnote.common.model.bo.MateNoteBo;
import com.garfield.travelnote.dal.domain.MateNoteDo;
import com.garfield.travelnote.dal.mapper.MateNoteDoMapper;
import com.zhexinit.ov.common.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        mateNoteDo.setUserId(addMateNoteBo.getUserId());
        mateNoteDo.setPlace(addMateNoteBo.getPlace());
        mateNoteDo.setPhone(addMateNoteBo.getPhone());
        mateNoteDo.setTitle(addMateNoteBo.getTitle());
        mateNoteDo.setContent(addMateNoteBo.getContent());
        mateNoteDo.setIsDeleted(0);
        mateNoteDoMapper.insertSelective(mateNoteDo);
    }

    @Override
    public MateNoteBo getNoteBoById(Long id) {
        MateNoteBo mateNoteBo = mateNoteDoMapper.selectById(id);
        if(mateNoteBo == null){
            throw new CommonException(ResultEnum.mateNoteNotExist);
        }
        return mateNoteBo;
    }
}
