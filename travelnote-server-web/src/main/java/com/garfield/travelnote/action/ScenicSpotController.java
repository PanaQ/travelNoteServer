package com.garfield.travelnote.action;


import com.garfield.travelnote.biz.service.ScenicSpotService;
import com.garfield.travelnote.common.model.bo.ScenicSpotBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import com.zhexinit.ov.common.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
