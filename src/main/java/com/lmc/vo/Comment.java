package com.lmc.vo;

import com.lmc.pojo.Blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {
    private Long id;
    private String nickname;
    private String email;
    private String content;

    private String avatar;//头像
    private Date createTime;

    private Long blogId;
    private Long parentCommentId;
    private String parentNickname;

    //回复评论
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;

    private Blog blog;
}
