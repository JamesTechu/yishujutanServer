package com.studio.yishujutan.controller.community;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.tool.Address;
import com.studio.yishujutan.controller.tool.JsonTool;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.EssayService;
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

    @GetMapping("/getUserPageInfo")
    public String doGet(HttpServletRequest request){

        jsonTool = new JsonTool();
        String user_id = request.getParameter("user_id");
        User user = userService.getUserPageInfo(user_id);
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
        List<Essay> essays = essayService.selectEssaysById(5, user_id);
        int realNumber = essays.size();
        Essay essay;
        for (int i = 0; i < realNumber; i++){
            essay = essays.get(i);
            essaysJson = jsonTool.makeEssayJson(essay, user, address);
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
