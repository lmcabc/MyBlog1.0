package com.lmc.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmc.pojo.Blog;
import com.lmc.pojo.User;
import com.lmc.service.BlogService;
import com.lmc.service.TagService;
import com.lmc.service.TypeService;
import com.lmc.vo.QueryBlog;
import com.lmc.vo.SearchBlog;
import com.lmc.vo.ShowBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    //加载类型和标签
    public void setTypeAndTag(Model model){
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("tags", tagService.getAllTag());
    }

    //显示
    @GetMapping("/blogs")
    public String blogPage(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //defaultValue = "1",value = "pageNum"默认值是1，首页，前端会传页数参数过来
        PageHelper.startPage(pageNum, 3);//(第几页，每页数据数)
        List<QueryBlog> QueryBlogs = blogService.getAllQueryBlog();
        //把查到的分页数据放到pageInfo里，这个对象有许多属性可以操作分页数据
        PageInfo<QueryBlog> pageInfo = new PageInfo<>(QueryBlogs);
        model.addAttribute("pageInfo", pageInfo);
        setTypeAndTag(model);
        return "admin/blogs";
    }

    //去新增，同时加载类型和标签选项
    @GetMapping("/toInput")
    public String toInput(Model model){
        setTypeAndTag(model);
        return "admin/blogs-input";
    }

    //提交保存新增
    @PostMapping("/blogs")
    public String input(Blog blog, HttpSession session, RedirectAttributes attributes){
        //从session中获取user进行保存
        blog.setUser((User) session.getAttribute("user"));
        //一对一关系，从前端的blog中获取type的id，在通过dao保存
        blog.setType(typeService.getTypeById(blog.getType().getId()));
        blog.setTypeId(blog.getType().getId());
        //一对多关系，
        blog.setTags(tagService.getTagByString(blog.getTagIds()));
        //设置用户id
        blog.setUserId(blog.getUser().getId());
        blogService.addBlog(blog);
        attributes.addFlashAttribute("message", "新增成功!");
        return "redirect:/admin/blogs";
    }

    //删除
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        blogService.deleteBlogById(id);
        attributes.addFlashAttribute("message", "删除成功!");
        return "redirect:/admin/blogs";
    }

    //搜索
    @PostMapping("/search")
    public String search(SearchBlog searchBlog, Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //将recommend转换一下
        blogService.transformRecommend(searchBlog);
        //动态sql解决三条件搜索
        List<QueryBlog> Blogs = blogService.searchByTitleOrTypeOrRecommend(searchBlog);
        PageHelper.startPage(pageNum, 3);
        PageInfo<QueryBlog> pageInfo = new PageInfo<>(Blogs);
        model.addAttribute("pageInfo", pageInfo);
        setTypeAndTag(model);
        model.addAttribute("message", "查询成功!!");
        return "admin/blogs";
    }

    //跳转到编辑
    @GetMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable Long id, Model model){
        ShowBlog showBlog = blogService.getShowBlogById(id);
        model.addAttribute("blog",showBlog);
        setTypeAndTag(model);
        return "admin/blogs-update";
    }

    @PostMapping("/update")
    public String update(ShowBlog showBlog, RedirectAttributes attributes){
        blogService.updateShowBlog(showBlog);
        attributes.addFlashAttribute("message", "修改成功!");
        return "redirect:/admin/blogs";
    }


}
