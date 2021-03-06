package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.model.bo.DivisionBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface DevisionService {

    /**
     * 查询省份列表
     * @param param
     * @return
     */
    @GET("/division/selectProvinces")
    Observable<ResponseBean<List<DivisionBo>>> selectProvinces(RequestBean<Void> param);

    /**
     * 查询省市区
     * @param parentCode
     * @return
     */
    @GET("/division/selectByParentCode")
    Observable<ResponseBean<List<DivisionBo>>> selectByParentCode(@Query("parentCode") String parentCode);

    /**
     * 查询
     * @param code
     * @return
     */
    @GET("/division/selectByCode")
    Observable<ResponseBean<List<DivisionBo>>> selectByCode(@Query("code") String code);

}
