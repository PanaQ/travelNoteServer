package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.api.model.bo.DivisionBo;

import java.util.List;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface DivisionService {
    List<DivisionBo> selectProvinces();

    List<DivisionBo> selectByParentCode(String parentCode);

    DivisionBo selectByCode(String code);

}
