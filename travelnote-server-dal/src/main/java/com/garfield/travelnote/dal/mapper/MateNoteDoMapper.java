package com.garfield.travelnote.dal.mapper;

import com.garfield.travelnote.common.model.bo.MateNoteBo;
import com.garfield.travelnote.dal.domain.MateNoteDo;
import com.garfield.travelnote.dal.util.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface MateNoteDoMapper extends MyMapper<MateNoteDo> {
    MateNoteBo selectById(Long id);
}