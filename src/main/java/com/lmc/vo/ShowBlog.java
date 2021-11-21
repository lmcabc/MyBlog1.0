package com.lmc.vo;

import com.lmc.pojo.Type;

import java.util.Date;

public class ShowBlog {
    private Long id;
    private String title;
    private String flag;
    private String content;
    private Long typeId;
    private String tagIds;
    private String firstPicture;
    private String description;
    private Date updateTime;
    private boolean recommend;//推荐
    private boolean published;//发表或草稿
    private boolean commentabled;//评论
    private boolean shareStatement;//分享声明
    private boolean appreciation;//赞赏

    public ShowBlog() {
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTypeId() {
        return typeId;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
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

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
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

    @Override
    public String toString() {
        return "ShowBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", flag='" + flag + '\'' +
                ", content='" + content + '\'' +
                ", typeId=" + typeId +
                ", tagIds='" + tagIds + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", description='" + description + '\'' +
                ", updateTime=" + updateTime +
                ", recommend=" + recommend +
                ", published=" + published +
                ", commentabled=" + commentabled +
                ", shareStatement=" + shareStatement +
                ", appreciation=" + appreciation +
                '}';
    }
}
