package com.studio.yishujutan.entity;

public class Interest {

    private String interest_id;
    private String interest_content;
    private String user_id;
    private String interest_category;

    public Interest() {
    }

    public Interest(String interest_id, String interest_content, String user_id, String interest_category) {
        this.interest_id = interest_id;
        this.interest_content = interest_content;
        this.user_id = user_id;
        this.interest_category = interest_category;
    }
}
