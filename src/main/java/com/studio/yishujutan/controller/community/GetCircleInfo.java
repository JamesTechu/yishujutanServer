package com.studio.yishujutan.controller.community;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.tool.Address;
import com.studio.yishujutan.controller.tool.JsonTool;
import com.studio.yishujutan.entity.Circle;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.CircleService;
import com.studio.yishujutan.service.EssayService;
import com.studio.yishujutan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class GetCircleInfo {

    @Autowired
    EssayService essayService;

    @Autowired
    CircleService circleService;

    @Autowired
    UserService userService;

    private JSONObject json;        //向小程序端返回的数据
    private JSONArray jsonArray;    //用JSONArray储存Essay数据
    private int number = 0;         //返回的Essay数量，数据库中会进行乘5计算
    private String address = Address.LOCAL_ADDRESS;  //本地IP地址，速度快
    //private String address = "http://yishujutan.free.idcfengye.com";  //内网穿透，速度慢

    @GetMapping("/getCircleInfo")
    public String getCircleInfo(HttpServletRequest request){

        //获取小程序端发送的数据
        String circle_id = request.getParameter("circle_id");
        String circle_number = request.getParameter("number");
        number = Integer.parseInt(circle_number) * 5;
        json = new JSONObject();
        jsonArray = new JSONArray();

        //根据circle_id获取相应的circle信息
        Circle circle = circleService.getCircleInfo(circle_id);
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
        List<Essay> essays = essayService.selectEssaysByCircleId(circle_id, number, number + 6);
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
        JSONObject essayJson;
        for (int i = 0; i < realNumber; i++){
            essay = essays.get(i);
            user = userService.getUserIconAndNickNameById(essay.getUser_id());
            essayJson = jsonTool.makeEssayJson(essay ,user, address);
            jsonArray.add(essayJson);
        }
        json.put("essays", jsonArray);

        return json.toString();
    }
}
