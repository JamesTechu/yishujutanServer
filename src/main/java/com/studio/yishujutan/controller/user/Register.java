package com.studio.yishujutan.controller.user;

import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Register {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void register(HttpServletRequest request){

        String user_id = request.getParameter("user_id");
        String nickname = request.getParameter("nickname");
        String icon = request.getParameter("icon");

        User user = new User(user_id, nickname, icon);
        userService.register(user);


    }
}
