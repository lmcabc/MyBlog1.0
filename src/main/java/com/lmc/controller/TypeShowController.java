package com.lmc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmc.pojo.Blog;
import com.lmc.pojo.Type;
import com.lmc.service.BlogService;
import com.lmc.service.TypeService;
import com.lmc.vo.firstPageBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;

    //跳转到分类，默认选择第一个分类，根据分类id查询blog显示
    @GetMapping("/types/{id}")
    public String toTypeShow(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model,
                             @PathVariable("id") Long typeId){
        List<Type> types = typeService.getAllTypeIndex();
        //从导航栏点进来就传个-1，
        if (typeId == -1){
            //令id=第一个type的id，即默认刚进去是选择第一个type
            typeId = types.get(0).getId();//get(0)获取types集合的第一个
        }
        model.addAttribute("types", types);
        List<firstPageBlog> blogs = blogService.getAllBlogByTypeId(typeId);
        PageHelper.startPage(pageNum, 6);
        PageInfo<firstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeId", typeId);
        return "types";
    }


}
