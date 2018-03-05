package com.garfield.travelnote.dal.mapper;

import com.garfield.travelnote.api.model.bo.BaseNoteBo;
import com.garfield.travelnote.api.model.bo.NoteBo;
import com.garfield.travelnote.dal.domain.NoteDo;
import com.garfield.travelnote.dal.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDoMapper extends MyMapper<NoteDo> {
    NoteBo selectNoteBoById(Long id);

    NoteDo selectById(@Param("id") Long id, @Param("userId") Long userId);

    List<BaseNoteBo> selectNoteListByUserId(Long userId);

    List<BaseNoteBo> selectNoteList();

}