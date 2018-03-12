package com.garfield.travelnote.dal.domain;

import javax.persistence.*;

@Table(name = "train")
public class TrainDo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 列次名称
     */
    @Column(name = "train_no")
    private String trainNo;

    /**
     * 起点站
     */
    @Column(name = "start_station")
    private String startStation;

    /**
     * 终点站
     */
    @Column(name = "end_station")
    private String endStation;

    /**
     * 发车时间
     */
    @Column(name = "start_time")
    private String startTime;

    /**
     * 到达时间
     */
    @Column(name = "end_time")
    private String endTime;

    /**
     * 运行时间
     */
    @Column(name = "run_time")
    private String runTime;

    /**
     * 创建时间，秒时间戳
     */
    @Column(name = "created_at")
    private Long createdAt;

    /**
     * 修改时间，秒时间戳
     */
    @Column(name = "updated_at")
    private Long updatedAt;

    /**
     * 是否删除；0：否，1： 是
     */
    @Column(name = "is_deleted")
    private Integer isDeleted;

    /**
     * 价格
     */
    private double price;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取列次名称
     *
     * @return train_no - 列次名称
     */
    public String getTrainNo() {
        return trainNo;
    }

    /**
     * 设置列次名称
     *
     * @param trainNo 列次名称
     */
    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo == null ? null : trainNo.trim();
    }

    /**
     * 获取起点站
     *
     * @return start_station - 起点站
     */
    public String getStartStation() {
        return startStation;
    }

    /**
     * 设置起点站
     *
     * @param startStation 起点站
     */
    public void setStartStation(String startStation) {
        this.startStation = startStation == null ? null : startStation.trim();
    }

    /**
     * 获取终点站
     *
     * @return end_station - 终点站
     */
    public String getEndStation() {
        return endStation;
    }

    /**
     * 设置终点站
     *
     * @param endStation 终点站
     */
    public void setEndStation(String endStation) {
        this.endStation = endStation == null ? null : endStation.trim();
    }

    /**
     * 获取发车时间
     *
     * @return start_time - 发车时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置发车时间
     *
     * @param startTime 发车时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * 获取到达时间
     *
     * @return end_time - 到达时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置到达时间
     *
     * @param endTime 到达时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * 获取运行时间
     *
     * @return run_time - 运行时间
     */
    public String getRunTime() {
        return runTime;
    }

    /**
     * 设置运行时间
     *
     * @param runTime 运行时间
     */
    public void setRunTime(String runTime) {
        this.runTime = runTime == null ? null : runTime.trim();
    }

    /**
     * 获取创建时间，秒时间戳
     *
     * @return created_at - 创建时间，秒时间戳
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间，秒时间戳
     *
     * @param createdAt 创建时间，秒时间戳
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取修改时间，秒时间戳
     *
     * @return updated_at - 修改时间，秒时间戳
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 设置修改时间，秒时间戳
     *
     * @param updatedAt 修改时间，秒时间戳
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 获取是否删除；0：否，1： 是
     *
     * @return is_deleted - 是否删除；0：否，1： 是
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除；0：否，1： 是
     *
     * @param isDeleted 是否删除；0：否，1： 是
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(double price) {
        this.price = price;
    }
}