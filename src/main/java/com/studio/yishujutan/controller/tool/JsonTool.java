package com.studio.yishujutan.controller.tool;

import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.entity.User;

public class JsonTool {

    public JSONObject makeEssayJson(Essay essay, User user, String address){

        JSONObject jsonObject = makeEssayJson(essay);

        jsonObject.put("userIcon", address + user.getIcon());
        jsonObject.put("nickname", user.getNickname());

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
