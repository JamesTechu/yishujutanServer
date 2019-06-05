package com.studio.yishujutan.controller.administrator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspTest {

    @RequestMapping("/")
    public String test(){
        return "index";
    }
}
