package com.studio.yishujutan.controller.community;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.tool.Address;
import com.studio.yishujutan.controller.tool.JsonTool;
import com.studio.yishujutan.entity.Dislike;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.entity.Praise;
import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class Detail {

    private JSONObject json;        //向小程序端返回的数据
    private JSONArray jsonArray;    //用JSONArray储存Essay数据
    private int number = 0;         //返回的Essay数量，数据库中会进行乘5计算
    private String address = Address.ADDRESS;  //IP地址

    @Autowired
    CircleService circleService;

    @Autowired
    EssayService essayService;

    @Autowired
    UserService userService;

    @Autowired
    PraiseService praiseService;

    @Autowired
    DislikeService dislikeService;

    //获取圈子信息
    @GetMapping("/getCircleInfo")
    public String getCircleInfo(String circle_id, int circle_number, String user_id){

        number = circle_number * 5;
        json = new JSONObject();
        jsonArray = new JSONArray();

        //根据circle_id获取相应的circle信息
        com.studio.yishujutan.entity.Circle circle = circleService.getCircleInfo(circle_id);
        //将信息储存在JSON对象中
        JSONObject circleJson = new JSONObject();
        circleJson.put("circle_id", circle.getCircle_id());
        circleJson.put("circle_name", circle.getCircle_name());
        circleJson.put("circle_category", circle.getCircle_category());
        circleJson.put("circle_description", circle.getCircle_description());
        circleJson.put("circle_bg", address + circle.getCircle_bg());

        //将储存circle信息的essayJson对象储存于全局变量json中
        json.put("circleinfo", circleJson);

        //创建用于储存essay对象的List，并调用essayService的方法实例化
        List<com.studio.yishujutan.entity.Essay> essays = essayService.selectEssaysByCircleId(circle_id, number, number + 6);
        //获取实际查询到的essay数目
        int realNumber = essays.size();
        if (number == 0 && realNumber == 0){
            json.put("flag", "no");
        }else if (realNumber < 6){
            json.put("flag", "no more");
        }else {
            realNumber--;
            json.put("flag", "yes");
        }
        //创建工具类jsonTool，用于将一个essay对象的信息保存在JSONObject对象中
        JsonTool jsonTool = new JsonTool();
        Essay essay;
        User user;
        Praise praise;
        Dislike dislike;
        JSONObject essayJson;
        for (int i = 0; i < realNumber; i++){
            essay = essays.get(i);
            user = userService.getUserIconAndNickNameById(essay.getUser_id());
            praise = praiseService.isPraised(user_id, essay.getEssay_id());
            dislike = dislikeService.isDisliked(user.getUser_id(), essay.getEssay_id());

            essayJson = jsonTool.makeEssayJson(essay ,user, address, praise, dislike);
            jsonArray.add(essayJson);
        }
        json.put("essays", jsonArray);

        return json.toString();
    }
}
