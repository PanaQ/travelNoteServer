package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.helper.HTTPS;
import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;
import com.garfield.travelnote.common.model.bo.NoteQuery;
import com.garfield.travelnote.common.model.bo.ScenicSpotBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import com.zhexinit.ov.common.query.ListBean;
import com.zhexinit.ov.common.query.SortPagerQuery;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

import java.util.List;

@HTTPS
public interface ScenicSpotService {

    @POST("/scenicSpot/getByDivisionId")
    Observable<ResponseBean<List<ScenicSpotBo>>> addNote(@Body RequestBean<Long> requestBean);

    @POST("/scenicSpot/sortRoute")
    Observable<ResponseBean<List<ScenicSpotBo>>> uploadPicture(@Body RequestBean<List<Long>> requestBean);

}
