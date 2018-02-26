package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.common.model.bo.AddMateNoteBo;
import com.garfield.travelnote.common.model.bo.MateNoteBo;
import com.garfield.travelnote.common.model.bo.MateNoteQuery;
import com.garfield.travelnote.common.model.bo.NoteQuery;
import com.zhexinit.ov.common.query.ListBean;
import com.zhexinit.ov.common.query.SortPagerQuery;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface MateNoteService {

    void addMateNote(AddMateNoteBo addMateNoteBo);

    MateNoteBo getNoteBoById(Long id);

    void deleteMateNote(Long id);

    void modifyMateNote(MateNoteBo mateNoteBo);

    ListBean<MateNoteBo> getMateNoteList(SortPagerQuery<MateNoteQuery> sortPagerQuery);
}
