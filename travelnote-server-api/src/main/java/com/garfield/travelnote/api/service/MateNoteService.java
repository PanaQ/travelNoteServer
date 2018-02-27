package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.helper.HTTPS;
import com.garfield.travelnote.common.model.bo.*;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import com.zhexinit.ov.common.query.ListBean;
import com.zhexinit.ov.common.query.SortPagerQuery;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

@HTTPS
public interface MateNoteService {

    @POST("/mateNote/addMateNote")
    Observable<ResponseBean<Void>> addMateNote(@Body RequestBean<AddMateNoteBo> requestBean);

    @POST("/mateNote/deleteMateNote")
    Observable<ResponseBean<Void>> deleteMateNote(@Body RequestBean<Long> requestBean);

    @POST("/mateNote/modifyMateNote")
    Observable<ResponseBean<Void>> modifyMateNote(@Body RequestBean<MateNoteBo> requestBean);

    @POST("/mateNote/getMateNoteById")
    Observable<ResponseBean<MateNoteBo>> getMateNoteById(@Body RequestBean<Long> requestBean);

    /**
     * 根据userId获取结伴游列表(获取别人的)
     */
    @POST("/mateNote/getMateNoteListByUserId")
    Observable<ResponseBean<ListBean<MateNoteBo>>> getMateNoteListByUserId(@Body RequestBean<SortPagerQuery<MateNoteQuery>> requestBean);

    /**
     * 获取自己的所有结伴游列表
     */
    @POST("/mateNote/getNoteListByMine")
    Observable<ResponseBean<ListBean<MateNoteBo>>> getMateNoteListByMine(@Body RequestBean<SortPagerQuery> requestBean);

    /**
     * 获取所有的结伴游列表
     */
    @POST("/mateNote/getMateNoteList")
    Observable<ResponseBean<ListBean<MateNoteBo>>> getMateNoteList(@Body RequestBean<SortPagerQuery> requestBean);

}
