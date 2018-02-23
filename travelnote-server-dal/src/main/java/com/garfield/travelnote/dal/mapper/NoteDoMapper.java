package com.garfield.travelnote.dal.mapper;

import com.garfield.travelnote.common.model.bo.NoteBo;
import com.garfield.travelnote.dal.domain.NoteDo;
import com.garfield.travelnote.dal.util.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDoMapper extends MyMapper<NoteDo> {
    NoteBo selectNoteBoById(Long id);
}