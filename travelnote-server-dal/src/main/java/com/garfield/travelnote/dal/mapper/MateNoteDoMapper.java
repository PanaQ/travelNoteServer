package com.garfield.travelnote.dal.mapper;

import com.garfield.travelnote.common.model.bo.MateNoteBo;
import com.garfield.travelnote.common.model.bo.MateNoteQuery;
import com.garfield.travelnote.common.model.bo.NoteQuery;
import com.garfield.travelnote.dal.domain.MateNoteDo;
import com.garfield.travelnote.dal.util.MyMapper;
import com.zhexinit.ov.common.query.SortPagerQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateNoteDoMapper extends MyMapper<MateNoteDo> {
    MateNoteBo selectMateNoteById(Long id);

    MateNoteDo selectById(Long id);

    List<MateNoteBo> selectMateNoteList(SortPagerQuery<MateNoteQuery> sortPagerQuery);
}