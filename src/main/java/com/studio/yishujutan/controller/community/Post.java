package com.studio.yishujutan.controller.community;

import com.studio.yishujutan.controller.tool.DateFormat;
import com.studio.yishujutan.entity.Praise;
import com.studio.yishujutan.service.EssayService;
import com.studio.yishujutan.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class Post {

    @Autowired
    PraiseService praiseService;

    @Autowired
    EssayService essayService;

    @GetMapping("/doPraise")
    public void doPraise(HttpServletRequest request){

        String essay_id = request.getParameter("essay_id");
        String user_id = request.getParameter("user_id");

        Praise praise = praiseService.isPraised(user_id,essay_id);
        if (praise != null){
            praise = new Praise(user_id, essay_id);
            praiseService.cancelPraise(praise);
            essayService.reducePraiseNumber(essay_id);
        }else {
            Date date = new Date();
            String praise_date = DateFormat.ONLY_NUMBER.format(date);
            String praise_id = user_id + praise_date;

            praise = new Praise(praise_id,user_id,essay_id,"on",praise_date);
            praiseService.doPraise(praise);
            essayService.addPraiseNumber(essay_id);
        }

    }

    @GetMapping("/doDislike")
    public void doDislike(HttpServletRequest request){

    }


}