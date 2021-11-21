package com.lmc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmc.pojo.Blog;
import com.lmc.pojo.Tag;
import com.lmc.pojo.Type;
import com.lmc.service.BlogService;
import com.lmc.service.TagService;
import com.lmc.vo.firstPageBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TagShowController {
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogService blogService;

    //跳转到分类，默认选择第一个分类，根据分类id查询blog显示
    @GetMapping("/tags/{id}")
    public String toTypeShow(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model,
                             @PathVariable("id") Long TagId){
        List<Tag> tags = tagService.getAllTagIndex();
        //从导航栏点进来就传个-1，
        if (TagId == -1){
            //令id=第一个type的id，即默认刚进去是选择第一个type
            TagId = tags.get(0).getId();//get(0)获取types集合的第一个
        }
        model.addAttribute("tags", tags);
        List<firstPageBlog> blogs = blogService.getAllBlogByTagId(TagId);
        PageHelper.startPage(pageNum, 6);
        PageInfo<firstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTagId", TagId);
        return "tags";
    }

}
