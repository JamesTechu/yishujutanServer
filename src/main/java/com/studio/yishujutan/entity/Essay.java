package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Essay {

    private String essay_id;
    private String essay_title;
    private String essay_content;
    private String essay_description;
    private String user_id;
    private String issue_date;
    private String essay_status;
    private String essay_category;
    private int hot_degree;
    private int have_picture;
    private String essay_picture;
    private String circle_id;
    private int share_number;
    private int comment_number;
    private int praise_number;
    private int dislike_number;

    public Essay(String essay_id, String essay_title, String essay_content, String essay_description, String user_id, String issue_date, String essay_status, String essay_category, int hot_degree, int have_picture, String essay_picture, String circle_id, int share_number, int comment_number, int praise_number, int dislike_number) {
        this.essay_id = essay_id;
        this.essay_title = essay_title;
        this.essay_content = essay_content;
        this.essay_description = essay_description;
        this.user_id = user_id;
        this.issue_date = issue_date;
        this.essay_status = essay_status;
        this.essay_category = essay_category;
        this.hot_degree = hot_degree;
        this.have_picture = have_picture;
        this.essay_picture = essay_picture;
        this.circle_id = circle_id;
        this.share_number = share_number;
        this.comment_number = comment_number;
        this.praise_number = praise_number;
        this.dislike_number = dislike_number;
    }

    public Essay(String essay_id, String title, String content, String user_id) {
        this.essay_id = essay_id;
        this.essay_title = title;
        this.essay_content = content;
        this.user_id = user_id;
    }

    public Essay() {

    }
}
