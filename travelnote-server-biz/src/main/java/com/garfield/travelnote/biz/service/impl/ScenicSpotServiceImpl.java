package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.api.model.bo.ScenicSpotBo;
import com.garfield.travelnote.api.model.bo.TrainBo;
import com.garfield.travelnote.api.model.bo.TrainListBo;
import com.garfield.travelnote.api.model.query.TrainQuery;
import com.garfield.travelnote.biz.converter.ScenicSpotConverter;
import com.garfield.travelnote.biz.service.ScenicSpotService;
import com.garfield.travelnote.common.util.HttpUtils;
import com.garfield.travelnote.dal.domain.ScenicSpotDo;
import com.garfield.travelnote.dal.mapper.ScenicSpotDoMapper;
import com.garfield.travelnote.dal.util.DistanceUtil;
import com.zhexinit.ov.common.util.JsonUtil;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

import static com.garfield.travelnote.common.util.HttpUtils.net;

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
        List<ScenicSpotDo> scenicSpotDos = scenicSpotDoMapper.selectByIds(scenicSpotBoIds);
        scenicSpotDos = DistanceUtil.getOptimalRoute(scenicSpotDos);
        return ScenicSpotConverter.doToBos(scenicSpotDos);
    }

    @Override
    public List<ScenicSpotBo> sortByLevel(List<Long> scenicSpotBoIds) {
        List<ScenicSpotDo> scenicSpotDos = scenicSpotDoMapper.sortByLevel(scenicSpotBoIds);
        return ScenicSpotConverter.doToBos(scenicSpotDos);
    }

    @Override
    public List<TrainBo> queryTrain(TrainQuery trainQuery){
        List<TrainBo> trainBoList = new ArrayList<>();

        String result =null;
        String url ="http://apis.juhe.cn/train/s2swithprice";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("start",trainQuery.getStartStation());//出发站
        params.put("end",trainQuery.getEndStation());//终点站
        params.put("key",HttpUtils.APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","json");//返回数据的格式,xml或json，默认json
        if(!TextUtils.isEmpty(trainQuery.getDate())){
            params.put("date",trainQuery.getDate());//格式：2016-12-12，默认明天
        }

        try {
            result = net(url, params, "GET");
            if(result != null){
                //获取response的body
                System.out.println("responseStr = "+result);
                TrainListBo bean = JsonUtil.objectMapper().readValue(result, TrainListBo.class);
                if(bean != null && bean.getError_code() == 0 && bean.getResult() != null){

                    List<TrainListBo.ResultBean.ListBean> list = bean.getResult().getList();
                    if(list != null && list.size() > 0){
                        for (int i = 0; i < list.size(); i++) {
                            TrainListBo.ResultBean.ListBean listBean = list.get(i);
                            TrainBo trainBo = new TrainBo();
                            trainBo.setTrainNo(listBean.getTrain_no());
                            trainBo.setStartStation(listBean.getStart_station());
                            trainBo.setEndStation(listBean.getEnd_station());
                            trainBo.setStartTime(listBean.getStart_time());
                            trainBo.setEndTime(listBean.getEnd_time());
                            trainBo.setRunTime(listBean.getRun_time());
                            List<TrainListBo.ResultBean.ListBean.PriceListBean> priceBeanList = listBean.getPrice_list();
                            if(priceBeanList != null && priceBeanList.size() > 0){
                                List<Double> priceList = new ArrayList<>();
                                for (int j = 0; j < priceBeanList.size(); j++) {
                                    TrainListBo.ResultBean.ListBean.PriceListBean priceBean = priceBeanList.get(j);
                                    Double price = Double.valueOf(priceBean.getPrice());
                                    priceList.add(price);
                                }
                                Double price = Collections.min(priceList);
                                trainBo.setPrice(price);
                            }
                            trainBoList.add(trainBo);
                        }
                    }
                }
            }
        }catch (Exception e) {
                e.printStackTrace();
        }

        return trainBoList;
    }


}
