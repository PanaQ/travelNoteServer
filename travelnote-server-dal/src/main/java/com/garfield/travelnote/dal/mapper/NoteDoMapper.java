package com.garfield.travelnote.dal.mapper;

import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;
import com.garfield.travelnote.common.model.bo.NoteQuery;
import com.garfield.travelnote.dal.domain.NoteDo;
import com.garfield.travelnote.dal.util.MyMapper;
import com.zhexinit.ov.common.query.SortPagerQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDoMapper extends MyMapper<NoteDo> {
    NoteBo selectNoteBoById(Long id);

    List<BaseNoteBo> selectNoteList(SortPagerQuery<NoteQuery> sortPagerQuery);

    NoteDo selectById(Long id);
}