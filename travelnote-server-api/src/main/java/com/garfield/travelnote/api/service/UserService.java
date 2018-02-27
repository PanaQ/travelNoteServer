package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.helper.HTTPS;
import com.garfield.travelnote.common.model.bo.BaseUserBo;
import com.garfield.travelnote.common.model.bo.LoginBean;
import com.garfield.travelnote.common.model.bo.UserBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

@HTTPS
public interface UserService {

    /**
     * 登录
     * @param requestBean
     * @return
     */
    @POST("/user/login")
    Observable<ResponseBean<Void>> login(@Body RequestBean<LoginBean> requestBean);

    /**
     * 退出
     * @return
     */
    @POST("/user/logout")
    @Headers("X-Auth-Token")
    Observable<Void> logout();

    /**
     * 用户注册
     * @param param
     * @return
     */
    @POST("/user/register")
    Observable<ResponseBean<Void>> register(@Body RequestBean<BaseUserBo> param);

    /**
     * 获取我的个人信息
     * @param param
     * @return
     */
    @POST("/user/getMyInfo")
    Observable<ResponseBean<UserBo>> getMyInfo(@Body RequestBean<Void> param);

}
