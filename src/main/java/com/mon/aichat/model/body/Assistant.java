package com.mon.aichat.model.body;

import java.util.ArrayList;
import java.util.List;

public class Assistant {
    public String assistant_id;
    public String conversation_id;
    public String model="glm-3-turbo"; // "glm-4" /glm-3-turbo
    public boolean stream;
    public List<Attach> attachments;
    public List<Msg> messages;

    public Assistant(String id, String cid, List<Attach> att, List<Msg> msg) {
        this.assistant_id = id;
        this.conversation_id = cid;
        this.attachments = att;
        this.messages = msg;
    }

    public Assistant(String id, String cid, String att, String msg) {
        this.assistant_id = id;
        this.conversation_id = cid;
        List atts = new ArrayList();
        List msgs = new ArrayList();
//        atts.add(new Attach(att));
        msgs.add(new Msg(msg));

        this.attachments = atts;
        this.messages = msgs;
    }

    public static class Msg {
        public String role;
        public List<Content> content;

        public Msg(String msg) {
            List<Content> list = new ArrayList<>();
            list.add(new Content(msg));
            this.content = list;
            this.role = "user";
        }

        @Override
        public String toString() {
            return "{" +
                    "role='" + role + '\'' +
                    ", content=" + content +
                    '}';
        }
    }

    public static class Content {
        public String type;
        public String text;

        public Content(String msg) {
            this.text = msg;
            this.type = "user";
        }

        @Override
        public String toString() {
            return "{" +
                    "type='" + type + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    public static class Attach {
        public String file_id;
        public Attach(String id) {
            this.file_id = id;
        }

        @Override
        public String toString() {
            return "{" +
                    "file_id='" + file_id + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "assistant_id='" + assistant_id + '\'' +
                ", conversation_id='" + conversation_id + '\'' +
                ", model='" + model + '\'' +
                ", stream=" + stream +
                ", attachments=" + attachments +
                ", messages=" + messages +
                '}';
    }
}
