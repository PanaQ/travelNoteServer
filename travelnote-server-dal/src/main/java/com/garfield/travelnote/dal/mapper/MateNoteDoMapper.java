package com.garfield.travelnote.dal.mapper;

import com.garfield.travelnote.api.model.bo.MateNoteBo;
import com.garfield.travelnote.dal.domain.MateNoteDo;
import com.garfield.travelnote.dal.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateNoteDoMapper extends MyMapper<MateNoteDo> {
    MateNoteBo selectMateNoteById(Long id);

    MateNoteDo selectById(@Param("id") Long id, @Param("userId") Long userId);

    List<MateNoteBo> selectMateNoteList();

    List<MateNoteBo> selectMateNoteListByUserId(Long userId);
}