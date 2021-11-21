package com.lmc.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmc.pojo.Type;
import com.lmc.service.TypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 3);
        List<Type> allType = typeService.getAllType();
        PageInfo<Type> typePageInfo = new PageInfo<>(allType);
        model.addAttribute("pageInfo", typePageInfo);
        return "admin/types";
    }

    //跳转到新增
    @GetMapping("/toInputType")
    public String toInputType(){
        return "admin/type-input";
    }

    //新增
    @PostMapping("/addType")
    public String addType(Type type, RedirectAttributes attributes){
        Type typeByName = typeService.getTypeByName(type.getName());
        if (typeByName != null){
            attributes.addFlashAttribute("message", "该分类已存在！！");
            return "redirect:/admin/toInputType";
        }
        typeService.addType(type);
        attributes.addFlashAttribute("message", "添加成功");
        return "redirect:/admin/types";
    }

    //删除
    @GetMapping("/deleteType/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        typeService.deleteTypeById(id);
        attributes.addFlashAttribute("message", "删除成功！！");
        return "redirect:/admin/types";
    }

    //跳转到编辑
    @GetMapping("/toUpdateType/{id}")
    public String toUpdateType(@PathVariable Long id, Model model){
        Type typeById = typeService.getTypeById(id);
        model.addAttribute("type", typeById);
        return "admin/type-update";
    }

    //编辑
    @PostMapping("/updateType")
    public String updateType(Type type, RedirectAttributes attributes){
        typeService.updateType(type);
        attributes.addFlashAttribute("message", "修改成功！！");
        return "redirect:/admin/types";
    }
}
