package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.helper.HTTPS;
import com.garfield.travelnote.api.model.bo.*;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

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
    Observable<ResponseBean<List<MateNoteBo>>> getMateNoteListByUserId(@Body RequestBean<Long> requestBean);

    /**
     * 获取自己的所有结伴游列表
     */
    @POST("/mateNote/getNoteListByMine")
    Observable<ResponseBean<List<MateNoteBo>>> getMateNoteListByMine();

    /**
     * 获取所有的结伴游列表
     */
    @POST("/mateNote/getMateNoteList")
    Observable<ResponseBean<List<MateNoteBo>>> getMateNoteList();

}
