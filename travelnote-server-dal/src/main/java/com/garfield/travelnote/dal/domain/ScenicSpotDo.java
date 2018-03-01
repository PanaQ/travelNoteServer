package com.garfield.travelnote.dal.domain;

import javax.persistence.*;

@Table(name = "scenic_spot")
public class ScenicSpotDo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 行政区划id
     */
    @Column(name = "division_id")
    private Long divisionId;

    /**
     * 景点名
     */
    private String name;

    /**
     * 游览时间
     */
    @Column(name = "play_time")
    private Long playTime;

    /**
     * 经度
     */
    private double longitude;

    /**
     * 纬度
     */
    private double latitude;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Long createdAt;

    /**
     * 修改时间
     */
    @Column(name = "updated_at")
    private Long updatedAt;

    /**
     * 是否删除0：否1：是
     */
    @Column(name = "is_deleted")
    private Integer isDeleted;

    private Integer level;

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
     * 获取行政区划id
     *
     * @return division_id - 行政区划id
     */
    public Long getDivisionId() {
        return divisionId;
    }

    /**
     * 设置行政区划id
     *
     * @param divisionId 行政区划id
     */
    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    /**
     * 获取景点名
     *
     * @return name - 景点名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置景点名
     *
     * @param name 景点名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取游览时间
     *
     * @return play_time - 游览时间
     */
    public Long getPlayTime() {
        return playTime;
    }

    /**
     * 设置游览时间
     *
     * @param playTime 游览时间
     */
    public void setPlayTime(Long playTime) {
        this.playTime = playTime;
    }

    /**
     * 获取经度
     *
     * @return longitude - 经度
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取纬度
     *
     * @return latitude - 纬度
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude 纬度
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取创建时间
     *
     * @return created_at - 创建时间
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取修改时间
     *
     * @return updated_at - 修改时间
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 设置修改时间
     *
     * @param updatedAt 修改时间
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 获取是否删除0：否1：是
     *
     * @return is_deleted - 是否删除0：否1：是
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除0：否1：是
     *
     * @param isDeleted 是否删除0：否1：是
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
}