package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.helper.HTTPS;
import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

@HTTPS
public interface NoteService {

    @POST("/note/addNote")
    Observable<ResponseBean<Void>> addNote(@Body RequestBean<BaseNoteBo> requestBean);

    @Multipart
    @POST("/note/uploadPicture")
    Observable<ResponseBean<Void>> uploadPicture(@Part("picture") MultipartBody.Part file);

    @Multipart
    @POST("/note/uploadVideo")
    Observable<ResponseBean<Void>> uploadVideo(@Part("video") MultipartBody.Part file);

    @POST("/note/getNoteById")
    Observable<ResponseBean<NoteBo>> getNoteById(@Body RequestBean<Long> requestBean);

}
