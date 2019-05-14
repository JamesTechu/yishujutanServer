package com.studio.yishujutan.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.FollowService;
import com.studio.yishujutan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class GetFollows {

    @Autowired
    UserService userService;

    @Autowired
    FollowService followService;

    @GetMapping("/getFollows")
    public String getFollows(HttpServletRequest request, HttpServletResponse response){
        String user_id = request.getParameter("user_id");
        String[] follows_id = followService.getFollowsByUserID(user_id);

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        User user;
        String address = "http://yishujutan.free.idcfengye.com";
        for (int i = 0; i < follows_id.length; i++){
            user = userService.getUserIconAndNickNameById(follows_id[i]);
            jsonObject = new JSONObject();
            jsonObject.put("id", i);
            jsonObject.put("icon", address + user.getIcon());
            jsonObject.put("nickname", user.getNickname());
            jsonObject.put("lastEssay", "");
            jsonObject.put("lastEssayIssueDate", "");
            jsonArray.add(jsonObject);
        }

        return jsonArray.toString();
    }
}
