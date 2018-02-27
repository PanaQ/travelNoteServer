package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;
import com.garfield.travelnote.common.model.bo.NoteQuery;
import com.zhexinit.ov.common.query.ListBean;
import com.zhexinit.ov.common.query.SortPagerQuery;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface NoteService {
    /**
     * 发表游记
     */
    void addNote(BaseNoteBo noteBo);

    NoteBo getNoteBoById(Long id);

    void deleteNote(Long id,Long userId);

    void modifyNote(BaseNoteBo noteBo);

    ListBean<BaseNoteBo> getNoteListByUserId(SortPagerQuery<NoteQuery> sortPagerQuery);

    ListBean<BaseNoteBo> getNoteList(SortPagerQuery<NoteQuery> sortPagerQuery);

    ListBean<BaseNoteBo> getNoteListByMine(SortPagerQuery sortPagerQuery, Long userId);
}
