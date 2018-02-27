package com.garfield.travelnote.dal.mapper;

import com.garfield.travelnote.common.model.bo.MateNoteBo;
import com.garfield.travelnote.common.model.bo.MateNoteQuery;
import com.garfield.travelnote.common.model.bo.NoteQuery;
import com.garfield.travelnote.dal.domain.MateNoteDo;
import com.garfield.travelnote.dal.util.MyMapper;
import com.zhexinit.ov.common.query.SortPagerQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateNoteDoMapper extends MyMapper<MateNoteDo> {
    MateNoteBo selectMateNoteById(Long id);

    MateNoteDo selectById(@Param("id") Long id, @Param("userId") Long userId);

    List<MateNoteBo> selectMateNoteList(@Param("sortPagerQuery") SortPagerQuery<MateNoteQuery> sortPagerQuery, @Param("userId") Long userId);

    List<MateNoteBo> selectMateNoteListByUserId(SortPagerQuery<MateNoteQuery> sortPagerQuery);
}