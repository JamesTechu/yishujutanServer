package com.studio.yishujutan.controller.user;

import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IsRegister {

    @Autowired
    UserService userService;

    @PostMapping("/isRegister")
    public String isRegister(HttpServletRequest request){

        String user_id = request.getParameter("user_id");
        User user = userService.isRegister(user_id);
        if (user == null) {
            return "0";
        }else {
            return "1";
        }
    }
}
