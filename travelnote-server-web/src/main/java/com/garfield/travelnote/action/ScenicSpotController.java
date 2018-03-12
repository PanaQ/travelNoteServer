package com.garfield.travelnote.action;


import com.garfield.travelnote.api.model.bo.DivisionBo;
import com.garfield.travelnote.api.model.bo.TrainBo;
import com.garfield.travelnote.api.model.query.TrainQuery;
import com.garfield.travelnote.biz.service.ScenicSpotService;
import com.garfield.travelnote.api.model.bo.ScenicSpotBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import com.zhexinit.ov.common.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "scenicSpot")
public class ScenicSpotController {

    @Autowired
    private ScenicSpotService scenicSpotService;

    /**
     * 查询地区的所有景点
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "getByDivisionId",method = RequestMethod.POST)
    public ResponseBean<List<ScenicSpotBo>> getByDivisionId(@RequestBody RequestBean<Long> requestBean){
        List<ScenicSpotBo> scenicSpotBos = scenicSpotService.getByDivisionId(requestBean.getParam());
        return ResponseUtil.success(scenicSpotBos);
    }

    /**
     * 出行排序
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "sortRoute")
    public ResponseBean<List<ScenicSpotBo>> sortRoute(@RequestBody RequestBean<List<Long>> requestBean){
        List<ScenicSpotBo> scenicSpotBos = scenicSpotService.sortRoute(requestBean.getParam());
        return ResponseUtil.success(scenicSpotBos);
    }

    /**
     *  出行按星级排序
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "sortByLevel")
    public ResponseBean<List<ScenicSpotBo>> sortByLevel(@RequestBody RequestBean<List<Long>> requestBean){
        List<ScenicSpotBo> scenicSpotBos = scenicSpotService.sortByLevel(requestBean.getParam());
        return ResponseUtil.success(scenicSpotBos);
    }

    @PostMapping("queryTrain")
    public ResponseBean<List<TrainBo>> queryTrain(@RequestBody RequestBean<TrainQuery> requestBean) {
        TrainQuery trainQuery = requestBean.getParam();
        List<TrainBo> trainBoList = scenicSpotService.queryTrain(trainQuery);
        return ResponseUtil.success(trainBoList);
    }

}
