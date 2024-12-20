package com.mon.aichat.model.dto;

import com.zhipu.oapi.service.v4.model.ChatMessage;
import com.zhipu.oapi.service.v4.model.Choice;
import com.zhipu.oapi.service.v4.model.ModelData;

import java.util.ArrayList;
import java.util.List;

public class SseChatDTO {
    public String id;
    public String model;
    public Long created;
    public List<Choice3> choices;

    public SseChatDTO(ModelData data, String id) {
        this.id = id;
        this.model = data.getModel();
        this.created = data.getCreated();

        List<Choice3> arr = new ArrayList<>();
        List<Choice> list = data.getChoices();

        for (int i = 0; i < list.size(); i++) {
            Choice cho = list.get(i);
            arr.add(new Choice3(cho));
        }
        this.choices = arr;
    }

    public SseChatDTO(String id) {
        this.id = id;
    }

    public static SseChatDTO start(String id, String model, Long created) {
        SseChatDTO dto = new SseChatDTO(id);
        List<Choice3> arr = new ArrayList<>();
        arr.add(new Choice3("assistant"));

        dto.model = model;
        dto.created = created;
        dto.choices = arr;
        return dto;
    }

    public static SseChatDTO stop(String id, String model, Long created) {
        SseChatDTO dto = new SseChatDTO(id);
        List<Choice3> arr = new ArrayList<>();
        arr.add(new Choice3());

        dto.model = model;
        dto.created = created;
        dto.choices = arr;
        return dto;
    }

    public static class Choice3 {
        public Long index;
        public String finish_reason;
        public Delta delta;

        public Choice3(Choice cho) {
            this.index = cho.getIndex();
            this.finish_reason = "";
//            this.finish_reason = cho.getFinishReason();
            ChatMessage cm = cho.getMessage();
            this.delta = new Delta(cm.getRole(), cm.getContent());
        }
        public Choice3() {
            this.index = 0L;
            this.finish_reason = "stop";
            this.delta = new Delta();
        }
        public Choice3(String role) {
            this.index = 0L;
            this.finish_reason = "";
            this.delta = new Delta(role);
        }
    }

    public static class Delta {
        public Object content;
        public String role;

        public Delta() {}

        public Delta(String role) {
            this.role = role;
        }

        public Delta(String role, Object msg) {
//            this.role = role;
            this.role = "";
            this.content = msg;
        }
    }
}
