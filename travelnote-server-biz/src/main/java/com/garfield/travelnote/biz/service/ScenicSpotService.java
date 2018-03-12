package com.garfield.travelnote.biz.service;

import com.garfield.travelnote.api.model.bo.ScenicSpotBo;
import com.garfield.travelnote.api.model.bo.TrainBo;
import com.garfield.travelnote.api.model.query.TrainQuery;

import java.util.List;

public interface ScenicSpotService {

    List<ScenicSpotBo> getByDivisionId(Long divisionId);

    List<ScenicSpotBo> sortRoute(List<Long> scenicSpotBoIds);

    List<ScenicSpotBo> sortByLevel(List<Long> scenicSpotBoIds);

    List<TrainBo> queryTrain(TrainQuery trainQuery);
}
