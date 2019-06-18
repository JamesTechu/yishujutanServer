package com.studio.yishujutan.controller.community;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.tool.Address;
import com.studio.yishujutan.controller.tool.DateFormat;
import com.studio.yishujutan.controller.tool.JsonTool;
import com.studio.yishujutan.entity.Comment;
import com.studio.yishujutan.entity.Dislike;
import com.studio.yishujutan.entity.Praise;
import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class Essay {

    String address = Address.ADDRESS;

    @Autowired
    PraiseService praiseService;

    @Autowired
    EssayService essayService;

    @Autowired
    UserService userService;

    @Autowired
    DislikeService dislikeService;

    @Autowired
    CommentService commentService;

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

    //评论
    @GetMapping("getComments")
    public String getComments(String essay_id, String user_id){

        JSONObject json = new JSONObject();

        User user = userService.getUserIconAndNickNameById(user_id);
        com.studio.yishujutan.entity.Essay essay = essayService.selectEssayByEssayId(essay_id);
        Praise praise = praiseService.isPraised(user_id, essay.getEssay_id());
        Dislike dislike = dislikeService.isDisliked(user.getUser_id(), essay.getEssay_id());

        JsonTool jsonTool = new JsonTool();
        JSONObject essayJson = jsonTool.makeEssayJson(essay, user, address, praise, dislike);

        json.put("essayinfo", essayJson);

        JSONArray jsonArray = new JSONArray();
        JSONObject commentJson;
        List<Comment> comments = commentService.getCommentsByEssayId(essay_id);
        Comment comment;
        User commentUser;
        int realNumber = comments.size();
        for (int i = 0; i < realNumber; i++){
            comment = comments.get(i);
            commentJson = new JSONObject();
            commentUser = userService.getUserIconAndNickNameById(comment.getUser_id());
            commentJson.put("comment_content", comment.getComment_content());
            commentJson.put("comment_date", comment.getComment_date());
            commentJson.put("user_icon", address + commentUser.getIcon());
            commentJson.put("nickname", commentUser.getNickname());

            jsonArray.add(commentJson);
        }
        json.put("comments", jsonArray);
        return json.toString();
    }

    //发表评论
    @PostMapping("sendComment")
    public String sendComment(String user_id, String essay_id, String content){
        Date date = new Date();
        String commnet_id = user_id + DateFormat.ONLY_NUMBER.format(date);
        String comment_date = DateFormat.YMD_HMS.format(date);
        Comment comment = new Comment(commnet_id, content, essay_id, comment_date, user_id, "on");
        commentService.insertComment(comment);

        User user = userService.getUserIconAndNickNameById(user_id);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("comment_content", content);
        jsonObject.put("comment_date", comment_date);
        jsonObject.put("user_icon", address + user.getIcon());
        jsonObject.put("nickname", user.getNickname());

        return jsonObject.toString();
    }


}
