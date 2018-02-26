package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.helper.HTTPS;
import com.garfield.travelnote.common.model.bo.LoginBean;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

@HTTPS
public interface UserLoginService {

    @POST("/user/login")
    Observable<ResponseBean<Void>> login(@Body RequestBean<LoginBean> requestBean);

    @POST("/user/logout")
    @Headers("X-Auth-Token")
    Observable<Void> logout();

}
