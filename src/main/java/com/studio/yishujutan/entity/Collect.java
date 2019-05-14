package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Collect {

    private String collect_id;
    private String user_id;
    private String collect_object;
    private String object_id;
    private String collect_status;
    private String collect_category;

    public Collect() {
    }

    public Collect(String collect_id, String user_id, String collect_object, String object_id, String collect_status, String collect_category) {
        this.collect_id = collect_id;
        this.user_id = user_id;
        this.collect_object = collect_object;
        this.object_id = object_id;
        this.collect_status = collect_status;
        this.collect_category = collect_category;
    }
}
