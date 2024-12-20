package com.mon.aichat.model.entity;

public class ChatDevice {
    public long time;
    public String sn;
    public String msgId;

    public ChatDevice(String msgId) {
        this.msgId = msgId;
    }
    public ChatDevice(String sn, String msgId) {
        this.sn = sn;
        this.msgId = msgId;
    }

    public String getId() {
        return msgId;
    }
}
