package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Follow {

    private String follow_id;
    private String user_id;
    private String follow_object;
    private String object_id;
    private String follow_date;

    public Follow(String follow_id, String user_id, String follow_object, String object_id, String follow_date) {
        this.follow_id = follow_id;
        this.user_id = user_id;
        this.follow_object = follow_object;
        this.object_id = object_id;
        this.follow_date = follow_date;
    }

    public Follow() {

    }
}
