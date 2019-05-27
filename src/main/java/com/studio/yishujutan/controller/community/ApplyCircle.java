package com.studio.yishujutan.controller.community;

import com.studio.yishujutan.dao.CircleDao;
import com.studio.yishujutan.entity.Circle;
import com.studio.yishujutan.service.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ApplyCircle {

    @Autowired
    CircleService circleService;

    @PostMapping("/applyCircle")
    public void applyCircle(HttpServletRequest request){
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String reason = request.getParameter("reason");
        String description = request.getParameter("description");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        String date = simpleDateFormat.format(new Date());
        String id = String.valueOf(circleService.getMaxCircleId() + 1);

        Circle circle = new Circle(id, name, category, description, date, "applying", reason);
        circleService.applyCircle(circle);

    }
}
