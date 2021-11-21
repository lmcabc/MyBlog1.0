package com.lmc.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmc.pojo.Tag;
import com.lmc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    //跳转到tags
    @GetMapping("/tags")
    public String tags(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 3);
        List<Tag> allTag = tagService.getAllTag();
        PageInfo<Tag> tagPageInfo = new PageInfo<>(allTag);
        model.addAttribute("pageInfo", tagPageInfo);
        return "admin/tags";
    }

    //跳转到新增
    @GetMapping("/toAddTag")
    public String toAddTag(){
        return "admin/tag-input";
    }

    //新增标签
    @PostMapping("/addTag")
    public String addTag(Tag tag, RedirectAttributes attributes){
        Tag tagByName = tagService.getTagByName(tag.getName());
        if (tagByName != null){
            attributes.addFlashAttribute("message", "该标签也存在！！");
            return  "redirect:/admin/toAddTag";
        }
        tagService.addTag(tag);
        return "redirect:/admin/tags";
    }

    //删除标签
    @GetMapping("/deleteTag/{id}")
    public String deleteTag(@PathVariable Long id, RedirectAttributes attributes){
        tagService.deleteTagById(id);
        attributes.addFlashAttribute("message","删除成功！");
        return "redirect:/admin/tags";
    }

    //跳转到编辑
    @GetMapping("/toUpdateTag/{id}")
    public String toUpdateTag(@PathVariable Long id, Model model){
        Tag tagById = tagService.getTagById(id);
        model.addAttribute("tag", tagById);
        return "admin/tag-update";
    }

    //编辑
    @PostMapping("/updateTag")
    public String updateTag(Tag tag, RedirectAttributes attributes){
        tagService.updateTag(tag);
        attributes.addFlashAttribute("message", "修改成功！！");
        return "redirect:/admin/tags";
    }
}
