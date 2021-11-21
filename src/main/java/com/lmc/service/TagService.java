package com.lmc.service;

import com.lmc.pojo.Blog;
import com.lmc.pojo.Tag;
import com.lmc.pojo.Type;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TagService {

    List<Tag> getAllTag();

    //根据id查询
    Tag getTagById(Long id);

    //根据String查询
    List<Tag> getTagByString(String text);

    //根据name查询tag
    Tag getTagByName(String name);

    //新增
    int addTag(Tag tag);

    //删除
    int deleteTagById(Long id);

    //修改tag
    int updateTag(Tag tag);

    //获取所有tag，包括blogs
    List<Tag> getAllTagIndex();
}
