package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Praise {

    private String praise_id;
    private String user_id;
    private String essay_id;
    private String praise_status;
    private String praise_date;

    public Praise(String user_id, String essay_id) {
        this.user_id = user_id;
        this.essay_id = essay_id;
    }

    public Praise() {
    }

    public Praise(String praise_id, String user_id, String essay_id, String praise_status, String praise_date) {
        this.praise_id = praise_id;
        this.user_id = user_id;
        this.essay_id = essay_id;
        this.praise_status = praise_status;
        this.praise_date = praise_date;
    }
}
