package com.studio.yishujutan.controller.community;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.tool.Address;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.EssayService;
import com.studio.yishujutan.service.FollowService;
import com.studio.yishujutan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class GetFollows {

    @Autowired
    UserService userService;

    @Autowired
    FollowService followService;

    @Autowired
    EssayService essayService;

    private String address = Address.LOCAL_ADDRESS;

    @GetMapping("/getFollows")
    public String getFollows(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        String user_id = request.getParameter("user_id");
        String[] follows_id = followService.getFollowsByUserID(user_id);

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        User user;
        Essay essay;

        for (int i = 0; i < follows_id.length; i++){
            user = userService.getUserIconAndNickNameById(follows_id[i]);
            essay = essayService.selectLastEssayById(user.getUser_id());
            jsonObject = new JSONObject();
            jsonObject.put("id", i);
            jsonObject.put("user_id", user.getUser_id());
            jsonObject.put("icon", address + user.getIcon());
            jsonObject.put("nickname", user.getNickname());
            String content;
            String date;
            if (essay == null) {
                content = "";
                date = "";
            }else {
                content = essay.getEssay_content();
                date = getTimeDiffer(essay.getIssue_date());
            }
            if (content.length() > 33) {
                content = content.substring(0, 33);
                content = content + "......";
            }
            jsonObject.put("lastEssay", content);
            jsonObject.put("lastEssayIssueDate", date);
            jsonArray.add(jsonObject);
        }

        return jsonArray.toString();
    }

    public String getTimeDiffer(String issueTime) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");
        Date issueDate = simpleDateFormat.parse(issueTime);
        Date now = new Date();
        long timeDiffer = (now.getTime() - issueDate.getTime()) / (1000 * 60 * 60 * 24);
        if (timeDiffer < 7) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(issueDate);
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            switch (day) {
                case 1:
                    return "星期一";
                case 2:
                    return "星期二";
                case 3:
                    return "星期三";
                case 4:
                    return "星期四";
                case 5:
                    return "星期五";
                case 6:
                    return "星期六";
                case 7:
                    return "星期日";
            }

        }else {
            simpleDateFormat = new SimpleDateFormat("MM-dd");
            return simpleDateFormat.format(issueDate);
        }
        return "error";
    }
}
