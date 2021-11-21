package com.lmc.service;

import com.lmc.dao.TagMapper;
import com.lmc.pojo.Blog;
import com.lmc.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> getAllTag() {
        return tagMapper.getAllTag();
    }

    @Override
    public Tag getTagById(Long id) {
        return tagMapper.getTagById(id);
    }

    @Override
    public List<Tag> getTagByString(String text) {
        ArrayList<Tag> tags = new ArrayList<>();
        List<Long> longs = convertToList(text);//将字符串转换成数字集合
        for (Long aLong : longs) {
            tags.add(tagMapper.getTagById(aLong));
        }
        return tags;
    }

    @Override
    public Tag getTagByName(String name) {
        return null;
    }

    @Override
    public int addTag(Tag tag) {
        return tagMapper.addTag(tag);
    }

    @Override
    public int deleteTagById(Long id) {
        return tagMapper.deleteTagById(id);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public List<Tag> getAllTagIndex() {
        return tagMapper.getAllTagIndex();
    }

    //将字符串转换成数字集合
    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }
}
