package com.lmc.vo;

import com.lmc.pojo.Type;

import java.util.Date;

//blogs显示数据
public class QueryBlog {
    private Long id;
    private String title;
    private Type type;
    private Integer recommend;//推荐
    private Date updateTime;
    private String typeId;
    private boolean published;//是否发布

    public QueryBlog() {
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "QueryBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", recommend=" + recommend +
                ", updateTime=" + updateTime +
                ", typeId='" + typeId + '\'' +
                ", published=" + published +
                '}';
    }
}
