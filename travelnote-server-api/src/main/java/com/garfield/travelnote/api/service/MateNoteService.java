package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.helper.HTTPS;
import com.garfield.travelnote.common.model.bo.AddMateNoteBo;
import com.garfield.travelnote.common.model.bo.MateNoteBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

@HTTPS
public interface MateNoteService {

    @POST("/mateNote/addMateNote")
    Observable<ResponseBean<Void>> addMateNote(@Body RequestBean<AddMateNoteBo> requestBean);

    @POST("/mateNote/getMateNoteById")
    Observable<ResponseBean<MateNoteBo>> getMateNoteById(@Body RequestBean<Long> requestBean);

}
