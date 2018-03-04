package com.garfield.travelnote.dal.util;

import com.garfield.travelnote.dal.domain.ScenicSpotDo;
import org.springframework.data.geo.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author treezhu
 */
public class DistanceUtil {

    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算两点之间的距离
     *
     * @return
     */
    public static Double getDistance(ScenicSpotDo scenicSpot1, ScenicSpotDo scenicSpot2) {
        double radLat1 = rad(scenicSpot1.getLatitude());
        double radLat2 = rad(scenicSpot2.getLatitude());
        double a = radLat1 - radLat2;
        double b = rad(scenicSpot1.getLongitude()) - rad(scenicSpot2.getLongitude());
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 1000);
        return s;
    }

    /**
     * Dijkstra 算法计算最优路径
     *
     * @return
     */
    public static List<ScenicSpotDo> getOptimalRoute(List<ScenicSpotDo> scenicSpotDos) {
        List<ScenicSpotDo> result = new ArrayList<>();
        Double totalDistance = 0d;
        if (scenicSpotDos != null && !scenicSpotDos.isEmpty()) {
            Map<String, Double> weightMap = new HashMap<>();
            for (ScenicSpotDo from : scenicSpotDos) {
                for (ScenicSpotDo to : scenicSpotDos) {
                    weightMap.put(from.getId() + "-" + to.getId(), getDistance(from, to));
                }
            }
            ScenicSpotDo top = scenicSpotDos.get(0);
            result.add(top);
            scenicSpotDos.remove(top);
            do {
                Double shortestDistance = Double.MAX_VALUE;
                ScenicSpotDo nextSpot = null;
                for (ScenicSpotDo scenicSpot : scenicSpotDos) {
                    Double distance = getDistance(top, scenicSpot);
                    if (distance <= shortestDistance) {
                        shortestDistance = distance;
                        nextSpot = scenicSpot;
                    }
                }
                totalDistance += getDistance(top,nextSpot);
                result.add(nextSpot);
                scenicSpotDos.remove(nextSpot);
                top = nextSpot;
            }
            while (!scenicSpotDos.isEmpty());
        }
        return result;
    }


    public static void main(String[] args) {
        List<ScenicSpotDo> scenicSpotDos = new ArrayList<>();
        ScenicSpotDo spotDo1 = new ScenicSpotDo();
        spotDo1.setLatitude(1);
        spotDo1.setLongitude(1);
        ScenicSpotDo spotDo2 = new ScenicSpotDo();
        spotDo2.setLatitude(4);
        spotDo2.setLongitude(1);
        ScenicSpotDo spotDo3 = new ScenicSpotDo();
        spotDo3.setLatitude(2);
        spotDo3.setLongitude(2);
        ScenicSpotDo spotDo4 = new ScenicSpotDo();
        spotDo4.setLatitude(5);
        spotDo4.setLongitude(3);
        ScenicSpotDo spotDo5 = new ScenicSpotDo();
        spotDo5.setLatitude(4);
        spotDo5.setLongitude(4);
        scenicSpotDos.add(spotDo3);
        scenicSpotDos.add(spotDo2);
        scenicSpotDos.add(spotDo1);
        scenicSpotDos.add(spotDo5);
        scenicSpotDos.add(spotDo4);
        scenicSpotDos = getOptimalRoute(scenicSpotDos);
        for (ScenicSpotDo scenic :
                scenicSpotDos) {
            System.out.println(scenic.getLatitude()+","+scenic.getLongitude());
        }
    }

}
