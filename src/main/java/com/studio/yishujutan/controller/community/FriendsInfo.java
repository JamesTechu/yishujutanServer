package com.studio.yishujutan.controller.community;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.tool.Address;
import com.studio.yishujutan.controller.tool.DateFormat;
import com.studio.yishujutan.controller.tool.JsonTool;
import com.studio.yishujutan.entity.*;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class FriendsInfo {

    private String address = Address.ADDRESS;
    private JsonTool jsonTool;

    @Autowired
    UserService userService;

    @Autowired
    EssayService essayService;

    @Autowired
    PraiseService praiseService;

    @Autowired
    DislikeService dislikeService;

    @Autowired
    FollowService followService;

    @GetMapping("/getUserPageInfo")
    public String doGet(String user_id, String friends_id){

        jsonTool = new JsonTool();
        User user = userService.getUserPageInfo(friends_id);
        Follow follow = followService.isFollowed(user_id, friends_id);

        JSONObject userinfoJson = new JSONObject();
        userinfoJson.put("page_bg", user.getPage_bg());
        userinfoJson.put("icon", address + user.getIcon());
        userinfoJson.put("nickname", user.getNickname());
        userinfoJson.put("signature", user.getSignature());
        userinfoJson.put("follow_number", user.getFollow_number());
        userinfoJson.put("follower_number", user.getFollower_number());
        userinfoJson.put("wechat", user.getWechat());
        if (follow != null) {
            userinfoJson.put("isFollowed", 1);
        }else {
            userinfoJson.put("isFollowed", 0);
        }

        JSONObject json = new JSONObject();
        json.put("userinfo", userinfoJson);


        JSONArray jsonArray = new JSONArray();
        JSONObject essaysJson;
        List<Essay> essays = essayService.selectEssaysById(5, friends_id);
        int realNumber = essays.size();
        Essay essay;
        Praise praise;
        Dislike dislike;

        for (int i = 0; i < realNumber; i++){
            essay = essays.get(i);
            praise = praiseService.isPraised(user_id, essay.getEssay_id());
            dislike = dislikeService.isDisliked(user.getUser_id(), essay.getEssay_id());

            essaysJson = jsonTool.makeEssayJson(essay, user, address, praise, dislike);
            jsonArray.add(essaysJson);
        }

        //HttpSession session = request.getSession();
        //session.setAttribute("userinfo", userinfoJson.toString());
        //session.setAttribute("essays", jsonArray);
        //response.sendRedirect("friendsinfo");

        json.put("essays", jsonArray);
        return json.toString();
    }

    @PostMapping("/doFollow")
    public void doFollow(int isFollowed, String user_id, String friends_id){
        Follow follow;
        if (isFollowed==0){
            Date date = new Date();
            String follow_date = DateFormat.YMD_HMS.format(date);
            String follow_id = user_id + DateFormat.ONLY_NUMBER.format(date);
            follow = new Follow(follow_id, user_id, "user", friends_id, follow_date);
            followService.doFollow(follow);
        }else {
            follow = followService.isFollowed(user_id, friends_id);
            //follow = new Follow(user_id, friends_id);
            //System.out.println(follow.getUser_id());
            followService.cancelFollow(follow);
        }
    }


}
