package com.studio.yishujutan.controller.community;

import com.studio.yishujutan.controller.tool.DateFormat;
import com.studio.yishujutan.entity.Praise;
import com.studio.yishujutan.service.EssayService;
import com.studio.yishujutan.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Essay {

    @Autowired
    PraiseService praiseService;

    @Autowired
    EssayService essayService;

    //点赞和取消点赞
    @PostMapping("/doPraise")
    public void doPraise(String user_id, String essay_id, String isPraised){

        Praise praise;
        if (Integer.parseInt(isPraised) == 0){
            Date date = new Date();
            String praise_date = DateFormat.ONLY_NUMBER.format(date);
            String praise_id = user_id + praise_date;

            praise = new Praise(praise_id,user_id,essay_id,"on",praise_date);
            praiseService.doPraise(praise);
            essayService.addPraiseNumber(essay_id);
        }else {
            praise = new Praise(user_id, essay_id);
            praiseService.cancelPraise(praise);
            essayService.reducePraiseNumber(essay_id);
        }
    }

    //踩和取消踩
    @GetMapping("/doDislike")
    public void doDislike(){

    }


}
