package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.biz.converter.ScenicSpotConverter;
import com.garfield.travelnote.biz.service.ScenicSpotService;
import com.garfield.travelnote.common.model.bo.ScenicSpotBo;
import com.garfield.travelnote.dal.domain.ScenicSpotDo;
import com.garfield.travelnote.dal.mapper.ScenicSpotDoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ScenicSpotServiceImpl implements ScenicSpotService {

    @Autowired
    private ScenicSpotDoMapper scenicSpotDoMapper;

    /**
     * 查询地区的所有景点
     * @param divisionId
     * @return
     */
    @Override
    public List<ScenicSpotBo> getByDivisionId(Long divisionId) {
        Example example = new Example(ScenicSpotDo.class);
        example.createCriteria().andEqualTo("divisionId",divisionId)
                .andEqualTo("isDeleted",0);
        List<ScenicSpotDo> scenicSpotDos = scenicSpotDoMapper.selectByExample(example);
        return ScenicSpotConverter.doToBos(scenicSpotDos);
    }

    @Override
    public List<ScenicSpotBo> sortRoute(List<Long> scenicSpotBoIds) {

        return null;
    }
}
