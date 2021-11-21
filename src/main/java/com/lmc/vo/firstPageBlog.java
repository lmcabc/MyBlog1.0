package com.lmc.vo;

import java.util.Date;

public class firstPageBlog {
    //blog
    private Long id;
    private String title;
    private String firstPicture;
    private String description;//描述
    private Date updateTime;
    private Long views;

    //Type
    private String typeName;//标签名

    //user
    private String nickname;
    private String avatar;//头像

    public firstPageBlog() {
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

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "firstPageBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", description='" + description + '\'' +
                ", updateTime=" + updateTime +
                ", views=" + views +
                ", typeName='" + typeName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
