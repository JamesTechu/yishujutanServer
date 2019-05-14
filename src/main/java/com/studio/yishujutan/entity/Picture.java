package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Picture {
    private String pic_id;
    private String pic_name;
    private double pic_size;
    private String pic_format;
    private String pic_object;
    private String object_id;
    private String pic_link;
    private int pic_sort;

    public Picture(String pic_id, String pic_name, double pic_size, String pic_format, String pic_object, String object_id, String pic_link, int pic_sort) {
        this.pic_id = pic_id;
        this.pic_name = pic_name;
        this.pic_size = pic_size;
        this.pic_format = pic_format;
        this.pic_object = pic_object;
        this.object_id = object_id;
        this.pic_link = pic_link;
        this.pic_sort = pic_sort;
    }

    public Picture() {

    }
}
