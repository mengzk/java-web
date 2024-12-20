package com.mon.aichat.model.body;

import java.text.SimpleDateFormat;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc:
 */
public class UseRecordBody {
    public Integer gid;
    public int did;
    public int kid;
    public String time;

    public UseRecordBody() {
        time = "2024-09-08 12:00:00";
    }

    public UseRecordBody(Integer gid, int did, int kid) {
        this.gid = gid;
        this.did = did;
        this.kid = kid;
        this.time = "2024-09-08 12:00:00";
    }
}
