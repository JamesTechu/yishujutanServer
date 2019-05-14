package com.studio.yishujutan.controller;

import com.studio.yishujutan.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserIcon {

    @Autowired
    PictureService pictureService;

    @GetMapping("/getIcon")
    public String getIcon(){
        String user_id = "rzz";
        String iconAddress = pictureService.getUserIconUrl(user_id);
        String iconUrl = "http://127.0.0.1:8080" + iconAddress;
        String response = "<img src='" + iconUrl + "'/>";
        return response;
    }
}
