package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.common.model.bo.ScenicSpotBo;

import java.util.List;

public interface ScenicSpotService {

    List<ScenicSpotBo> getByDivisionId(Long divisionId);

    List<ScenicSpotBo> sortRoute(List<Long> scenicSpotBoIds);

    List<ScenicSpotBo> sortByLevel(List<Long> scenicSpotBoIds);
}
