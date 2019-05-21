package com.studio.yishujutan.controller.community;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.tool.JsonTool;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.EssayService;
import com.studio.yishujutan.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetEssaysByShowType {

    @Autowired
    EssayService essayService;

    @Autowired
    UserService userService;

    private String address = "http://yishujutan.free.idcfengye.com";
    private JSONArray jsonArray;
    private JsonTool jsonTool;

    @GetMapping("/getEssaysByShowType")
    public String getEssaysByShowType(HttpServletRequest request){

        int number = Integer.parseInt(request.getParameter("number"));
        String showType = request.getParameter("showType");
        String user_id = request.getParameter("user_id");
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
        int realNumber = essays.size();
        JSONObject jsonObject;
        Essay essay;
        User user;
        jsonArray = new JSONArray();
        for (int i = 0; i < realNumber; i++){
            essay = essays.get(i);
            user = userService.getUserIconAndNickNameById(essay.getUser_id());
            jsonObject = jsonTool.makeEssayJson(essay, user, address);
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }

}
