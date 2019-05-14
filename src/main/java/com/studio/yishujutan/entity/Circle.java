package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle {

    private String circle_id;
    private String circle_name;
    private String circle_bg;
    private String circle_description;
    private String circle_category;

    public Circle() {
    }

    public Circle(String circle_id, String circle_name, String circle_bg, String circle_description, String circle_category) {
        this.circle_id = circle_id;
        this.circle_name = circle_name;
        this.circle_bg = circle_bg;
        this.circle_description = circle_description;
        this.circle_category = circle_category;
    }
}
