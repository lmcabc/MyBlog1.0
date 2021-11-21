package com.lmc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmc.pojo.Blog;
import com.lmc.pojo.Tag;
import com.lmc.pojo.Type;
import com.lmc.service.BlogService;
import com.lmc.service.TagService;
import com.lmc.service.TypeService;
import com.lmc.vo.QueryBlog;
import com.lmc.vo.RecommendBlog;
import com.lmc.vo.firstPageBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 8);
        List<firstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        List<Type> allTypeIndex = typeService.getAllTypeIndex();
        List<Tag> allTagIndex = tagService.getAllTagIndex();
        List<RecommendBlog> recommendBlog = blogService.getRecommendBlog();
        PageInfo<firstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("types", allTypeIndex);
        model.addAttribute("tags", allTagIndex);
        model.addAttribute("recommendBlog", recommendBlog);
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam String query,
                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        List<firstPageBlog> searchBlog = blogService.getSearchBlog(query);
        PageHelper.startPage(pageNum, 12);
        PageInfo<firstPageBlog> pageInfo = new PageInfo<firstPageBlog>(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);//用于搜索完后显示在框内的搜索词
        return "search";
    }
}
