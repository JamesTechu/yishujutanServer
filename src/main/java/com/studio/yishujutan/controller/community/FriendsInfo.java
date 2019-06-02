package com.studio.yishujutan.controller.community;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.tool.Address;
import com.studio.yishujutan.controller.tool.JsonTool;
import com.studio.yishujutan.entity.Dislike;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.entity.Praise;
import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.DislikeService;
import com.studio.yishujutan.service.EssayService;
import com.studio.yishujutan.service.PraiseService;
import com.studio.yishujutan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/getUserPageInfo")
    public String doGet(String user_id, String friends_id){

        jsonTool = new JsonTool();
        User user = userService.getUserPageInfo(friends_id);
        JSONObject userinfoJson = new JSONObject();
        userinfoJson.put("page_bg", user.getPage_bg());
        userinfoJson.put("icon", address + user.getIcon());
        userinfoJson.put("nickname", user.getNickname());
        userinfoJson.put("signature", user.getSignature());
        userinfoJson.put("follow_number", user.getFollow_number());
        userinfoJson.put("follower_number", user.getFollower_number());

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


}
