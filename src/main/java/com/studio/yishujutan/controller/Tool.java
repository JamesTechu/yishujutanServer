package com.studio.yishujutan.controller;

import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.entity.User;

public class Tool {

    public JSONObject makeEssaysJson(Essay essay, User user, String address){

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("title", essay.getEssay_title());
        jsonObject.put("userIcon", address + user.getIcon());
        jsonObject.put("nickname", user.getNickname());
        jsonObject.put("content", essay.getEssay_content());
        jsonObject.put("share_number", 52);
        jsonObject.put("comment_number", 62);
        jsonObject.put("praise_number", 24);
        jsonObject.put("dislike_number", 83);

        return jsonObject;
    }

}
