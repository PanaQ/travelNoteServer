package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.helper.HTTPS;
import com.garfield.travelnote.common.model.bo.MateNoteBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

@HTTPS
public interface FollowService {

    @POST("/follow/addFollow")
    Observable<ResponseBean<Void>> addFollow(@Body RequestBean<Long> requestBean);

    @POST("/follow/cancelFollow")
    Observable<ResponseBean<MateNoteBo>> cancelFollow(@Body RequestBean<Long> requestBean);

    @POST("/follow/isFollow")
    Observable<ResponseBean<Boolean>> isFollow(@Body RequestBean<Long> requestBean);

    @POST("/follow/getAttentionList")
    Observable<ResponseBean<MateNoteBo>> getAttentionList();

    @POST("/follow/getFansList")
    Observable<ResponseBean<MateNoteBo>> getFansList();

}
