package com.lmc.dao;

import com.lmc.pojo.Blog;
import com.lmc.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {

    List<Tag> getAllTag();

    //根据id查询
    Tag getTagById(Long id);

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
