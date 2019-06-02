package com.studio.yishujutan.controller.community;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.tool.Address;
import com.studio.yishujutan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class Circle {

    private int number = 10;
    private String address = Address.ADDRESS;
    private JSONObject json;
    private JSONArray jsonItem;

    @Autowired
    CircleService circleService;

    @Autowired
    CollectService collectService;

    @Autowired
    BrowseService browseService;

    //申请圈子
    @PostMapping("/applyCircle")
    public void applyCircle(HttpServletRequest request){
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String reason = request.getParameter("reason");
        String description = request.getParameter("description");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        String id = String.valueOf(circleService.getMaxCircleId() + 1);

        com.studio.yishujutan.entity.Circle circle = new com.studio.yishujutan.entity.Circle(id, name, category, description, date, "applying", reason);
        circleService.applyCircle(circle);

    }

    //获取关注的以及浏览过的圈子信息
    @GetMapping("/getCircles")
    public String getCircles(String user_id){

        String[] collectIds = collectService.getCircleIds(user_id);
        String[] browseIds = browseService.getCircleIds(user_id, number);

        List<com.studio.yishujutan.entity.Circle> collectingCircles = circleService.getCirclesIconAndName(collectIds);
        List<com.studio.yishujutan.entity.Circle> browsedCircles = circleService.getCirclesIconAndName(browseIds);
        json = new JSONObject();

        int collecingCircleNumber = collectingCircles.size();
        int browsedCircleNumber = browsedCircles.size();

        jsonItem = makeJsonItem(collecingCircleNumber, collectingCircles);
        json.put("collectingCircle", jsonItem);
        jsonItem = makeJsonItem(browsedCircleNumber, browsedCircles);
        json.put("browsedCircle", jsonItem);

        return json.toString();
    }

    public JSONArray makeJsonItem(int number, List<com.studio.yishujutan.entity.Circle> circles){
        com.studio.yishujutan.entity.Circle circle;
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        for (int i = 0; i < number; i++){
            circle = circles.get(i);
            jsonObject = new JSONObject();
            jsonObject.put("circle_id", circle.getCircle_id());
            jsonObject.put("circle_icon", address + circle.getCircle_icon());
            jsonObject.put("circle_name", circle.getCircle_name());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

}
