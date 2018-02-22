package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.helper.HTTPS;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by konie on 16-12-14.
 */
@HTTPS
public interface UserLoginService {

    @POST("/appUser/login")
    Observable<String> loginWithPhone();

    @POST("/appUser/logout")
    Observable<Void> loginOut();

}
