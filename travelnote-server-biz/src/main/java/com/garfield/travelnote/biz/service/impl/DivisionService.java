package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.common.model.bo.AddMateNoteBo;
import com.garfield.travelnote.common.model.bo.DivisionBo;
import com.garfield.travelnote.common.model.bo.MateNoteBo;

import java.util.List;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface DivisionService {
    List<DivisionBo> selectProvinces();

    List<DivisionBo> selectByParentCode(String parentCode);

    DivisionBo selectByCode(String code);

}
