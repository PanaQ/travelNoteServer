package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.helper.HTTPS;
import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import org.apache.ibatis.annotations.Param;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

import javax.servlet.http.HttpServletRequest;

@HTTPS
public interface NoteService {

    @POST("/note/addNote")
    Observable<ResponseBean<Void>> addNote(@Body RequestBean<BaseNoteBo> requestBean);

    @POST("/note/uploadPicture")
    Observable<ResponseBean<Void>> uploadPicture(@Param("picture") HttpServletRequest request);

    @POST("/note/uploadVideo")
    Observable<ResponseBean<Void>> uploadVideo(@Param("video") HttpServletRequest request);

    @POST("/note/getNoteById")
    Observable<ResponseBean<NoteBo>> getNoteById(@Body RequestBean<Long> requestBean);

}
