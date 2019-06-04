package com.studio.yishujutan.controller.community;

import com.studio.yishujutan.controller.tool.DateFormat;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class Posting {

    @Autowired
    EssayService essayService;

    //发帖
    @PostMapping("/issue")
    public String issue(String title, String content, String user_id, String status, String circle_id){

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
        Date date = new Date();
        String essay_id = user_id + "_" + sdf.format(date);
        String issue_date = DateFormat.YMD_HMS.format(date);
        System.out.println(circle_id + status);
        com.studio.yishujutan.entity.Essay essay = new Essay(essay_id, title, content, user_id, status,circle_id);
        essay.setIssue_date(issue_date);
        essayService.insertIntoEssay(essay);

        return "插入成功";
    }
}
