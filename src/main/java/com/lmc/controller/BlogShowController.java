package com.lmc.controller;

import com.lmc.service.BlogService;
import com.lmc.service.TagService;
import com.lmc.service.TypeService;
import com.lmc.vo.DetailedBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BlogShowController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model){
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
        model.addAttribute("blog", detailedBlog);
        return "blog";
    }

}
