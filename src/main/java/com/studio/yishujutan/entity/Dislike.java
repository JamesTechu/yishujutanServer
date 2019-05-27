package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Dislike {

    private String dislike_id;
    private String user_id;
    private String essay_id;
    private String dislike_status;
    private String dislike_date;

    public Dislike() {
    }

    public Dislike(String dislike_id, String user_id, String essay_id, String dislike_status, String dislike_date) {
        this.dislike_id = dislike_id;
        this.user_id = user_id;
        this.essay_id = essay_id;
        this.dislike_status = dislike_status;
        this.dislike_date = dislike_date;
    }
}
