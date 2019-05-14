package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Feedback {

    private String feedback_id;
    private String comment_content;
    private String admin_id;
    private String feedback_date;
    private String user_id;
    private String comment_status;
    private String handle_date;

    public Feedback() {
    }

    public Feedback(String feedback_id, String comment_content, String admin_id, String feedback_date, String user_id, String comment_status, String handle_date) {
        this.feedback_id = feedback_id;
        this.comment_content = comment_content;
        this.admin_id = admin_id;
        this.feedback_date = feedback_date;
        this.user_id = user_id;
        this.comment_status = comment_status;
        this.handle_date = handle_date;
    }
}
