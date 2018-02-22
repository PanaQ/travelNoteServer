package com.garfield.travelnote.dal.domain;

import javax.persistence.*;

@Table(name = "division")
public class DivisionDo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 行政区划代码
     */
    private char code;

    /**
     * 名称
     */
    private String name;

    /**
     * '行政级别 1:省/直辖市 2:地级市 3:县级市'
     */
    private Integer level;

    /**
     * 父级行政区划代码
     */
    @Column(name = "parent_code")
    private char parentCode;

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
     * 获取行政区划代码
     *
     * @return code - 行政区划代码
     */
    public char getCode() {
        return code;
    }

    /**
     * 设置行政区划代码
     *
     * @param code 行政区划代码
     */
    public void setCode(char code) {
        this.code = code;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取'行政级别 1:省/直辖市 2:地级市 3:县级市'
     *
     * @return level - '行政级别 1:省/直辖市 2:地级市 3:县级市'
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置'行政级别 1:省/直辖市 2:地级市 3:县级市'
     *
     * @param level '行政级别 1:省/直辖市 2:地级市 3:县级市'
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取父级行政区划代码
     *
     * @return parent_code - 父级行政区划代码
     */
    public char getParentCode() {
        return parentCode;
    }

    /**
     * 设置父级行政区划代码
     *
     * @param parentCode 父级行政区划代码
     */
    public void setParentCode(char parentCode) {
        this.parentCode = parentCode;
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
}