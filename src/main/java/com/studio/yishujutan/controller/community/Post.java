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

import java.util.List;

@RestController
public class Post {

    private String address = Address.ADDRESS;
    private JSONArray jsonArray;
    private JsonTool jsonTool;
    private int realNumber;
    private JSONObject jsonObject;
    private Essay essay;
    private User user;
    private Praise praise;
    private Dislike dislike;

    @Autowired
    EssayService essayService;

    @Autowired
    UserService userService;

    @Autowired
    PraiseService praiseService;

    @Autowired
    DislikeService dislikeService;

    //根据要显示的类型获取帖子
    @GetMapping("/getEssaysByShowType")
    public String getEssaysByShowType(String user_id, int number, String showType){

        jsonTool = new JsonTool();

        List<Essay> essays = null;
        switch (showType){
            case "f":
                essays = essayService.selectEssaysByFollows(number, user_id);
                break;
            case "r":
                break;
            case "h":
                essays = essayService.selectEssaysByHotDegree(number);
                break;
        }
        if (essays == null) {
            return "no essay";
        }

        realNumber = essays.size();
        jsonArray = new JSONArray();

        for (int i = 0; i < realNumber; i++){
            essay = essays.get(i);
            user = userService.getUserIconAndNickNameById(essay.getUser_id());
            praise = praiseService.isPraised(user_id, essay.getEssay_id());
            dislike = dislikeService.isDisliked(user_id, essay.getEssay_id());

            jsonObject = jsonTool.makeEssayJson(essay, user, address, praise, dislike);
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }

    @GetMapping("searchEssay")
    public String searchEssay(String key, String user_id){

        jsonTool = new JsonTool();
        List<Essay> essays = essayService.selectEssaysFuzzily(key);
        realNumber = essays.size();
        jsonArray = new JSONArray();

        for (int i = 0; i < realNumber; i++){
            essay = essays.get(i);
            user = userService.getUserIconAndNickNameById(essay.getUser_id());
            praise = praiseService.isPraised(user_id, essay.getEssay_id());
            dislike = dislikeService.isDisliked(user_id, essay.getEssay_id());

            jsonObject = jsonTool.makeEssayJson(essay, user, address, praise, dislike);
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }

}
