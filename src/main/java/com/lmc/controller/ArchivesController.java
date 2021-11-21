package com.lmc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArchivesController {

    @GetMapping("/archives")
    public String archives(){

        return "archives";
    }
}
