package com.studio.yishujutan.admincontroller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.studio.yishujutan.entity.Book;
import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class UserListController {

    @Autowired
    private UserService userService;

    @GetMapping("userlist")
    public ModelAndView booklist(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                 Map<String, Object> map) {
        PageHelper.startPage(currentPage, pageSize);
        List<User> userList = userService.getAlluser();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        map.put("userlist", pageInfo);
        map.put("currentPage", currentPage);
        return new ModelAndView("user/userlist");
    }
}
