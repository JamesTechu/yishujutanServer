package com.studio.yishujutan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class GetOpenId {

    @GetMapping("getOpenId")
    public String getOpenId(HttpServletRequest request){
        String data = request.getParameter("data");
        return data;
    }
}
