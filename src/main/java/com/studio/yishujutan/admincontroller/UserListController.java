package com.studio.yishujutan.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserListController {
    @GetMapping("userlist")
    public ModelAndView userlist(){
        return new ModelAndView("userlist");
    }
}
