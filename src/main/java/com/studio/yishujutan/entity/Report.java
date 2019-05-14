package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Report {

    private String report_id;
    private String user_id;
    private String report_object;
    private String object_id;
    private String report_reason;
    private String admin_id;
    private String report_result;
    private String handle_date;

    public Report() {
    }

    public Report(String report_id, String user_id, String report_object, String object_id, String report_reason, String admin_id, String report_result, String handle_date) {
        this.report_id = report_id;
        this.user_id = user_id;
        this.report_object = report_object;
        this.object_id = object_id;
        this.report_reason = report_reason;
        this.admin_id = admin_id;
        this.report_result = report_result;
        this.handle_date = handle_date;
    }
}
