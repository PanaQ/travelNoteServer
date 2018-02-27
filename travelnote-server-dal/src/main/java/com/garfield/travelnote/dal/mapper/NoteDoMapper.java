package com.garfield.travelnote.dal.mapper;

import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;
import com.garfield.travelnote.common.model.bo.NoteQuery;
import com.garfield.travelnote.dal.domain.NoteDo;
import com.garfield.travelnote.dal.util.MyMapper;
import com.zhexinit.ov.common.query.SortPagerQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDoMapper extends MyMapper<NoteDo> {
    NoteBo selectNoteBoById(Long id);

    NoteDo selectById(@Param("id") Long id, @Param("userId") Long userId);

    List<BaseNoteBo> selectNoteListByUserId(SortPagerQuery<NoteQuery> sortPagerQuery);

    List<BaseNoteBo> selectNoteList(@Param("sortPagerQuery") SortPagerQuery sortPagerQuery, @Param("userId") Long userId);

}