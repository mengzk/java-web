package com.mon.aichat.model.body;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc:
 */
public class RobotBody {
    public String sn;
    public String query;
    public User user_semantics; // 设备属性
    public Query query_semantics; // 参数

    public static class User {
        public String client_id;
        public String enterprise_id;
        public String device_id;
        public String deviceid;
        public String long_str;
    }
    public static class Query {
        public List<Entity> entity;
    }
    public static class Entity {
        public String text;
        public String value;
        public String tag;
        public String start_pos;
    }
}