package com.mon.aichat.model.body;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ChatV4Body {
    public boolean stream = false;
    public String type = "retrieval";
    public String model = "glm-4";
    public String request_id = "ql-"+System.currentTimeMillis();
    private List<ListItem> messages;

    public ChatV4Body(List<ListItem> prompt) {
        this.messages = prompt;
    }

    public ChatV4Body(ListItem item) {
        messages = new ArrayList<>();
        messages.add(item);

        this.type = "{\"knowledge_id\":\"1774346652367437824\""+"}";
    }

    public static class ListItem {
        private String role;
        private String content;

        public ListItem(String role, String content) {
            this.role = role;
            this.content = content;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public List<ListItem> getMessage() {
        return messages;
    }

    public void setMessage(List<ListItem> message) {
        this.messages = message;
    }

    @Override
    public String toString() {
        return "PromptBody{" +
                ", messages=" + messages +
                '}';
    }
}
