package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Share {

    private String share_id;
    private String share_content;
    private String user_id;
    private String share_status;
    private String share_category;
    private String share_link;

    public Share() {
    }

    public Share(String share_id, String share_content, String user_id, String share_status, String share_category, String share_link) {
        this.share_id = share_id;
        this.share_content = share_content;
        this.user_id = user_id;
        this.share_status = share_status;
        this.share_category = share_category;
        this.share_link = share_link;
    }
}
