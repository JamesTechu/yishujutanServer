package com.studio.yishujutan.controller.user;

import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Register {

    @Autowired
    UserService userService;

    @PostMapping("/isRegister")
    public String isRegister(String user_id){

        //String user_id = request.getParameter("user_id");

        System.out.println("处理isRegister请求时接受到的user_id：" + user_id);
        User user = userService.isRegister(user_id);
        if (user == null) {
            return "0";
        }else {
            return "1";
        }
    }

    @PostMapping("/register")
    public void register(String user_id, String nickname, String icon){

        System.out.println(user_id + "\n" + nickname + "\n" + icon);
        User user = new User(user_id, nickname, icon);
        userService.register(user);


    }
}
