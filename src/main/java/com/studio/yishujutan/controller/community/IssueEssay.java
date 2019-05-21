package com.studio.yishujutan.controller.community;

import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class IssueEssay {

    @Autowired
    EssayService essayService;

    @PostMapping("/issue")
    public String issue(HttpServletRequest request, HttpServletResponse response){

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String user_id = request.getParameter("user_id");

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
        Date date = new Date();
        String essay_id = user_id + "_" + sdf.format(date);

        Essay essay = new Essay(essay_id, title, content, user_id);
        essayService.insertIntoEssay(essay);

        return "插入成功";
    }
}
