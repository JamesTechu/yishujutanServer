package com.studio.yishujutan.controller.tool;

import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.entity.Praise;
import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;

public class JsonTool {

    @Autowired
    PraiseService praiseService;

    public JSONObject makeEssayJson(Essay essay, User user, String address){

        JSONObject jsonObject = makeEssayJson(essay);
        String isPraised = "";
//        Praise praise = praiseService.isPraised(user.getUser_id(), essay.getEssay_id());
//        if (praise == null){
//            isPraised = "no";
//        }else {
//            isPraised = "yes";
//        }

        jsonObject.put("userIcon", address + user.getIcon());
        jsonObject.put("nickname", user.getNickname());

        jsonObject.put("isPraised", isPraised);

        return jsonObject;
    }

    public JSONObject makeEssayJson(Essay essay){

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("essay_id", essay.getEssay_id());
        jsonObject.put("title", essay.getEssay_title());
        jsonObject.put("content", essay.getEssay_content());
        jsonObject.put("share_number", essay.getShare_number());
        jsonObject.put("comment_number", essay.getComment_number());
        jsonObject.put("praise_number", essay.getPraise_number());
        jsonObject.put("dislike_number", essay.getDislike_number());
        jsonObject.put("have_picture", essay.getHave_picture());
        jsonObject.put("essay_picture", essay.getEssay_picture());

        return jsonObject;
    }

}
