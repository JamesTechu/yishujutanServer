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
    private String apply_date;
    private String handle_date;
    private String admin_id;
    private String circle_status;
    private String circle_icon;
    private String apply_reason;

    public Circle() {
    }

    public Circle(String circle_id, String circle_name, String circle_description, String circle_category, String apply_date, String circle_status, String apply_reason) {
        this.circle_id = circle_id;
        this.circle_name = circle_name;
        this.circle_description = circle_description;
        this.circle_category = circle_category;
        this.apply_date = apply_date;
        this.circle_status = circle_status;
        this.apply_reason = apply_reason;
    }

    public Circle(String circle_id, String circle_name, String circle_bg, String circle_description, String circle_category, String apply_date, String handle_date, String admin_id, String circle_status, String circle_icon, String apply_reason) {
        this.circle_id = circle_id;
        this.circle_name = circle_name;
        this.circle_bg = circle_bg;
        this.circle_description = circle_description;
        this.circle_category = circle_category;
        this.apply_date = apply_date;
        this.handle_date = handle_date;
        this.admin_id = admin_id;
        this.circle_status = circle_status;
        this.circle_icon = circle_icon;
        this.apply_reason = apply_reason;
    }
}