package com.garfield.travelnote.biz.converter;

import com.garfield.travelnote.common.model.bo.DivisionBo;
import com.garfield.travelnote.dal.domain.DivisionDo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingly on 2018/2/24.
 */
public class DivisionConverter {
    public static DivisionBo doToBo(DivisionDo one) {
        DivisionBo bo = new DivisionBo();
        BeanUtils.copyProperties(one, bo);
        return bo;
    }

    public static List<DivisionBo> dosToBos(List<DivisionDo> administrativeDivisionDos) {
        List<DivisionBo> list = new ArrayList<DivisionBo>();
        for (DivisionDo administrativeDivisionDo : administrativeDivisionDos) {
            list.add(doToBo(administrativeDivisionDo));
        }
        return list;
    }
}
