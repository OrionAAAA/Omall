package com.ori.Omall.pojo;

import java.io.Serializable;

public class TbItemCat implements Serializable {
    /**
     * 类目ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     *
     * @mbg.generated
     */
    private Long parentId;

    /**
     * 类目名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 类型id
     *
     * @mbg.generated
     */
    private Long typeId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", typeId=").append(typeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}