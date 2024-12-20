package com.mon.aichat.model.dto;

import com.mon.aichat.model.entity.ChatChoice;
import com.zhipu.oapi.service.v4.model.Choice;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc:
 */
public class RobotDTO {
    public int status; // 0,1 默认1表示nlp有效
    public String error;
    public List<NLP> nlp;
    public String msg;
//    public String agent = "third";

    public static RobotDTO nlp(List<ChatChoice.ChoicesDTO> msg) {
        RobotDTO dto = new RobotDTO();
        dto.status = 1;
        List<NLP> nlp = new ArrayList<>();
        for (int i = 0; i < msg.size(); i++) {
            NLP item = new NLP();
            item.answer = msg.get(i).message.content;
            nlp.add(item);
        }
        dto.nlp = nlp;
        return dto;
    }

    public static RobotDTO nlp2(List<Choice> msg) {
        RobotDTO dto = new RobotDTO();
        dto.status = 1;
        List<NLP> nlp = new ArrayList<>();
        for (int i = 0; i < msg.size(); i++) {
            NLP item = new NLP();
            item.answer = (String) msg.get(i).getMessage().getContent();
            nlp.add(item);
        }
        dto.nlp = nlp;
        return dto;
    }

    public static class NLP {
        public String english_domain = "tell_me_why";
        public String intent = "ql_chat";
        public String action;
        public Slots slots;
        public Feed feed;
        public String source = "QinLan";
        public String answer;
    }

    public static class Feed{
        public List<SrcItem> image;
        public List<SrcItem> video;
        public List<SrcItem> audio;
        public List<Custom> custom;
        public List<Relate> relate;
    }


    public static class Slots {
        public String answer;
    }

    public static class SrcItem {
        public String src;
    }

    public static class Custom {
        public String src;
    }

    public static class Relate {
        public String text;
        public float score;
        public String src;
    }
}
