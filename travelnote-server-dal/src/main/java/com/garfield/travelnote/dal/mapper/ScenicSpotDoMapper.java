package com.garfield.travelnote.dal.mapper;

import com.garfield.travelnote.dal.domain.ScenicSpotDo;
import com.garfield.travelnote.dal.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenicSpotDoMapper extends MyMapper<ScenicSpotDo> {


    List<ScenicSpotDo> selectByIds(@Param("ids") List<Long> scenicSpotBoIds);

    List<ScenicSpotDo> sortByLevel(@Param("ids") List<Long> scenicSpotBoIds);
}