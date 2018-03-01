package com.garfield.travelnote.biz.converter;

import com.garfield.travelnote.common.model.bo.ScenicSpotBo;
import com.garfield.travelnote.dal.domain.ScenicSpotDo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ScenicSpotConverter {

    public static ScenicSpotBo doToBo(ScenicSpotDo scenicSpotDo){
        ScenicSpotBo scenicSpotBo = new ScenicSpotBo();
        BeanUtils.copyProperties(scenicSpotDo,scenicSpotBo);
        return scenicSpotBo;
    }

    public static List<ScenicSpotBo> doToBos(List<ScenicSpotDo> scenicSpotDos){
        List<ScenicSpotBo> scenicSpotBos = new ArrayList<>();
        for (ScenicSpotDo scenicSpotDo : scenicSpotDos){
            scenicSpotBos.add(doToBo(scenicSpotDo));
        }
        return scenicSpotBos;
    }
}
