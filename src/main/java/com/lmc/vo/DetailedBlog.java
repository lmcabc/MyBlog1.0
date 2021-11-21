package com.lmc.vo;

import com.lmc.pojo.Tag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetailedBlog {
    private Long id;
    //user
    private String nickname;
    private String avatar;

    //blog
    private Date updateTime;
    private Integer views;
    private String firstPicture;
    private String content;
    private String title;
    private String flag;
    private boolean commentabled;
    private boolean shareStatement;
    private boolean appreciation;

    private List<Tag> tags = new ArrayList<>();

    public DetailedBlog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "DetailedBlog{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", updateTime=" + updateTime +
                ", views=" + views +
                ", firstPicture='" + firstPicture + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", flag='" + flag + '\'' +
                ", commentabled=" + commentabled +
                ", shareStatement=" + shareStatement +
                ", appreciation=" + appreciation +
                ", tags=" + tags +
                '}';
    }
}
