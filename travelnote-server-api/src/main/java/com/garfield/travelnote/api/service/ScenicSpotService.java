package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.helper.HTTPS;
import com.garfield.travelnote.api.model.bo.ScenicSpotBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

@HTTPS
public interface ScenicSpotService {

    @POST("/scenicSpot/getByDivisionId")
    Observable<ResponseBean<List<ScenicSpotBo>>> getByDivisionId(@Body RequestBean<Long> requestBean);

    @POST("/scenicSpot/sortRoute")
    Observable<ResponseBean<List<ScenicSpotBo>>> sortRoute(@Body RequestBean<List<Long>> requestBean);

    @POST("/scenicSpot/sortByLevel")
    Observable<ResponseBean<List<ScenicSpotBo>>> sortByLevel(@Body RequestBean<List<Long>> requestBean);
}
