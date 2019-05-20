package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private String user_id;
    private String password;
    private String nickname;
    private String name;
    private String sex;
    private int age;
    private int phone;
    private String wechat;
    private String idcard;
    private String status;
    private String icon;
    private String register_date;
    private String signature;
    private int follow_number;
    private int follower_number;
    private String page_bg;

    public User(String user_id, String password, String nickname, String name, String sex, int age, int phone, String wechat, String idcard, String status, String icon, String register_date, String signature, int follow_number, int follower_number, String page_bg) {
        this.user_id = user_id;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.wechat = wechat;
        this.idcard = idcard;
        this.status = status;
        this.icon = icon;
        this.register_date = register_date;
        this.signature = signature;
        this.follow_number = follow_number;
        this.follower_number = follower_number;
        this.page_bg = page_bg;
    }

    public User() {

    }
}
