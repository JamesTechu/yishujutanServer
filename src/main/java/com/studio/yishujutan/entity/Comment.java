package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

    private String comment_id;
    private String comment_content;
    private String essay_id;
    private String comment_date;
    private String user_id;
    private String comment_status;

    public Comment() {
    }

    public Comment(String comment_id, String comment_content, String essay_id, String comment_date, String user_id, String comment_status) {
        this.comment_id = comment_id;
        this.comment_content = comment_content;
        this.essay_id = essay_id;
        this.comment_date = comment_date;
        this.user_id = user_id;
        this.comment_status = comment_status;
    }
}
