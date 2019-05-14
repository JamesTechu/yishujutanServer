package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Browse {

    private String browse_id;
    private String user_id;
    private String browse_object;
    private String object_id;
    private String browse_date;
    private String browse_content;
    private String book_category;

    public Browse() {
    }

    public Browse(String browse_id, String user_id, String browse_object, String object_id, String browse_date, String browse_content, String book_category) {
        this.browse_id = browse_id;
        this.user_id = user_id;
        this.browse_object = browse_object;
        this.object_id = object_id;
        this.browse_date = browse_date;
        this.browse_content = browse_content;
        this.book_category = book_category;
    }
}
