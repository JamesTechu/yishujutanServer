package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Book {

    private String book_id;
    private String book_name;
    private String user_id;
    private String issue_date;
    private String book_status;
    private String book_description;
    private double book_price;
    private String duration;
    private String book_category;
    private String book_press;
    private String book_picture;
    public Book(String book_id, String book_name, String user_id, String issue_date, String book_status, String book_description, double book_price, String duration, String book_category, String book_press, String book_picture) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.user_id = user_id;
        this.issue_date = issue_date;
        this.book_status = book_status;
        this.book_description = book_description;
        this.book_price = book_price;
        this.duration = duration;
        this.book_category = book_category;
        this.book_press = book_press;
        this.book_picture = book_picture;
    }

    public Book() {
    }
}
