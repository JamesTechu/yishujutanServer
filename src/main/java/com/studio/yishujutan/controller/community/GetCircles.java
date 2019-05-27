package com.studio.yishujutan.controller.community;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.tool.Address;
import com.studio.yishujutan.entity.Circle;
import com.studio.yishujutan.service.BrowseService;
import com.studio.yishujutan.service.CircleService;
import com.studio.yishujutan.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class GetCircles {

    @Autowired
    CollectService collectService;

    @Autowired
    BrowseService browseService;

    @Autowired
    CircleService circleService;

    private int number = 10;
    private String address = Address.LOCAL_ADDRESS;
    private JSONObject json;
    private JSONArray jsonItem;

    @GetMapping("/getCircles")
    public String doGet(HttpServletRequest request){

        String user_id = request.getParameter("user_id");
        String[] collectIds = collectService.getCircleIds(user_id);
        String[] browseIds = browseService.getCircleIds(user_id, number);

        List<Circle> collectingCircles = circleService.getCirclesIconAndName(collectIds);
        List<Circle> browsedCircles = circleService.getCirclesIconAndName(browseIds);
        json = new JSONObject();

        int collecingCircleNumber = collectingCircles.size();
        int browsedCircleNumber = browsedCircles.size();

        jsonItem = makeJsonItem(collecingCircleNumber, collectingCircles);
        json.put("collectingCircle", jsonItem);
        jsonItem = makeJsonItem(browsedCircleNumber, browsedCircles);
        json.put("browsedCircle", jsonItem);

        return json.toString();
    }

    public JSONArray makeJsonItem(int number, List<Circle> circles){
        Circle circle;
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


