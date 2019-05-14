package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resource {

    private String res_id;
    private String res_title;
    private String res_content;
    private String res_description;
    private String user_id;
    private String issue_date;
    private String res_status;
    private String res_category;
    private String res_link;

    public Resource() {
    }

    public Resource(String res_id, String res_title, String res_content, String res_description, String user_id, String issue_date, String res_status, String res_category, String res_link) {
        this.res_id = res_id;
        this.res_title = res_title;
        this.res_content = res_content;
        this.res_description = res_description;
        this.user_id = user_id;
        this.issue_date = issue_date;
        this.res_status = res_status;
        this.res_category = res_category;
        this.res_link = res_link;
    }
}
